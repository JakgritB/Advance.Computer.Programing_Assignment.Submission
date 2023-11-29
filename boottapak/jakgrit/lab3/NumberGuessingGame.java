package boottapak.jakgrit.lab3;

/**
 * This code is simple Number Guessing Game
 * The game will random number between 1 and 20
 * and you need to guessing it.
 * and maximum tries is 5 times
 * 
 * Author : Jakgrit Boottapak
 * ID : 663040111-9
 * Sec : 1
 */

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int min = 1;
        int max = 20;
        int answer = min + (int) (Math.random() * ((max - min) + 1));

        System.out.println("Welcome to a number guessing game!");

        Scanner userInput = new Scanner(System.in); // Create a Scanner object

        int times = 0;
        while (times < 5) {
            System.out.print("Enter an integer between 1 and 20:");
            int userAnswer = userInput.nextInt();

            if (userAnswer == answer) {
                times++;
                if (times == 1) {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + times + " time");
                } else {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + times + " times");
                }
                break;
            } else if (userAnswer < answer) {
                System.out.println("Try a higher number!");
                times++;
            } else if (userAnswer > answer) {
                System.out.println("Try a lower number!");
                times++;
            }
            if (times == 5 && userAnswer != answer) {
                System.out.println("You have tried " + times + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
            }

        }
        userInput.close();
    }
}