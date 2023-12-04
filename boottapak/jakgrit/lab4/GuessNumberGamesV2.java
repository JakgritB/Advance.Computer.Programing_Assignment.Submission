package boottapak.jakgrit.lab4;

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
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
        while (maxTries <= 0) {
            System.out.println("The maximum number of tries must be greater than 0");
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
                if (numTries == 1) {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numTries + " time");
                } else {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numTries + " times");
                }
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
                System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
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
                System.out.print("Guess " + guessPlayerWant + ":");
                System.out.println(playerGuess.get(guessPlayerWant - 1));
            } else {
                choice();
                break;
            }
        }
    }
}