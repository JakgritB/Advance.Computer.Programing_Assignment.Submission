package boottapak.jakgrit.lab3;

import java.util.*;

public class NumberGuessingGames {
    static int answer, min, max, maxTries;
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

        int numTries = 0;
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int userAnswer = input.nextInt();

            if (userAnswer == answer) {
                numTries++;
                if (numTries == 1) {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numTries + " time");
                } else {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numTries + " times");
                }
                choice();
                break;
            } else if (userAnswer < answer) {
                System.out.println("Try a higher number!");
                numTries++;
            } else if (userAnswer > answer) {
                System.out.println("Try a lower number!");
                numTries++;
            }
            if (numTries == maxTries && userAnswer != answer) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
                choice();
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
        }
    }
}