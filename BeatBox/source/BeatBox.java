
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.midi.*;
import java.io.*;
import java.net.*;

public class BeatBox implements MetaEventListener {

    JFrame frame;
    JPanel mainPanel;
    JList incomingList;
    JTextField userMessage;
    ArrayList checkboxList;
    int bpm = 120;
    int nextNum;
    Vector listVector = new Vector();
    String userName;
    ObjectOutputStream out;
    ObjectInputStream in;

    HashMap otherSeqsMap = new HashMap();

    Sequencer sequencer;
    Sequence sequence;
    Sequence mySequence = null;

    Track track;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", 
        "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo",
        "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
        "Low-mid Tom", "High Agogo", "Open Hi Conga"};

   int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

   public static void main( String[] args ) {
       new BeatBox().startUp(args[0]);
   }

   public void startUp(String name) {
       userName = name;
       // open conn to server
       try {
           Socket s = new Socket("127.0.0.1", 5000);
           out = new ObjectOutputStream(s.getOutputStream());
           in = new ObjectInputStream(s.getInputStream());
           Thread remote = new Thread(new RemoteReader());
           remote.start();
       } catch (Exception ex) {
           System.out.println("Couldn't connect, you'll have to play alone");
       }
       setUpMidi();
       buildGui();
   }

   public void buildGui() {
       frame = new JFrame("Cyber BeatBox");
       BorderLayout layout = new BorderLayout();
       JPanel background = new JPanel(layout);
       background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

       checkboxList = new ArrayList();

       Box buttonBox = new Box(BoxLayout.Y_AXIS);

       JButton start = new JButton("Start");
       start.addActionListener(new MyStartListener());
       buttonBox.add(start);

       JButton stop = new JButton("Stop");
       stop.addActionListener(new MyStopListener());
       buttonBox.add(stop);

       JButton upTempo = new JButton("Tempo Up");
       upTempo.addActionListener(new MyUpTempoListener());
       buttonBox.add(upTempo);

       JButton downTempo = new JButton("Tempo Down");
       downTempo.addActionListener(new MyDownTempoListener());
       buttonBox.add(downTempo);

       JButton sendIt = new JButton("Send It");
       sendIt.addActionListener(new MySendListener());
       buttonBox.add(sendIt);

       userMessage = new JTextField();
       buttonBox.add(userMessage);

       incomingList = new JList();
       incomingList.addListSelectionListener(new MyListSelectionListener());
       incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       JScrollPane theList = new JScrollPane(incomingList);
       buttonBox.add(theList);
       incomingList.setListData(listVector);

       Box nameBox = new Box(BoxLayout.Y_AXIS);
       for (int i = 0; i < 16; i++) {
           nameBox.add(new Label(instrumentNames[i]));
       }

       background.add(BorderLayout.EAST, buttonBox);
       background.add(BorderLayout.WEST, nameBox);
       frame.getContentPane().add(background);

       GridLayout grid = new GridLayout(16,16);
       grid.setVgap(1);
       grid.setHgap(2);

       mainPanel = new JPanel(grid);
       background.add(BorderLayout.CENTER, mainPanel);

       for (int i = 0; i < 256; i++) {
           JCheckBox c = new JCheckBox();
           c.setSelected(false);
           checkboxList.add(c);
           mainPanel.add(c);
       }
       
       frame.setBounds(50,50,300,300);
       frame.pack();
       frame.setVisible(true);
   }

   public void setUpMidi() {
       try {
           sequencer = MidiSystem.getSequencer();
           sequencer.open();
           sequencer.addMetaEventListener(this);
           sequence = new Sequence(Sequence.PPQ, 4);
           track = sequence.createTrack();
           sequencer.setTempoInBPM(bpm);
       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }

   public void buildTrackAndStart() {
       ArrayList trackList = null;

       // remove old track, make fresh one
       sequence.deleteTrack(track);
       track = sequence.createTrack();

       for (int i = 0; i < 16; i++) {
           trackList = new ArrayList();
           for (int j = 0; j < 16; j++) {
               JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
               if (jc.isSelected()) {
                   int key = instruments[i];
                   trackList.add(new Integer(key));
               } else {
                   trackList.add(null);
               }
           }
           makeTracks(trackList);
       }

       track.add(makeEvent(192,9,1,0,15));

       try {
           sequencer.setSequence(sequence);
           sequencer.start();
           sequencer.setTempoInBPM(bpm);
       } catch (Exception e) {
           e.printStackTrace();
       }

   }

   public class MyStartListener implements ActionListener {
       public void actionPerformed(ActionEvent a) {
           buildTrackAndStart();
       }
   }

   public class MyStopListener implements ActionListener {
       public void actionPerformed(ActionEvent a) {
           sequencer.stop();
       }
   }

   public class MyUpTempoListener implements ActionListener {
       public void actionPerformed(ActionEvent a) {
           bpm += 3;
       }
   }

   public class MyDownTempoListener implements ActionListener {
       public void actionPerformed(ActionEvent a) {
           bpm -= 3;
       }
   }

    public class MySendListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            boolean[] checkboxState = new boolean[256];

            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) {
                    checkboxState[i] = true;
                }
            }

            String messageToSend = null;

            try {
                out.writeObject(userName + nextNum++ + ": " + userMessage.getText());
                out.writeObject(checkboxState);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            userMessage.setText("");
        }
    }

    public class MyListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent listEvent) {
            if (!listEvent.getValueIsAdjusting()) {
                String selected = (String) incomingList.getSelectedValue();
                if (selected != null) {
                    boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }

    public class RemoteReader implements Runnable {
        boolean[] checkboxState = null;
        String nameToShow = null;
        Object obj = null;
        public void run() {
            try {
                while((obj=in.readObject()) != null) {
                    String nameToShow = (String) obj;
                    checkboxState = (boolean[]) in.readObject();
                    otherSeqsMap.put(nameToShow, checkboxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void changeSequence(boolean[] checkboxState) {
        for (int i = 0; i < 256; i++) {
            JCheckBox check = (JCheckBox) checkboxList.get(i);
            if (checkboxState[i]) {
                check.setSelected(true);
            } else {
                check.setSelected(false);
            }
        }
    }

   
   public void makeTracks(ArrayList list) {
       Iterator it = list.iterator();

       for (int i = 0; i < 16; i++) {
           Integer num = (Integer) it.next(); 

           if (num != null) {
               int key = num.intValue();
               track.add(makeEvent(144,9,key,100, i));
               track.add(makeEvent(128,9,key,100,i+1));
           }
       }
   }

   public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
       MidiEvent event = null;
       try {
           ShortMessage a = new ShortMessage();
           a.setMessage(comd, chan, one, two);
           event = new MidiEvent(a, tick);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return event;
   }

   public void meta(MetaMessage message) {
       if (message.getType() == 47) {
           sequencer.start();
           sequencer.setTempoInBPM(bpm);
       }
   }

}

