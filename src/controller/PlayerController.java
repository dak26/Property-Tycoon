/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gui.BoardView;
import main.Player;

/**
 *
 * @author Francois
 */
public class PlayerController {
    
    private static PlayerController instance;
    
    // we want only one instance of the PlayerController, as per the
    // Singleton design pattern. The getInstance() method will always return
    // the same controller object.
    private PlayerController() {}
    
    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }
    
    
    
}
