package boottapak.jakgrit.lab4;

/** This is advanced version of GuessNumberGamesV2
 * In Number Guessing Games The added features are
 * - When the round is over, it will show game log:
 *      - Answer
 *      - Number of guesses
 *      - Win/Loss status
 * 
 *  The output example: Game log: Answer: 1, Guesses: 3, Win: true
 * 
 * - When played the game many times, the game will save information, 
 *   and display the statistical information:
 *      - Total games played
 *      - Total wins
 *      - Win ratio
 *      - Average guess per game
 *      - High Score (Least Guesses)
 * 
 *  The output example:
 *  ----- Game Statistics -----
 *  Total games played: 4
 *  Total wins: 1
 *  Win Ratio: 25.0%
 *  Average guess per game: 3.0
 *  High Score (Least Guesses): 3
 *  
 *  But when player did not win any game. it will show like this:
 *  ----- Game Statistics -----
 *  Total games played: 1
 *  Total wins: 0
 *  Win Ratio: 0.0%
 *  Average guess per game: 3.0
 *  High Score (Least Guesses): N/A
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.*;

public class GuessNumberGamesV3 {
    static int answer, min, max, numTries, maxTries;
    static ArrayList<Integer> playerGuess;
    static ArrayList<Integer> numTriesList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static boolean winStatus;
    static int totalGames, totalWins, totalLoses = 0, leastGuess;
    static float winRate, avgGuess, allTries;

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
        totalGames++;
        System.out.println("Welcome to a number guessing game!");
        playerGuess = new ArrayList<>();

        numTries = 0;

        while (numTries <= maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int userAnswer = input.nextInt();

            if (userAnswer == answer) {
                winStatus = true;
                playerGuess.add(userAnswer);
                totalWins++;
                numTries++;
                System.out.println("Congratulations!");
                allTries = allTries + numTries;
                numTriesList.add(numTries);
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
                winStatus = false;
                totalLoses++;
                System.out.print("You ran out of guesses. ");
                System.out.println("The answer was " + answer);
                allTries = allTries + numTries;
                numTriesList.add(numTries);
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
            input.close();
            gameStatistics();
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
                gameLog();
                break;
            }
        }
    }

    static void gameLog() {
        System.out.print("Game Log: ");
        System.out.print("Answer: " + answer + ", ");
        System.out.print("Guesses: " + numTries + ", ");
        System.out.println("Win: " + winStatus);
        choice();
    }

    static void gameStatistics() {
        System.out.println("----- Game Statistics -----");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Total wins: " + totalWins);
        if (totalLoses == 0) {
            winRate = 100;
        } else {
            winRate = ((float) totalWins / (float) totalGames) * 100;
        }
        System.out.printf("Win Ratio: %s", String.format("%.1f", winRate) + "%");
        System.out.println();
        avgGuess = allTries / totalGames;
        System.out.printf("Average guess per game: %s", String.format("%.1f", avgGuess));
        System.out.println();
        Collections.sort(numTriesList);
        if (totalWins == 0) {
            System.out.println("High Score (Least Guesses): " + "N/A");
        } else {
            System.out.println("High Score (Least Guesses): " + numTriesList.get(0));
        }
        System.exit(0);
    }
}