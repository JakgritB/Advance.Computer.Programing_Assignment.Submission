package boottapak.jakgrit.lab6;

/*  TestGame
 *  This is the test program to test GuessNumberGameVer1,
 *      RockPaperScissorGame and MonopolyGame
 *  
 *  - test constructor that has no parameter and has parameter
 *  - print information from each game
 *  - test method play game
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class TestGame {
    public static void main(String[] args) {
        testAllPart1();
    }

    public static void testInHour() {
        GuessNumberGameVer1 game1 = new GuessNumberGameVer1();
        System.out.println(game1);
        game1.playGame();
        Game game7;
        // Game game5 = new Game(); // This would be error.
        game7 = new GuessNumberGameVer1();
        System.out.println(game7);
        game7.playGame();
    }

    public static void testAllPart1() {
        GuessNumberGameVer1 game1 = new GuessNumberGameVer1();
        RockPaperScissorGame game2 = new RockPaperScissorGame();
        MonopolyGame game3 = new MonopolyGame();
        GuessNumberGameVer1 game4 = new GuessNumberGameVer1(1, 10, 3);
        RockPaperScissorGame game5 = new RockPaperScissorGame("rock", "paper");
        MonopolyGame game6 = new MonopolyGame(new String[] { "battleship", "wheelbarrow", "iron", "Dog" });
        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);
        System.out.println(game4);
        System.out.println(game5);
        System.out.println(game6);
        game1.playGame();
        game2.playGame();
        game3.playGame();
        game4.playGame();
        game5.playGame();
        game6.playGame();
        Game game7;
        // Game game5 = new Game(); // This would be error.
        game7 = new MonopolyGame();
        System.out.println(game7);
        game7.playGame();
        game7 = new GuessNumberGameVer1();
        System.out.println(game7);
        game7.playGame();
    }
}
