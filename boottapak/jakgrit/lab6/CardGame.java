package boottapak.jakgrit.lab6;

public abstract class CardGame extends Game {
    int numOfCardsPerPlayer;

    public CardGame() {
        super();
        this.setNumOfCardsPerPlayer(0);
    }

    public CardGame(int numOfCardsPerPlayer) {
        super();
        this.setNumOfCardsPerPlayer(numOfCardsPerPlayer);
    }

    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    abstract public void playGame();

    @Override
    public String toString() {
        System.out.print(super.toString());
        return "{ numOfCardPerPlayer='" + getNumOfCardsPerPlayer() + "'}";
    }
}
