package boottapak.jakgrit.lab6;

/*  TestGame3
 *  This is the test program to test PokerGame, DungeonsAndDragonsGame.
 *  
 *  - test constructor that has no parameter and has parameter
 *  - print information from each game
 *  - test method play game, gameRule, setUpBoard, rollDice
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class TestGame3 {
    public static void main(String[] args) {
        // CardGame game1 = new CardGame();
        PokerGame game2 = new PokerGame();
        System.out.println(game2);
        game2.playGame();
        game2.gameRule();
        PokerGame game4 = new PokerGame(10);
        System.out.println(game4);
        // game2.setUpBoard();
        DungeonsAndDragonsGame game3 = new DungeonsAndDragonsGame();
        System.out.println(game3);
        game3.playGame();
        game3.gameRule();
        game3.setUpBoard();
        game3.rollDice();
        DungeonsAndDragonsGame game5 = new DungeonsAndDragonsGame(3);
        System.out.println(game5);
    }
}
