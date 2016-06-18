import java.util.ArrayList;

public class SimpleDotComGame {

    public static void main (String[] args) {

        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        DotCom theDotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5);
        ArrayList locs = new ArrayList();
        for (int x = 0; x < 2; x++) {
            String num = (String) (randomNum + x);
            locs.add(num);
        }
        theDotCom.setLocationCells(locs);
        boolean isAlive = true;

        while (isAlive == true) {
            String guess = helper.getUserInput("Enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println(numOfGuesses + " guesses");
            } // close if
        } // close while

    } // close main
}
