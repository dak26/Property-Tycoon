/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.glass.ui.Screen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import gui.GameView;


/**
 *
 * @author Francois
 */
public class Welcome extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(Screen.getMainScreen().getWidth());
        primaryStage.setHeight(Screen.getMainScreen().getHeight());
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 650, 650, Color.PEACHPUFF);        
        Scene scene2 = new Scene(new GameView(primaryStage.getWidth(),primaryStage.getHeight()), primaryStage.getWidth(), primaryStage.getHeight(), Color.BLUE);
        Button btn = new Button("Let's play Property Tycoon!");
        
        btn.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
            primaryStage.show();
        });
        root.getChildren().add(btn);
        
        primaryStage.setTitle("Property Tycoon");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
//        primaryStage.initStyle(javafx.stage.StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
