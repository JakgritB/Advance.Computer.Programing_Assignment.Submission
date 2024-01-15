package boottapak.jakgrit.lab6;

public class TestGame {
    public static void main(String[] args) {
        GuessNumberGameVer1 game1 = new GuessNumberGameVer1();
        System.out.println(game1);
        game1.playGame();
        Game game7;
        // Game game5 = new Game(); // This would be error.
        game7 = new GuessNumberGameVer1();
        System.out.println(game7);
        game7.playGame();
    }
}
