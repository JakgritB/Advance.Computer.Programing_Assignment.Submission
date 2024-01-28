package boottapak.jakgrit.lab7;

import boottapak.jakgrit.lab5.GuessNumberGameVer3;

/*  This program is "GuessNumberGameVer4" that extends the class "GuessNumberGameVer3"
 *  that import from package "boottapak.jakgrit.lab5.GuessNumberGameVer3"
 *  the program is the same as GuessNumberGameVer3
 *  but Override method toString to new format
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class GuessNumberGameVer4 extends GuessNumberGameVer3 {

    // Default constructor
    public GuessNumberGameVer4() {
        super();
    }

    // Constructor with two parameters
    public GuessNumberGameVer4(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    // Constructor with three parameters
    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return "GuessNumberGameVer4 (min:" + getMinNum() + ", max:" +
                getMaxNum() + ", max tries:" + getMaxTries() + ")";
    }
}