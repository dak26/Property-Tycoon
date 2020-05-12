/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.BoardView;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Francois
 */
public class Game {
    
    private BoardView gameboard;
    private Board board;
    private static LinkedList<Player> playerLL;
    private static Player startingPlayer;
    private static Player currentPlayer;
    boolean isAbridged, isActive;
    int playersActive;
    
    public Game (int playerCount) throws FileNotFoundException {
        for (int i = 0; i < playerCount; i++) {
            currentPlayer = startingPlayer;
        }
        board = new Board();
    }
    
    public static void nextPlayer() {
        currentPlayer = playerLL.get(playerLL.indexOf(currentPlayer)+1); 
    }
}



