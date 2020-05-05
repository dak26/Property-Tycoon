/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.glass.ui.Screen;
import java.io.FileNotFoundException;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * The GameView class holds the BoardView, the Menu and the Log.
 * It extends the BorderPane class.
 *
 * @author Francois
 */
public class GameView extends BorderPane {
    
    public GameView(double width, double height) throws FileNotFoundException {
        setPrefHeight(height);
        setPrefWidth(width);
        setCenter(new BoardView(height));
        setBottom(new StackPane());                
    }
    
}
