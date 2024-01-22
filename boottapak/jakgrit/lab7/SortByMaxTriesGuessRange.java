package boottapak.jakgrit.lab7;

import java.util.Comparator;

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        if ((a.getMaxTries() - b.getMaxTries()) == 0) {
            return (b.getMaxNum() - b.getMinNum()) - (a.getMaxNum() - a.getMinNum());
        }
        return a.getMaxTries() - b.getMaxTries();
    }
}
