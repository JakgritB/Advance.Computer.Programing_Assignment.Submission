package boottapak.jakgrit.lab6;

public class RockPaperScissorGame extends Game {
    protected String player1Choice, player2Choice;

    public RockPaperScissorGame() {
        super("Rock Paper Scissor", 2);
        player1Choice = "rock";
        player2Choice = "rock";
    }

    public RockPaperScissorGame(String player1Choice, String player2Choice) {
        super("Rock Paper Scissor", 2);
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }

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

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public void playGame() {
        
    }
}
