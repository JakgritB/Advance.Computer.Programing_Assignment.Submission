package boottapak.jakgrit.lab6;

/*  This program defines an abstract class named "Game" is a template for different games.
 *  It has variable: String "gameName", int "numOfPlayers", and a Scanner object for user input.
 *  The class has an abstract method "playGame()" to be implemented by subclasses.
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

import java.util.Scanner;

public abstract class Game {
    protected String gameName;
    protected int numOfPlayers;
    Scanner input;

    // Default constructor
    public Game() {
        setName("unknown game");
        setNumOfPlayers(0);
    }

    // Constructor that get 2 parameter
    // to set game name, number of players
    public Game(String gameName, int numOfPlayers) {
        setName(gameName);
        setNumOfPlayers(numOfPlayers);
    }

    // Getter and Setter method
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

    // Abstract method to be implemented by subclasses
    public abstract void playGame();
}
