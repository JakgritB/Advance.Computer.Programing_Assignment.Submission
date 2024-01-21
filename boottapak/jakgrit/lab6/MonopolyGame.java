package boottapak.jakgrit.lab6;

/*  This program is "MonopolyGame" that extends the abstract class "Game".
 *  The program is a Monopoly Game simulator, because it's has no game.
 *  this program has array variable String gamePieces.
 *  to collect game pieces to array.
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class MonopolyGame extends Game {
    protected String[] gamePieces;

    // Default constructor
    public MonopolyGame() {
        super("Monopoly Game", 4);
        this.gamePieces = new String[] { "car", "top hat", "thimble", "boot" };
    }

    // Constructor that get 2 parameter
    // to set gamePieces.
    public MonopolyGame(String[] gamePieces) {
        super("Monopoly Game", 4);
        this.setGamePieces(gamePieces);
    }

    // Getter and Setter method
    public String getGamePieces() {
        String gamePiecesString = ""; // Initialize with an empty string
        for (int i = 0; i < gamePieces.length; i++) {
            gamePiecesString = gamePiecesString + gamePieces[i] + " ";
        }
        // this will convert array to string
        return gamePiecesString;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    // abstract method "playGame()" from superclass "Game"
    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
        // Monopoly Game simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "gameName, numOfPlayer" from superclass
        // and then print "gamePieces".

        System.out.print(super.toString());
        return "{ game pieces='" + getGamePieces() + "'}";
    }
}
