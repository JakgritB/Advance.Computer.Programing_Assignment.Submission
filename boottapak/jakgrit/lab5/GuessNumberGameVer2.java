package boottapak.jakgrit.lab5;

/*  GuessNumberGameVer2
 *  This is subclasses of GuessNumberGameVer1
 *  This program is Number Guessing Game
 *  extending from GuessNumberGameVer1
 * 
 *  Added protected variable are
 *  int array variable is "guesses"
 *  int variable are numGuesses, MAX_GUESSES
 * 
 *  This program has the same constructor from GuessNumberGameVer1
 *  
 *  The new playGame method
 *  has add guess number for user to array variable
 * 
 *  And added new method are
 *  - showSpecific: show specific guesses number choose by user
 *  - showGuesses: show all guesses number by player
 *  - playGames: method that called another method,
 *      and it's is option for player to choose the menu
 *      - 'y' to play again
 *      - 'q' to quit the game
 *      - 'a' to show all guesses number by player
 *      - 'g' to show specific guesses number choose by user
 * 
 *  Author : Jakgrit Boottapak
 *  ID : 663040111-9
 *  Sec : 1
 */

import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    protected int[] guesses;
    protected int numGuesses = 0;
    protected int MAX_GUESSES = 20;

    // Default constructor
    GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    // Constructor with two parameters
    GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    // Constructor with three parameters
    GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    // play game Method
    @Override
    public void playGame() {
        input = new Scanner(System.in);
        numGuesses = 0;
        System.out.println("Welcome to a number guessing game!");

        while (numGuesses < maxTries) {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            int userAnswer = input.nextInt();
            if (userAnswer == correctNum) { // User guess correct number
                guesses[numGuesses] = userAnswer; // add guess number to array guesses
                numGuesses++;
                if (numGuesses == 1) {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numGuesses + " time");
                } else {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numGuesses + " times");
                }
                break;
            } else if (userAnswer < minNum || userAnswer > maxNum) { // User enter number out of range
                System.err.println("Number must be integer between " + minNum + " and " + maxNum + " Only");
            } else if (userAnswer < correctNum) {
                guesses[numGuesses] = userAnswer; // add guess number to array guesses
                numGuesses++;
                System.out.println("Try a higher number!");
            } else if (userAnswer > correctNum) {
                guesses[numGuesses] = userAnswer; // add guess number to array guesses
                numGuesses++;
                System.out.println("Try a lower number!");
            }
            if (numGuesses == maxTries && userAnswer != correctNum) {
                System.out.println("You have tried " + numGuesses + " times. You ran out of guesses");
                System.out.println("The answer is " + correctNum);
            }
        }
    }

    // Show specific guessed number from array
    public void showSpecific() {
        System.out.println("Enter which guess in rage (1-" + numGuesses + ")");
        int specificGuess = input.nextInt();
        System.out.print("Guess number " + specificGuess + " is ");
        System.out.println(guesses[specificGuess - 1]);
    }

    // Show all guessed numbers
    public void showGuesses() {
        for (int i = 0; i < numGuesses; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    // Method menu for player
    public void playGames() {
        playGame();
        String userOption;

        while (true) {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
            userOption = input.next();
            if (userOption.equals("y") || userOption.equals("Y")) {
                playGame();
            } else if (userOption.equals("q") || userOption.equals("Q")) {
                break;
            } else if (userOption.equals("a") || userOption.equals("A")) {
                showGuesses();
            } else if (userOption.equals("g") || userOption.equals("G")) {
                showSpecific();
            }
        }
        input.close();
        System.exit(0);
    }
}
