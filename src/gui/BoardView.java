/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.glass.ui.Screen;
import java.io.File;
import java.util.HashMap;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;

/**
 * The BoardView class contains the board representation with its tokens.
 * The Tokens appear at a point relative to the board size.
 *
 * @author Francois
 */

// This is the graphical interface for the board.
// It will display the tokens, dice and cards. Players will see their token move
// across the board when they roll the dice.

public class BoardView extends StackPane {
    
    // private File image("board-design"); This will be the image that serves as the board
    private Token[] tokens;
    private double length;
    private HashMap<Integer, Point2D[]> spacePaths;
    private Point2D[] pointArray;
    private Image boardImage;
    private static BoardView instance;
    private Group imageGroup;
    
    public BoardView(double l) {
        tokens = new Token[10];

        this.length = l;
        spacePaths = new HashMap<>(); 
        
        File f = new File("./assets/pt_board.png");
        boardImage = new Image(f.toURI().toString(),Screen.getMainScreen().getHeight(),Screen.getMainScreen().getHeight(),false,false);
        
//        BackgroundImage backgroundImage = new BackgroundImage(boardImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//        BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
//        this.setMinSize(boardImage.getWidth(), boardImage.getHeight());
//        
//        Background background = new Background(backgroundImage);
//        setBackground(background);
        ImageView iv = new ImageView(boardImage);
        this.getChildren().add(iv);
        createPaths();
        placeTokens();
        System.out.println("this is " + iv.getBoundsInParent());
    }
    
    public static BoardView getInstance() {
        if (instance == null) {
            instance = new BoardView();
        }
        return instance;
    }
    
    private BoardView() {}
    
    public Image getImage() {
        return boardImage;
    }
    
    public double getBoardLength() {
        return length;
    }
    
    public void placeTokens() {
        for (Token token : tokens) {
            Token t =  new Token(spacePaths.get(0)[0],length);
            getChildren().add(t);
        }
        
    }
    
    // This is the underlying framework of the board. Each space will be mapped to
    // two points whose straight line bisects the space. Tokens will follow these
    // paths across the board, and settle on the one that has been rolled.
    
    // The points are created by methodically shifting the coordinates of two
    // placer points and recording their location.
    
    // This creates new variables from pointA and pointB in the method createBoard()
    // It will keep a record of the coordinates after pointA and pointB are changed.
    public Point2D[] newPoints(Point2D a, Point2D b) {
        Point2D[] newPoints = new Point2D[]{new Point2D(a.getX(),a.getY()),
            new Point2D(b.getX(),b.getY())};
        return newPoints;
    }
    
    public Path newPath(Point2D[] points) {
        Path path = new Path();
        return path;
    }
    
    public Point2D[] getPoints(int i) {
        return spacePaths.get(i);
    }
    
    public Path getPointPath(int i) {
        return new Path();
    }
    
    public void createPaths() {
        pointArray = new Point2D[2];
        double x = length/26; // this will be our unit
        Point2D pointA = new Point2D(350 + 26 * x, 22 * x);
        Point2D pointB = new Point2D(22 * x, 22 * x);
        System.out.println(pointA);
        spacePaths.put(0, newPoints(pointA, pointB));
        
        pointA.subtract(4 * x, 0);
        pointB.subtract(2 * x, 0);
        spacePaths.put(1, newPoints(pointA,pointB));
        
        for (int i = 2; i < 10; i++) {
            pointA.subtract(2 * x, 0);
            pointB.subtract(2 * x, 0);
            spacePaths.put(i, newPoints(pointA,pointB));
        }
        
        pointB.subtract(4 * x, 0);
        pointA.subtract(2 * x, 0);
        spacePaths.put(10, newPoints(pointA, pointB));
        
        pointB.add(2 * x, 6 * x);
        pointA.add(-2 * x, 2 * x);
        spacePaths.put(11, newPoints(pointA, pointB));
        
        for (int i = 12; i < 20; i++) {
            pointA.add(0, 2 * x);
            pointB.add(0, 2 * x);
            spacePaths.put(i, newPoints(pointA,pointB));
        }
        
        pointB.add(0, 4 * x);
        pointA.add(0, 2 * x);
        spacePaths.put(20, newPoints(pointA, pointB));
        
        pointB.add(6 * x, -2 * x);
        pointA.add(2 * x, 2 * x);
        spacePaths.put(21, newPoints(pointA, pointB));
        
        for (int i = 22; i < 30; i++) {
            pointA.add(2 * x, 0);
            pointB.add(2 * x, 0);
            spacePaths.put(i, newPoints(pointA, pointB));
        }
        
        pointB.add(4 * x, 0);
        pointA.add(2 * x, 0);
        spacePaths.put(30, newPoints(pointA, pointB));
        
        pointB.subtract(2 * x, 6 * x);
        pointA.subtract(-2 * x, 2 * x);
        spacePaths.put(31, newPoints(pointA, pointB));
        
        for (int i = 32; i < 40; i++) {
            pointA.subtract(0, 2 * x);
            pointB.subtract(0, 2 * x);
            spacePaths.put(i, newPoints(pointA, pointB));
        }
        
        
        
    }
    

    
}