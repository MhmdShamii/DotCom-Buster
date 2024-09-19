import java.util.*;

public class dotComBust {
    private gameHelper GameRunner = new gameHelper();
    private ArrayList<dotCom> dotcoms = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        dotCom site1 = new dotCom();
        dotCom site2 = new dotCom();
        dotCom site3 = new dotCom();

        site1.setName("Google.com");
        site2.setName("Facebook.com");
        site3.setName("Instagram.com");

        dotcoms.add(site1);
        dotcoms.add(site2);
        dotcoms.add(site3);

        for (dotCom dotCom : dotcoms) {
            ArrayList<String> locations = GameRunner.placeDotCom(3);
            dotCom.setLocation(locations);
        }

        System.out.println("Your mission is to sink the dotcoms and send them to 404 world :");
        System.out.println("- " + site1.getName() + "\n- " + site2.getName() + "\n- " + site3.getName());
        System.out.println("Try to sink all of them in the fewest num of guesses");
    }

    public void startPlaying() {
        while (!dotcoms.isEmpty()) {
            String guess = GameRunner.getValue("Enter Your Guess : ");
            checkUserGuess(guess);
        }
        finishGame();
    }

    private void checkUserGuess(String guess) {
        numOfGuesses++;
        String result = "miss";
        for (dotCom dotCom : dotcoms) {
            result = dotCom.checkYourSelf(guess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("Kill")) {
                dotcoms.remove(dotCom);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("404 All dotcoms are down, your internet is worthless now. ");
        if (numOfGuesses <= 18) {
            System.out.println("You only took " + numOfGuesses + " to sink all the dotcoms.");
            System.out.println("You are out congrants !");
        } else {
            System.out.println("Took long enugh, " + numOfGuesses + " to sink all the dotcoms.");
            System.out.println("Almost dance with a shakr next to Titanic !!");
        }
    }
}
