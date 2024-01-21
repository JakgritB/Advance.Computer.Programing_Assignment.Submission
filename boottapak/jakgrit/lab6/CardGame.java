package boottapak.jakgrit.lab6;

/*  This program defines an abstract class named "CardGame" extends "Game" 
 *  this is a template for different card games.
 *  It has variable: int numOfCardPerPlayer
 *  The class has an abstract method "playGame()" to be implemented by subclasses.
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public abstract class CardGame extends Game {
    int numOfCardsPerPlayer;

    // Default constructor
    public CardGame() {
        super();
        this.setNumOfCardsPerPlayer(0);
    }

    // Constructor that get 1 parameter
    // to set number of cards per player.
    public CardGame(int numOfCardsPerPlayer) {
        super();
        this.setNumOfCardsPerPlayer(numOfCardsPerPlayer);
    }

    // Getter and Setter method
    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    // Abstract method to be implemented by subclasses
    abstract public void playGame();

    @Override
    public String toString() {
        // this will print "gameName, numOfPlayer" from superclass
        // and then print "NumOfCardsPerPlayer".

        System.out.print(super.toString());
        return "{ numOfCardPerPlayer='" + getNumOfCardsPerPlayer() + "'}";
    }
}
