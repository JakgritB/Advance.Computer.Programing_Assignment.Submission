package boottapak.jakgrit.lab6;

public class MonopolyGame extends Game {
    protected String[] gamePieces;

    public MonopolyGame() {
        super("Monopoly Game", 4);
        this.gamePieces = new String[] { "car", "top hat", "thimble", "boot" };
    }

    public MonopolyGame(String[] gamePieces) {
        super("Monopoly Game", 4);
        this.setGamePieces(gamePieces);
    }

    public String getGamePieces() {
        String gamePiecesString = ""; // Initialize with an empty string
        for (int i = 0; i < gamePieces.length; i++) {
            gamePiecesString = gamePiecesString + gamePieces[i] + " ";
        }
        return gamePiecesString;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    @Override
    public String toString() {
        System.out.print(super.toString());
        return "{ game pieces='" + getGamePieces() + "'}";
    }

    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
    }
}
