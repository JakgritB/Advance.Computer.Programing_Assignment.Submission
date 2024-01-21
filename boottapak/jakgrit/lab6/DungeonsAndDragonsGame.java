package boottapak.jakgrit.lab6;

/*  This program is "DungeonsAndDragonsGame" that extends the abstract class "CardGame".
 *  The program is a simulator of Dungeons And Dragons Game, because it's has no game.
 * 
 *  and implements the 
 *  - interface "HasRule" that need to has method "gameRule"
 *  - interface "UseBoard" that need to has method "setUpBoard"
 *  - interface "UseDice" that need to has method "rollDice"
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice {

    // Default constructor
    public DungeonsAndDragonsGame() {
        super(6);
        this.setName("Dungeons And Dragons Game");
        this.setNumOfPlayers(3);
    }

    // Constructor that get 1 parameter
    // to set number of cards per player.
    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        this.setName("Dungeons And Dragons Game");
        this.setNumOfPlayers(3);

    }

    // implement method
    public void gameRule() {
        System.out.println("Dungeons And Dragon Game Rules : ...");
    }

    public void setUpBoard() {
        System.out.println("Setting up board for Dungeons And Dragon Game");
    }

    public void rollDice() {
        System.out.println("Rolling 2 dices for Dungeons And Dragons Game");
    }

    // abstract method "playGame()" from superclass "CardGame"
    @Override
    public void playGame() {
        System.out.println("Playing Dungeons And Dragon Game");
        // Dungeons And Dragon Game simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "Dungeons And Dragons Game : " as first
        // and then print "gameName, numOfPlayer, numOfCardPerPlayer" from superclass

        System.out.print("Dungeons And Dragons Game : ");
        return super.toString();
    }
}
