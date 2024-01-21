package boottapak.jakgrit.lab6;

/*  This program is "RockPaperScissorGame" that extends the abstract class "Game".
 *  The program is a Rock Paper Scissor Game, because it's has no game.
 *  this program has variable String player1Choice, player2Choice.
 *  to get what player use to play "Rock", "Paper", or "Scissor"
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class RockPaperScissorGame extends Game {
    protected String player1Choice, player2Choice;

    // Default constructor
    public RockPaperScissorGame() {
        super("Rock Paper Scissor Game", 2);
        this.setPlayer1Choice("rock");
        this.setPlayer2Choice("rock");
    }

    // Constructor that get 2 parameter
    // and set player1Choice and player2Choice
    public RockPaperScissorGame(String player1Choice, String player2Choice) {
        super("Rock Paper Scissor Game", 2);
        this.setPlayer1Choice(player1Choice);
        this.setPlayer2Choice(player2Choice);
    }

    // Getter and Setter method
    public String getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(String player1Choice) {
        this.player1Choice = player1Choice;
    }

    public String getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(String player2Choice) {
        this.player2Choice = player2Choice;
    }

    // abstract method "playGame()" from superclass "Game"
    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Game");
        // Rock Paper Scissor Game simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "gameName, numOfPlayer" from superclass
        // and then print "player1Choice, player2Choice".

        System.out.print(super.toString());
        return "{, player1Choice='" + getPlayer1Choice() + "', player2Choice='" +
                getPlayer2Choice() + "'}";
    }
}
