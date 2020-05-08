/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.util.HashMap;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import tile.Tile;

/**
 * The BoardView class contains the board representation with its tokens.
 * The Tokens appear at a point relative to the board size.
 *
 * @author Francois
 */

// This is the graphical interface for the board.
// It will display the tokens, dice and cards. Players will see their token move
// across the board when they roll the dice.

public class BoardView extends Pane {
    
    // private File image("board-design"); This will be the image that serves as the board
    private static BoardView instance;
    private double length;
    private Token[] tokens;
    private HashMap<Integer, Point2D[]> spacePaths;
    private Point2D[][] pointArray;
    private Image boardImage;
    private Group imageGroup;   
    
    private BoardView() {}
    
    public static BoardView getInstance() {
        if (instance == null) {
            instance = new BoardView();
        }
        return instance;
    }
    
    public void setUp(double l) {
        setPrefSize(l,l);
        tokens = new Token[6];

        this.length = l;
        
        File f = new File("./assets/pt_board.png");
        boardImage = new Image(f.toURI().toString(),l,l,false,false);
        
        Canvas canvas = new Canvas(length,length);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.drawImage(boardImage, 0, 0);
        this.getChildren().add(canvas);
        
//        setImageSize(l*10/12);
        createPointArray();
    }

    
    public Image getImage() {
        return boardImage;
    }
    
    public double getBoardLength() {
        return length;
    }
    
//    public void setImageSize(double l) {
//        iv.setPreserveRatio(true);
//        iv.setFitHeight(l);
//        iv.setFitWidth(l);
//    }
    
    // Tokens to be placed on the Go tile's coordinates    
    public void placeTokens(Tile tile) {
        for (Point2D coords : tile.getCoordinates()) {
            Token t = new Token(coords,this.getBoardLength());
            this.getChildren().add(t);
        }
        
    }

        
    
    // This is the underlying framework of the board. Each space will be mapped to
    // two points whose straight line bisects the space. Tokens will follow these
    // paths across the board, and settle on the one that has been rolled.
    
    // The points are created by methodically shifting the coordinates of two
    // placer points and recording their location.
    
    // This creates new variables from pointA and pointB in the method createBoard()
    // It will keep a record of the coordinates after pointA and pointB are changed.
    
    public void createPointArray() {
        double x = length/26;
        pointArray = new Point2D[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                Point2D pt = new Point2D((float)((i+0.5)*x),(float)((j+0.5)*x));
                pointArray[i][j] = pt;
            }
        }
    }
    
    /**
     * Moves the given token to the given tile.
     * 
     * @param token
     * @param tile 
     */
    public void moveTokenToTile(Token token, Tile tile) {
        Path path = new Path();
        PathTransition pt = new PathTransition();
        
        Point2D coords = selectPoint(tile);
        path.getElements().add(new LineTo(coords.getX(), coords.getY()));
        
        pt.setNode(token);
        pt.setPath(path);
        pt.setDuration(Duration.seconds(1));
        
        pt.play();        
    }
    
    /**
     * Finds the first non-occupied point in the tile.
     * 
     * @param tile
     * @return 
     */    
    private Point2D selectPoint(Tile tile) {
        Point2D pointToReturn = null;
        for (Point2D point : tile.getCoordinates()) {
            if (!isOccupied(point)) {
                pointToReturn = point;
                break;
            }
        }
        return pointToReturn;
    }
            

    /**
     * Determines if a point is occupied by a token.
     * 
     * @param point
     * @return 
     */
    private boolean isOccupied(Point2D point) {
        boolean isOccupied = false;
        for (Token t : tokens) {
            if (t.getPos() == point) {
                isOccupied = true;
            }
        }
        return isOccupied;
    }
    

    
}