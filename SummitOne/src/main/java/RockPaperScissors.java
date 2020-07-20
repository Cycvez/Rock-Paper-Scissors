
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class RockPaperScissors {

    static Scanner sc = new Scanner(System.in);

    // static int will store results of game
    // will probably cause problems once playAgain loop is fixxed and user wants
    // to play the game again. If logic is correct the counter will not reset, after
    // games
    // fix after fixing playAgain() loop
    // Resolved playAgain() Loop..... above notes are accurate,
    // counter keep going after each game.
    // possible solution is to update method getResults() to reset
    // after each game if the user decide to play again
    // kinda cool to also keep track of the W/L of all games played
    // BONUS return W/L ratio. (dont forget Draws affect W/L R)
    
    static int wins;
    static int losses;
    static int draws;

    public static void main(String[] args) {

        int wantToPlay = 0;
        boolean again = true;

        // ask user if he wants to play or not
        do {

            System.out.println("\nDo you want to play Rock paper scissors?");
            System.out.println("type = 1 for YES \ntype = 2 for NO");

            try {
                wantToPlay = Integer.parseInt(sc.nextLine());

                if (wantToPlay < 1 || wantToPlay > 2) {
                    System.out.println("\nClearly you didn't read instructions very well. lets try this again.");
                }

            } catch (NumberFormatException ex) {
                System.out.println("\nThats not a number. lets try this again.");

            }

        } while (wantToPlay < 1 || wantToPlay > 2);

        while (again == true) {

            // start the game or naw
            switch (wantToPlay) {

                // start the game
                case 1:
                    System.out.println("\nAlright lets play!");
                    runGame(askHowManyRounds());
                    getResults();
                    
                    
                            
                    

                    break;

                // user does not want to play
                case 2:
                    System.out.println("Sounds good!");
                    break;

            }
            again = playAgain();

            System.out.println("Sounds good, have a nice Day!");

        }

        

    }

    // promp the user of how many rounds they wish to play
    public static int askHowManyRounds() {

        int amountOfRounds = 0;

        do {
            System.out.println("How many rounds do you want to play? (1-10)");
            try {
                amountOfRounds = Integer.parseInt(sc.nextLine());

                if (amountOfRounds < 1 || amountOfRounds > 10) {
                    System.out.println("\nCmon man, read the instructions");
                    System.out.println("Lets try this again....");
                }

            } catch (NumberFormatException ex) {
                System.out.println("\nThats not a number. lets try this again.");

            }
        } while (amountOfRounds < 1 || amountOfRounds > 10);

        return amountOfRounds;

    }

    // Body of the game running with the amount of rounds user puts in.
    public static void runGame(int amountOfRounds) {
        String bot = "";
        String user = "";

        for (int i = 1; i <= amountOfRounds; i++) {

            int randomPick = 0;
            int userRPS = 0;

            System.out.println("\nLets Play Round " + i + "! ");

            do {
                System.out.println("pick one of the following");
                System.out.println("[1 = Rock] [2 = Paper] [3 = Scissors]");

                try {
                    userRPS = Integer.parseInt(sc.nextLine());

                    if (userRPS < 1 || userRPS > 3) {
                        System.out.println("\n We've gotten this far, please follow instructions.");
                        System.out.println("Lets try this again....");
                    }

                } catch (NumberFormatException ex) {
                    System.out.println("\nThats not a number. lets try this again.");
                }
            } while (userRPS < 1 || userRPS > 3);

            // Returning the String pick for the user
            user = pickRockPaperScissors(userRPS);

            // generating a random number for variable random pick
            randomPick = rpsBot();

            // Returning the String pick for the Bot
            bot = pickRockPaperScissors(randomPick);

            rulesRockPaperScissors(user, bot, i);

        }

    }

    // computer picks Random 1-3
    public static int rpsBot() {
        Random rng = new Random();

        int randomPick = rng.nextInt(3) + 1;
        return randomPick;
    }

    // method for user choice of RPS to return a string answere
    public static String pickRockPaperScissors(int rps) {
        String user = "";

        switch (rps) {
            case 1:
                user = "Rock";
                break;

            case 2:
                user = "Paper";
                break;

            case 3:
                user = "Scissors";
                break;
        }
        return user;

    }

    // rules deciding who won in RPS you or the PC
    public static void rulesRockPaperScissors(String user, String bot, int i) {
        String win = "YOU WIN ROUND ";
        String lose = "You lost round ";
        String draw = "This round ends in a draw";

        String L = "L";
        String W = "W";
        String D = "D";

        switch (user) {

            case "Rock":
                if (bot == "Scissors") {
                    System.out.println("\nRock breaks [Bot]Scissors");
                    System.out.println(win + i + "\n");
                    storeResults(W);

                } else if (bot == "Paper") {
                    System.out.println("\n[Bot]Paper covers Rock");
                    System.out.println(lose + i + "\n");
                    storeResults(L);

                    // only option left is for a draw which is bot == rock
                } else {
                    System.out.println("\nWe both picked Rock");
                    System.out.println(draw + "\n");
                    storeResults(D);
                }
                break;

            case "Paper":
                if (bot == "Rock") {
                    System.out.println("\nPaper Covers [Bot]Rock");
                    System.out.println(win + i);
                    storeResults(W);

                } else if (bot == "Scissors") {
                    System.out.println("\n[Bot]Scissors cuts Paper");
                    System.out.println(lose + i);
                    storeResults(L);

                    // only option left is for a draw which is bot == paper
                } else {
                    System.out.println("\nWe both picked Paper");
                    System.out.println(draw);
                    storeResults(D);
                }
                break;

            case "Scissors":
                if (bot == "Paper") {
                    System.out.println("\nScissors cuts [Bot]Paper");
                    System.out.println(win + i);
                    storeResults(W);

                } else if (bot.equals("Rock")) {
                    System.out.println("\n[Bot]Rock breaks Scissors");
                    System.out.println(lose + i);
                    storeResults(L);

                    // only option left is for a draw which is bot == scissors
                } else {
                    System.out.println("\nWe both picked Scissors");
                    System.out.println(draw);
                    storeResults(D);
                }
                break;

        }

    }

    public static void storeResults(String r) {

        if (r.equals("W")) {
            wins++;
        } else if (r.equals("L")) {
            losses++;
        } else if (r.equals("D")) {
            draws++;
        }

    }

    public static void getResults() {
        System.out.println("\nHere are your results:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);

        if (wins > losses) {
            System.out.println("\nYou are the overall WINNER!\n");
        } else if (wins < losses) {
            System.out.println("\n[Bot] is the overall winner!\n");
        } else {
            System.out.println("\nThe game ends in a TIE\n");
        }

    }

    public static boolean playAgain() {
        boolean restart = true;
        int tryAgain = 0;

        do {
            System.out.println("\nDo you want to play again?!");
            System.out.println("\ntype = 1 for YES \ntype = 2 for NO\n");

            try {
                tryAgain = Integer.parseInt(sc.nextLine());

                if (tryAgain < 1 || tryAgain > 2) {
                    System.out.println("\n Not a valid answer.");
                    System.out.println("Lets try this again....");
                }

            } catch (NumberFormatException ex) {
                System.out.println("\nThats not a number. lets try this again.");
            }
        } while (tryAgain < 1 || tryAgain > 2);

        if (tryAgain == 1) {
            restart = true;

        } else {
            restart = false;
        }

        return restart;

    }

    // Error Message Method
    // Ideal to create this method as it would of saved me a lot of time
    // tried getting it to work a few times but failed. decided to skip,
    // and get back to it later. Code will look cleaner once this method
    // is up and working.
    public static void inputError(int userInput, int lowBound, int highBound) {
        try {
            userInput = Integer.parseInt(sc.nextLine());

            if (userInput < lowBound || userInput > highBound) {
                System.out.println("\nCmon man, read the instructions");
                System.out.println("Lets try this again....");
            }

        } catch (NumberFormatException ex) {
            System.out.println("\nThats not a number. lets try this again.");

        }
        while (userInput < lowBound || userInput > highBound);

    }

}
