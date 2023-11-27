package boottapak.jakgrit.lab3;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int min = 1;
        int max = 20;
        int answer = min + (int) (Math.random() * ((max - min) + 1));

        System.out.println("Welcome to a number guessing game!");

        Scanner user_input = new Scanner(System.in); // Create a Scanner object

        int times = 0;
        while (times < 5) {
            System.out.print("Enter an integer between 1 and 20:");
            int user_answer = user_input.nextInt();

            if (user_answer == 20) {
                times++;
                if (times == 1) {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + times + " time");
                } else {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + times + " times");
                }
                break;
            } else if (user_answer < answer) {
                System.out.println("Try a higher number!");
                times++;
            } else if (user_answer > answer) {
                System.out.println("Try a lower number!");
                times++;
            }
            if (times == 5 && user_answer != answer) {
                System.out.println("You have tried " + times + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
            }

        }
        user_input.close();
    }
}
