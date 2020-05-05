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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;
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

public class BoardView extends AnchorPane {
    
    // private File image("board-design"); This will be the image that serves as the board
    private static BoardView instance;
    private double length;
    private Token[] tokens;
    private HashMap<Integer, Point2D[]> spacePaths;
    private Point2D[][] pointArray;
    private Image boardImage;
    private ImageView iv;
    private Group imageGroup;   
    
    private BoardView() {}
    
    public static BoardView getInstance() {
        if (instance == null) {
            instance = new BoardView();
        }
        return instance;
    }
    
    public void setUp(double l) {
        tokens = new Token[10];

        this.length = l;
        spacePaths = new HashMap<>(); 
        
        File f = new File("./assets/pt_board.png");
        boardImage = new Image(f.toURI().toString(),l,l,false,false);
        
//        BackgroundImage backgroundImage = new BackgroundImage(boardImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//        BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
//        this.setMinSize(boardImage.getWidth(), boardImage.getHeight());
//        
//        Background background = new Background(backgroundImage);
//        setBackground(background);
        iv = new ImageView(boardImage);
        setImageSize(l*10/12);
        this.setLeftAnchor(iv,10.0);
        
        this.getChildren().add(iv);
        createPaths();
        placeTokens();
        System.out.println("this is " + iv.getBoundsInParent());
    }

    
    public Image getImage() {
        return boardImage;
    }
    
    public double getBoardLength() {
        return length;
    }
    
    public void setImageSize(double l) {
        iv.setPreserveRatio(true);
        iv.setFitHeight(l);
        iv.setFitWidth(l);
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
    
    public void createPointArray() {
        double x = length/26;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                Point2D pt = new Point2D((float)(i+0.5)*x,(float)(j+0.5)*x);
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
        path.getElements().add(new LineTo(token.getCoords(), selectPoint(tile)));
    }
    
    /**
     * Finds the first non-occupied point in the tile.
     * 
     * @param tile
     * @return 
     */    
    public Point2D selectPoint(Tile tile) {
        Point2D pointToReturn = null;
        for (Point2D point : tile.getPoints()) {
            if (!isOccupied(point)) {
                point = pointToReturn;
                break;
            }
        }
    }
            

    /**
     * Determines if a point is occupied by a token.
     * 
     * @param point
     * @return 
     */
    private boolean isOccupied(Point2D point) {
        
    }
    

    
}
