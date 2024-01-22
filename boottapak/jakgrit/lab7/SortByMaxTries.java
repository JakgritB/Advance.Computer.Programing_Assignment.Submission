package boottapak.jakgrit.lab7;

import java.util.Comparator;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 a, GuessNumberGameVer4 b) {
        return a.getMaxTries() - b.getMaxTries();
    }
}