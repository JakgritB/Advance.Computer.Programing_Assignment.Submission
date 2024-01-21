package boottapak.jakgrit.lab6;

/*  This program is "GuessNumberGameVer1" that extends the abstract class "Game".
 *  The program is a simulator of guess number game, because it's has no game.
 *  this program has variable int minNum, maxNum, correctNum, maxTries.
 *  the correctNum is random number.
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class GuessNumberGameVer1 extends Game {
    protected int minNum, maxNum, correctNum, maxTries;

    // Default constructor
    public GuessNumberGameVer1() {
        super("Guess Number Game", 1);
        this.setMinNum(1);
        this.setMaxNum(10);
        this.setMaxTries(3);
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    // Constructor that get 2 parameter
    // to set minimum number, maximum number
    public GuessNumberGameVer1(int minNum, int maxNum) {
        super("Guess Number Game", 1);
        this.setMinNum(minNum);
        this.setMaxNum(maxNum);
        this.setMaxTries(3);
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    // Constructor that get 3 parameter
    // to set minimum number, maximum number, maximum tries
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super("Guess Number Game", 1);
        this.setMinNum(minNum);
        this.setMaxNum(maxNum);
        this.setMaxTries(maxTries);
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    // Getter and Setter method
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

    // abstract method "playGame()" from superclass "Game"
    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game");
        // Guess Number Game simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "gameName, numOfPlayer" from superclass
        // and then print "minNum, maxNum, correctNum, maxTries".

        System.out.print(super.toString());
        return "{ minNum='" + getMinNum() + "', maxNum='" + getMaxNum() +
                "', correctNum='" + correctNum + "', maxTries='" + getMaxTries() + "'}";
    }
}
