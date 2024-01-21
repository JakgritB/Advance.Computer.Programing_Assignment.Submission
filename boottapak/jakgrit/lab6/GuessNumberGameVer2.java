package boottapak.jakgrit.lab6;

/*  This program is "GuessNumberGameVer2" that extends the class "GuessNumberGameVer1".
 *  the program is the same as GuessNumberGameVer1
 *  and implements the interface "HasRule" that need to has method "gameRule"
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {

    // Default constructor
    public GuessNumberGameVer2() {
        super();
    }

    // Constructor that get 2 parameter
    // to set minimum number, maximum number, maximum tries
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    public void gameRule() {
        System.out.println("Guess Number Game Rules : ...");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game Version 2");
        // Guess Number Game version 2 simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "Guess Number Game Version 2 :" as first
        // and then print the same as superclass

        System.out.print("Guess Number Game Version 2 : ");
        return super.toString();
    }
}
