import java.util.*;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList dotComList = new ArrayList();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("pets.com");
        DotCom two = new DotCom();
        two.setName("etoys.com");
        DotCom three = new DotCom();
        three.setName("go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Try to sink all in the fewest number of guesses.");

        for (int i = 0; i < dotComList.size(); i++) {
            ArrayList newLocation = helper.placeDotCom(3);
            DotCom dotComToSet = (DotCom) dotComList.get(i);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {

        while (!dotComList.isEmpty()) {

            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);

        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {

        numOfGuesses++;

        String result = "miss";

        for (int i = 0; i < dotComList.size(); i++) {

            DotCom dotComToTest = (DotCom) dotComList.get(i);
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComList.remove(i);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        
        System.out.println("All Dot Coms are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank!");
        } else {
            System.out.println("Took you long enough, " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }


    public static void main (String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
