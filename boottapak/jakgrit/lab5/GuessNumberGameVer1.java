package boottapak.jakgrit.lab5;

/*  GuessNumberGameVer1
 *  This is superclass of all GuessNumberGame
 *  This program is Number Guessing Game
 *  random number is integer between minimum number and maximum number
 *  and has maximum tries
 * 
 *  protected int variables in this program are
 *  minNum, maxNum, maxTries, correctNum;
 *  and "numOfGames" is static
 *  and Scanner "input"
 * 
 *  it's has 3 constructors
 *  1.takes no parameters // 2.accepts two parameters // 3.accepts three parameters 
 *  
 *  and if test by no parameters
 *  minimum number is 1
 *  maximum number is 10
 *  maximum tries is 3
 * 
 *  if test by two parameters
 *  minimum number is set by user
 *  maximum number is set by user
 *  maximum tries is 3
 * 
 *  if test by three parameters
 *  minimum number is set by user
 *  maximum number is set by user
 *  maximum tries is set by user
 * 
 *  Author : Jakgrit Boottapak
 *  ID : 663040111-9
 *  Sec : 1
 */

import java.util.Scanner;

public class GuessNumberGameVer1 {
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    protected static int numOfGames = 0;
    Scanner input;

    // Default constructor
    public GuessNumberGameVer1() {
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    // Constructor with two parameters
    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    // Constructor with three parameters
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    // Getter and setter methods
    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    // Method play game
    public void playGame() {
        input = new Scanner(System.in);
        int numTries = 0;
        System.out.println("Welcome to a number guessing game!");
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            int userAnswer = input.nextInt();
            if (userAnswer == correctNum) { // User guess correct number
                numTries++;
                if (numTries == 1) {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numTries + " time");
                } else {
                    System.out.println("Congratulation!");
                    System.out.println("You have tried " + numTries + " times");
                }
                break;
            } else if (userAnswer < minNum || userAnswer > maxNum) { // User enter number out of range
                System.err.println("Number must be integer between " + minNum + " and " + maxNum + " Only");
            } else if (userAnswer < correctNum) {
                numTries++;
                System.out.println("Try a higher number!");
            } else if (userAnswer > correctNum) {
                numTries++;
                System.out.println("Try a lower number!");
            }
            if (numTries == maxTries && userAnswer != correctNum) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                System.out.println("The answer is " + correctNum);
            }
        }
    }

    // toString medthod will return minNum, maxNum and MaxTries, when you want to know the status of program
    // you can print this in the test program
    @Override
    public String toString() {
        return "GuessNumberGame with min number as " + minNum + " max number as " + maxNum + " max number of tries as "
                + maxTries;
    }

    // Amount of game that player played
    public static int getNumOfGames() {
        return numOfGames;
    }
}