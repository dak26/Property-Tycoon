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
 *
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

    public DiceGUI() throws FileNotFoundException {
        
        initialise();
        setProperties();
        btn.setOnAction(e -> rollDice());
    }
    
    public void initialise() throws FileNotFoundException{
        
        die1 = new Die(5);
        die2 = new Die(5);
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
    
    public void setProperties(){
        
        hb.setSpacing(20);     
        hb.getChildren().addAll(iv1, iv2);
        vb.getChildren().addAll(hb, btn);
        vb.setSpacing(10);
        this.getChildren().add(vb);
    }
    
    public void rollDice(){
        
        updateImageView(die1.roll(), die2.roll());
    }
    
    public void updateImageView(int die1, int die2){
        
        iv1 = new ImageView(diceimages[die1]);
        iv2 = new ImageView(diceimages[die2]);
        updateImage(iv1, iv2);
    }
    
    public void updateImage(ImageView iv1, ImageView iv2){
        
        hb.getChildren().clear();
        hb.getChildren().addAll(iv1, iv2);
    }
    
    
}