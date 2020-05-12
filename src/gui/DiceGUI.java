/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Die;

/**
 * DiceGUI represents the two graphical dice that will be superimposed on top
 * of the Property Tycoon Board.
 * @author Dan
 */
public class DiceGUI extends Pane{
    
    Die die1;
    Die die2;
    Image[] diceimages;
    ImageView iv1;
    ImageView iv2;
    VBox vb;
    HBox hb;
    Button btn;

    /**
     * Constructor to instantiate and set up an instance of the DiceGUI
     * @throws FileNotFoundException 
     */
    public DiceGUI() throws FileNotFoundException {
        
        initialise();
        setProperties();
        btn.setOnAction(e -> rollDice());
    }
    
    /**
     * Instantiates two dice and six dice roll images
     * @throws FileNotFoundException 
     */
    public void initialise() throws FileNotFoundException{
        
        die1 = new Die(6);
        die2 = new Die(6);
        diceimages = new Image[6];
        for(int i = 0; i < 6; i++){
            diceimages[i] = new Image(new FileInputStream("./assets/roll".concat(Integer.toString(i+1))+".png"));
        }
        iv1 = new ImageView(diceimages[5]);
        iv2 = new ImageView(diceimages[5]);
        vb = new VBox();
        hb = new HBox();
        btn = new Button("Roll Dice");
    }
    
    /**
     * Inserts the nodes into the this instance and sets the spacing properties
     */
    public void setProperties(){
        
        hb.setSpacing(20);     
        hb.getChildren().addAll(iv1, iv2);
        vb.getChildren().addAll(hb, btn);
        vb.setSpacing(10);
        btn.setMaxWidth(Double.MAX_VALUE);
        this.getChildren().add(vb);

    }
    
    /**
     * Rolls a number between 1-6 and displays the correct dice roll image
     */
    public void rollDice(){
        
        updateImageView(die1.roll(), die2.roll());
    }
    
    /**
     * Updates the ImageView image with the correct dice roll
     * @param die1 dice roll (1): 1-6
     * @param die2 dice roll (2): 1-6
     */
    public void updateImageView(int die1, int die2){
        
        iv1 = new ImageView(diceimages[die1-1]);
        iv2 = new ImageView(diceimages[die2-1]);
        updateImage(iv1, iv2);
    }
    
    /**
     * Updates the actual image of the dice roll
     * @param iv1
     * @param iv2 
     */
    public void updateImage(ImageView iv1, ImageView iv2){
        
        hb.getChildren().clear();
        hb.getChildren().addAll(iv1, iv2);
    }
    
    
}