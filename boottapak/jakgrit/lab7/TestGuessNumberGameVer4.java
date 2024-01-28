package boottapak.jakgrit.lab7;

/*  TestGuessNumberGameVer4
 *  This is the test program to test GuessNumberGameVer4
 *     
 *  - test new format toString method
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class TestGuessNumberGameVer4 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        GuessNumberGameVer4 game1 = new GuessNumberGameVer4(1, 10, 3);
        GuessNumberGameVer4 game2 = new GuessNumberGameVer4(1, 10, 5);
        GuessNumberGameVer4 game3 = new GuessNumberGameVer4(1, 5, 5);
        System.out.println(game1);
        System.out.println(game2);
        System.out.println(game3);
    }

}
