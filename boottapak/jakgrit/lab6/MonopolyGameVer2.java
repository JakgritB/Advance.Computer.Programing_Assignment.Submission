package boottapak.jakgrit.lab6;

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {

    public MonopolyGameVer2() {
        super();
    }

    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    public void gameRule() {
        System.out.println("Monopoly Game Rules : ...");
    }

    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    public void rollDice() {
        System.out.println("Roll 2 dice for monopoly game");
    }

    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game Version 2");
    }

    @Override
    public String toString() {
        System.out.print("Monopoly Game Version 2 : ");
        return super.toString();
    }
}
