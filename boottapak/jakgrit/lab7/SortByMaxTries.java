package boottapak.jakgrit.lab7;

import java.util.Comparator;

/*  This program is "SortByMaxTries" that implements the "Comparator"
 *  It used for sort objects of GuessNumberGameVer4 based on maxTries.
 *  sort from hard game to easy game
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        return a.getMaxTries() - b.getMaxTries();
        // a - b is small to big value
    }
}