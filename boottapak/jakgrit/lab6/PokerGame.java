package boottapak.jakgrit.lab6;

/*  This program is "PokerGame" that extends the abstract class "CardGame".
 *  The program is a simulator of Poker Game, because it's has no game.
 *  and implements the interface "HasRule" that need to has method "gameRule"
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PokerGame extends CardGame implements HasRule {

    // Default constructor
    public PokerGame() {
        super(5);
        this.setName("Poker Game");
        this.setNumOfPlayers(4);
    }

    // Constructor that get 1 parameter
    // to set number of cards per player.
    public PokerGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        this.setName("Poker Game");
        this.setNumOfPlayers(4);
    }

    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Poker Game.");
        // Poker Game simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "Poker Game : " as first
        // and then print "gameName, numOfPlayer, numOfCardPerPlayer" from superclass

        System.out.print("Poker Game : ");
        return super.toString();
    }
}
