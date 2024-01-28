package boottapak.jakgrit.lab7;

import java.util.ArrayList;
import java.util.Collections;;

/*  TestGamesProb2
 *  This is the test program to test GuessNumberGameVer4
 *     
 *  - test unsorted games
 *  - test sorted games by max tries and range
 *  - print result
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class TestGamesProb2 {
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>();

    public static void printGamesList(String msg) {
        System.out.println(msg);
        for (GuessNumberGameVer4 game : games) {
            System.out.println(game);
        }
    }

    public static void initGamesList() {
        games.add(new GuessNumberGameVer4(1, 20, 5));
        games.add(new GuessNumberGameVer4(1, 5, 5));
        games.add(new GuessNumberGameVer4(1, 9, 5));

        printGamesList("===== Unsorted games list: =====");
    }

    public static void sortGamesList() {
        Collections.sort(games, new SortByMaxTriesGuessRange());
        printGamesList("===== Sorted games list: =====");
    }

    public static void main(String[] args) {
        initGamesList();
        sortGamesList();
    }
}
