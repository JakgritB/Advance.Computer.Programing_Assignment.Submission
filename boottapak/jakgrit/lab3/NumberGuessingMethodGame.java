package boottapak.jakgrit.lab3;

import java.util.*;

public class NumberGuessingMethodGame {
    static int answer;
    final static int MIN = 1;
    final static int MAX = 20;

    public static void main(String[] args) {
        genAnswer();
        playGame();
    }

    static void genAnswer() {
        answer = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
    }

    static void playGame() {
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
