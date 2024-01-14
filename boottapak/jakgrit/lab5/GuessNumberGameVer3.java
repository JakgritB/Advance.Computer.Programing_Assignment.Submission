package boottapak.jakgrit.lab5;

/*  GuessNumberGameVer3
 *  This is subclasses of GuessNumberGameVer2
 *  This program is Number Guessing Game
 *  extending from GuessNumberGameVer2
 * 
 *  This program has the same constructor from GuessNumberGameVer2
 *  
 *  The method playGame is extending from playGame in GuessNumberGameVer2
 *  
 *  The new playGames method
 *  has more menu
 *  added option is
 *  - 'v' to show average guesses number
 *  - 'm' to show minimum guesses number by player
 *  - 'x' to show maximum guesses number by player
 *  - if another alphabet, it will show error "Invalid command"
 * 
 *  And added new method are
 *  - guessAverage : find average of guesses number and display
 *  - guessMin : find minimum number of guesses number and display
 *  - guessMax : find maximum number of guesses number and display
 * 
 *  Author : Jakgrit Boottapak
 *  ID : 663040111-9
 *  Sec : 1
 */

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {

    // Default constructor
    GuessNumberGameVer3() {
        super();
    }

    // Constructor with two parameters
    GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    // Constructor with three parameters
    GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    // play game Method
    @Override
    public void playGame() {
        super.playGame();
    }

    // Show specific guessed number from array
    @Override
    public void playGames() {
        playGame();

        String userOption;

        while (true) {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
            System.out.println("Type 'v' to show the average of the guesses, 'm' to show the minimum of the guesses," +
                    " or 'x' show the maximum of the guesses");
            userOption = input.next();
            if (userOption.equals("y") || userOption.equals("Y")) {
                playGame();
            } else if (userOption.equals("q") || userOption.equals("Q")) {
                break;
            } else if (userOption.equals("a") || userOption.equals("A")) {
                showGuesses();
            } else if (userOption.equals("g") || userOption.equals("G")) {
                showSpecific();
            } else if (userOption.equals("v") || userOption.equals("V")) {
                guessAverage();
            } else if (userOption.equals("m") || userOption.equals("M")) {
                guessMin();
            } else if (userOption.equals("x") || userOption.equals("X")) {
                guessMax();
            } else {
                System.err.println("Invalid command"); // User enter the wrong alphabet
            }
        }
        input.close();
        System.exit(0);
    }

    // Show average from all guesses number
    public void guessAverage() {
        float avgGuess = 0;
        for (int i = 0; i < numGuesses; i++) {
            avgGuess = avgGuess + guesses[i];
        }
        avgGuess = avgGuess / numGuesses;
        System.out.printf("Average = %s", String.format("%.2f", avgGuess)); // the result show 2 decimal
        System.out.println();
    }

    // Show minimum number from all guesses
    public void guessMin() {
        int guessMinValue = guesses[0];
        for (int i = 0; i < numGuesses; i++) {
            if (guesses[i] < guessMinValue)
                guessMinValue = guesses[i];
        }
        System.out.println("Min = " + guessMinValue);
    }

    // Show maximum number from all guesses
    public void guessMax() {
        int guessMaxValue = guesses[0];
        for (int i = 0; i < numGuesses; i++) {
            if (guesses[i] > guessMaxValue)
                guessMaxValue = guesses[i];
        }
        System.out.println("Max = " + guessMaxValue);
    }
}
