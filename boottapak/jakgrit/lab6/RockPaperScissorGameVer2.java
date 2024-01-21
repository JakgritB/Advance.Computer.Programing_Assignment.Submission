package boottapak.jakgrit.lab6;

/*  This program is "RockPaperScissorGameVer2" that extends the class "RockPaperScissorGame".
 *  the program is the same as RockPaperScissorGame
 *  and implements the interface "HasRule" that need to has method "gameRule"
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {

    // Default constructor
    public RockPaperScissorGameVer2() {
        super();
    }

    // Constructor that get 2 parameter
    // to set player1Choice and player2Choice.
    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }

    public void gameRule() {
        System.out.println("Rock Paper Scissor Rules: ...");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Version 2");
        // Rock Paper Scissor Version 2 simulator by just using print
    }

    @Override
    public String toString() {
        // this will print "Rock Paper Scissor Game Version 2 : " as first
        // and then print the same as superclass

        System.out.print("Rock Paper Scissor Game Version 2 : ");
        return super.toString();
    }
}
