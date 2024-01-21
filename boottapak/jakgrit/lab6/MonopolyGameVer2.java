package boottapak.jakgrit.lab6;

/*  This program is "MonopolyGameVer2" that extends the class "MonopolyGame".
 *  the program is the same as MonopolyGame
 *  and implements the 
 *  - interface "HasRule" that need to has method "gameRule"
 *  - interface "UseBoard" that need to has method "setUpBoard"
 *  - interface "UseDice" that need to has method "rollDice"
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {

    // Default constructor
    public MonopolyGameVer2() {
        super();
    }

    // Constructor that get 1 parameter
    // to set gamePieces.
    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    // Implements method
    public void gameRule() {
        System.out.println("Monopoly Rules: ...");
    }

    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    public void rollDice() {
        System.out.println("Roll 2 dice for monopoly game");
    }

    // abstract method "playGame()" from superclass "Game"
    @Override
    public void playGame() {
        System.out.println("Play Monopoly Game Version 2");
        // Monopoly Game Version 2 simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "Monopoly Game Version 2 : " as first
        // and then print the same as superclass

        System.out.print("Monopoly Game Version 2 : ");
        return super.toString();
    }
}
