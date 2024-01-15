package boottapak.jakgrit.lab6;

public class GuessNumberGameVer1 extends Game {
    protected int minNum, maxNum, correctNum, maxTries;
    protected int[] guesses;
    protected int numGuesses = 0;

    public GuessNumberGameVer1() {
        super("Guess Number Game", 1);
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game");
    }

    @Override
    public String toString() {
        System.out.print(super.toString());
        return "{ minNum='" + minNum + "', maxNum='" + maxNum + "', correctNum='" + correctNum +
        "', maxTries='" + maxTries + "'}";
    }
}
