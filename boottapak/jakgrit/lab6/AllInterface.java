package boottapak.jakgrit.lab6;

/*  This code defines three interfaces: HasRule, UseBoard, and UseDice.
 *  These interfaces declare methods for implementing game rules, 
 *  setting up a game board, and rolling dice.
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

interface HasRule {
    public void gameRule();
}

interface UseBoard {
    public void setUpBoard();
}

interface UseDice {
    public void rollDice();
}