package boottapak.jakgrit.lab6;

public class MonopolyGame extends Game {
    protected String[] gamePieces;

    public MonopolyGame() {
        super("Monopoly Game", 4);
        gamePieces = new String[]{"car", "top hat", "thimble", "boot"};
    }

    public MonopolyGame(String[] gamePieces) {
        super("Monopoly Game", 4);
        this.gamePieces = gamePieces;
    }

    public String[] getGamePieces(){
        return gamePieces;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public void playGame() {

    }

}
