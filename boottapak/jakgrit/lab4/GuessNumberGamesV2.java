package boottapak.jakgrit.lab4;

/** This is improve of NumberGuessingGames from lab 3
 * In Number Guessing Games The added features are
 * - Player has options to review their guesses when finish the game
 *      - 'a' option is display all guesses that made by player
 *      - 'g' option is display the guesses that player choose to view
 *      - Exit option will exit the review program by press any other key
 * 
 * - New message format when player win the game
 * - New message format when player enters a guess outside the min and max
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.*;

public class GuessNumberGamesV2 {
    static int answer, min, max, numTries, maxTries;
    static ArrayList<Integer> playerGuess;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        while (min > max) {
            System.err.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
        while (maxTries <= 0) {
            System.err.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGames() {
        System.out.println("Welcome to a number guessing game!");
        playerGuess = new ArrayList<>();
        numTries = 0;

        while (numTries <= maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int userAnswer = input.nextInt();

            if (userAnswer == answer) {
                playerGuess.add(userAnswer);
                numTries++;
                System.out.println("Congratulations!");
                guessDisplay();
                break;
            } else if (userAnswer < min || userAnswer > max) {
                while (true) {
                    System.err.print("Your guess should be in [" + min + "," + max + "]:");
                    userAnswer = input.nextInt();
                    if (userAnswer >= min && userAnswer <= max) {
                        break;
                    }
                }
            }
            if (userAnswer < answer && userAnswer >= min && userAnswer <= max) {
                playerGuess.add(userAnswer);
                System.out.println("Try a higher number!");
                numTries++;
            } else if (userAnswer > answer && userAnswer >= min && userAnswer <= max) {
                playerGuess.add(userAnswer);
                System.out.println("Try a lower number!");
                numTries++;
            }
            if (numTries == maxTries && userAnswer != answer) {
                System.out.print("You ran out of guesses. ");
                System.out.println("The answer was " + answer);
                guessDisplay();
                break;
            }
        }
    }

    static void choice() {
        String choiceInput;
        System.out.print("Want to play again (Y or y):");
        choiceInput = input.next();
        if (choiceInput.equals("Y") || choiceInput.equals("y")) {
            genAnswer();
            playGames();
        } else {
            System.out.print("Thank you for playing our games. Bye");
            input.close();
            System.exit(0);
        }
    }

    static void guessDisplay() {
        String choiceInput;
        int guessPlayerWant;
        while (true) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
            choiceInput = input.next();
            if (choiceInput.equals("a")) {
                System.out.println("All guesses:");
                for (int playerGuessDisplay : playerGuess) {
                    System.out.print(playerGuessDisplay + " ");
                }
                System.out.println("");
            } else if (choiceInput.equals("g")) {
                System.out.print("Enter the number of the guess you want to see (1-" + numTries + "):");
                guessPlayerWant = input.nextInt();
                System.out.print("Guess " + guessPlayerWant + ": ");
                System.out.println(playerGuess.get(guessPlayerWant - 1));
            } else {
                choice();
                break;
            }
        }
    }
}