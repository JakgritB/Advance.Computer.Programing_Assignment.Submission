package boottapak.jakgrit.lab7;

import java.util.Comparator;

/*  This program is "SortByMaxTriesGuessRange" that implements the "Comparator"
 *  It used for sort objects of GuessNumberGameVer4 
 *  based on maxTries first and then sort by range(max num - min num).
 *  sort from hard game to easy game
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        // if maxTries a - b = 0 : it has the same maxTries
        if ((a.getMaxTries() - b.getMaxTries()) == 0) {
            // if maxTries is the same, it will sort by range.(from big to small value)
            return (b.getMaxNum() - b.getMinNum()) - (a.getMaxNum() - a.getMinNum());
        }
        return a.getMaxTries() - b.getMaxTries(); // this line is when maxTries isn't same
    }
}
