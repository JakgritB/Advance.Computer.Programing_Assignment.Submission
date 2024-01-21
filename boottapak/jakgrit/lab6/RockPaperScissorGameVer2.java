package boottapak.jakgrit.lab6;

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {

    public RockPaperScissorGameVer2() {
        super();
    }

    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }

    public void gameRule() {
        System.out.println("Rock Paper Scissor Rules : ...");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Version 2");
    }

    @Override
    public String toString() {
        System.out.print("Rock Paper Scissor Game Version 2 : ");
        return super.toString();
    }
}
