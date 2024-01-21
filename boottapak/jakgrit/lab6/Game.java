package boottapak.jakgrit.lab6;

import java.util.Scanner;

public abstract class Game {
    protected String gameName;
    protected int numOfPlayers;
    Scanner input;

    public Game() {
        setName("unknown game");
        setNumOfPlayers(0);
    }

    public Game(String gameName, int numOfPlayers) {
        setName(gameName);
        setNumOfPlayers(numOfPlayers);
    }

    public String getName() {
        return gameName;
    }

    public void setName(String gameName) {
        this.gameName = gameName;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    @Override
    public String toString() {
        return "{ gameName='" + getName() + "', numOfPlayer='" + getNumOfPlayers() + "'} ";
    }

    public abstract void playGame();
}
