package boottapak.jakgrit.lab7;

import java.util.ArrayList;
import java.util.Collections;

/*  TestGamesProb1
 *  This is the test program to test GuessNumberGameVer4
 *     
 *  - test unsorted games
 *  - test sorted games by max tries
 *  - print result
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class TestGamesProb1 {
    static ArrayList<GuessNumberGameVer4> games = new ArrayList<GuessNumberGameVer4>();

    public static void printGamesList(String msg) {
        System.out.println(msg);
        for (GuessNumberGameVer4 game : games) {
            System.out.println(game);
        }
    }

    public static void initGamesList() {
        games.add(new GuessNumberGameVer4(1, 10, 8));
        games.add(new GuessNumberGameVer4(1, 10, 2));
        games.add(new GuessNumberGameVer4(1, 5, 5));

        printGamesList("===== Unsorted games list: =====");
    }

    public static void sortGamesList() {
        Collections.sort(games, new SortByMaxTries());
        printGamesList("===== Sorted games list: =====");
    }

    public static void main(String[] args) {
        initGamesList();
        sortGamesList();
    }
}
