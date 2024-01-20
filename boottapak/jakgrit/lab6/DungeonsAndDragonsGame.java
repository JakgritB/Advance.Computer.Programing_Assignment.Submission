package boottapak.jakgrit.lab6;

public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice {
    public DungeonsAndDragonsGame() {
        super(6);
        this.setName("Dungeons And Dragons Game");
        this.setNumOfPlayers(3);
    }

    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        this.setName("Dungeons And Dragons Game");
        this.setNumOfPlayers(3);

    }

    public void gameRule() {
        System.out.println("Dungeons And Dragon Game Rules : ...");
    }

    public void setUpBoard() {
        System.out.println("Setting up board for Dungeons And Dragon Game");
    }

    public void rollDice() {
        System.out.println("Rolling 2 dices for Dungeons And Dragons Game");
    }

    public void playGame() {
        System.out.println("Playing Dungeons And Dragon Game");
    }

    @Override
    public String toString() {
        System.out.print("Dungeons And Dragons Game : ");
        return super.toString();
    }
}
