/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import main.Player;

/**
 * The Token class handles the player's piece on the board, including its representation
 * and its animation as it moves around the board.
 *
 * @author Francois
 */
public class Token extends Pane {
    
    private Point2D pos;
    private Image avatar;
    private Player player;
    private Path tokenPath;
    private double size;
    Animator ani;
    
    public Token(Point2D pos, double boardSize) {
        this.pos = pos;
        size = boardSize/26;
        try {
            this.avatar = new Image(new FileInputStream("./assets/goblet.jpg"),size,size,false,false);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error! File not found.");
        }
        
        ImageView iv = new ImageView();
        iv.setImage(this.avatar);
        getChildren().addAll(new Circle(pos.getX(),pos.getY(),size/2),iv);
        
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public Path getPath() {
        return tokenPath;
    }
    
    public void setPath(Path tokenPath) {
        this.tokenPath = tokenPath;
    }
    
    
    
}
