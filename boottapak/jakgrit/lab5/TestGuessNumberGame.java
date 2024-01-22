package boottapak.jakgrit.lab5;

/*  TestGuessNumberGame
 *  This is the test program to test all GuessNumberGame
 *  
 *  This program can test the GuessNumberGame program with:
 *  - No parameters
 *  - Two parameters
 *  - Three parameters
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class TestGuessNumberGame {
    // Test for the default constructor in GuessNumberGameVer1
    public static void testPart1() {
        GuessNumberGameVer1 gng1 = new GuessNumberGameVer1();
        gng1.playGame();
        System.out.println("There are " + GuessNumberGameVer1.getNumOfGames() + " games");
        gng1.setMinNum(2);
        gng1.setMaxNum(5);
        gng1.setMaxTries(2);
        System.out.println(
                "Min = " + gng1.getMinNum() + " Max = " + gng1.getMaxNum() + " Max tries = " + gng1.getMaxTries());
        gng1.playGame();
        GuessNumberGameVer1 gng2 = new GuessNumberGameVer1();
        System.out.println(
                "Min = " + gng2.getMinNum() + " Max = " + gng2.getMaxNum() + " Max tries = " + gng2.getMaxTries());
        System.out.println("There are " + GuessNumberGameVer1.getNumOfGames() + " games");
    }

    // Test for all constructor in GuessNumberGameVer1
    public static void testConstructors() {
        GuessNumberGameVer1 gng1 = new GuessNumberGameVer1();
        GuessNumberGameVer1 gng2 = new GuessNumberGameVer1(5, 10);
        GuessNumberGameVer1 gng3 = new GuessNumberGameVer1(10, 20, 5);
        System.out.println(gng1);
        gng1.playGame();
        System.out.println(gng2);
        gng2.playGame();
        System.out.println(gng3);
        gng3.playGame();
    }

    // Test for three parameters in GuessNumberGameVer2
    public static void testPlayGames() {
        GuessNumberGameVer2 gng = new GuessNumberGameVer2(5, 10, 4);
        gng.playGames();
    }

    // Test for three parameters in GuessNumberGameVer3
    public static void testPlayGamesStats() {
        GuessNumberGameVer3 gng = new GuessNumberGameVer3(1, 5, 3);
        System.out.println(gng);
        gng.playGames();
    }

    // main method // you can called any method in this main method and run to test
    // You can change method you want to test here:
    public static void main(String[] args) {
        testPlayGamesStats();
    }
}