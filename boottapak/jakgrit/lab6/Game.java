package boottapak.jakgrit.lab6;

import java.util.Scanner;

public abstract class Game {
    protected String gameName;
    protected int numOfPlayers;
    Scanner input;

    public Game() {
        gameName = "unknown game";
        numOfPlayers = 0;
    }

    public Game(String gameName, int numOfPlayers) {
        this.gameName = gameName;
        this.numOfPlayers = numOfPlayers;
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

    public String toString() {
        return "{ gameName='" + gameName + "', numOfPlayer='" + numOfPlayers + "'}";
    }

    public abstract void playGame();
}
