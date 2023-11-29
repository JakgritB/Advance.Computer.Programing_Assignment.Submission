package boottapak.jakgrit.lab3;

/**
 * This Configurable Number Guessing game you can config
 * - Min value
 * - Max value
 * - Maximum number of tries
 * 
 * The game will random number between MIN and MAX
 * and you need to guessing it
 * and maximum tries by your configurable.
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.*;

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        System.out.println("Welcome to a number guessing game!");

        numTries = 0;
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
            }
        }
        input.close();
    }
}
