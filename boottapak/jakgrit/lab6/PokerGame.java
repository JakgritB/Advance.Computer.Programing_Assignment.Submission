package boottapak.jakgrit.lab6;

public class PokerGame extends CardGame implements HasRule {
    public PokerGame() {
        super(5);
        this.setName("Poker Game");
        this.setNumOfPlayers(4);
    }

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
    }

    @Override
    public String toString() {
        System.out.print("Poker Game : ");
        return super.toString();
    }
}
