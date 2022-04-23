/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author manou
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
Parent root = FXMLLoader.load(getClass().getResource("AddDemandeEvenement.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("ListeEvenementCilent.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("ListDemandeEvenemetAdmin.fxml"));
    stage.initStyle(StageStyle.UNDECORATED);
   
    Scene scene = new Scene(root);
    
    stage.setScene(scene);
    stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
