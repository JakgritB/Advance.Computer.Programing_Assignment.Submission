package boottapak.jakgrit.lab3;

/** This is improve of Number Guessing Game
 * in Number Guessing Games you can config
 * - Min value
 * - Max value
 * - Maximum number of tries
 * 
 * The game will random number between MIN and MAX
 * and you need to guessing it
 * and maximum tries by your configurable,
 * when the game end you can choose to play again or not,
 * 
 * to prevent incorrect values from user
 * - if user input MAX number less than MIN number
 * the game will show "The max value must be at least equal to the min value"
 * and user need to input the new Max number.
 * - if user input maximum number of tries less than 0
 * the game will show "The maximum number of tries must be greater than 0"
 * and user need to input the new maximum number of tries.
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

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
            } else if (userAnswer < min || userAnswer > max) {
                System.out.println("The number must be between " + min + " and " + max);
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
            input.close();
        }
    }
}