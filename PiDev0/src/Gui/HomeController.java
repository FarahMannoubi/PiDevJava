/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class HomeController implements Initializable {
private Parent fxml;
 
    @FXML
    private AnchorPane rootP;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         // TODO
         
         try{fxml=FXMLLoader.load(getClass().getResource("/Gui/ListEvenementClient2.fxml"));
        rootP.getChildren().removeAll();
        rootP.getChildren().setAll(fxml);
        
        }catch(IOException e){
        e.printStackTrace();}
    }   
    

    @FXML
    private void Admine(ActionEvent event) {
         try{fxml=FXMLLoader.load(getClass().getResource("/Gui/ListDemandeEvenemetAdmin.fxml"));
        rootP.getChildren().removeAll();
        rootP.getChildren().setAll(fxml);
        
        }catch(IOException e){
        e.printStackTrace();}
        
    }

    @FXML
    private void Partenaire(ActionEvent event) {
         try{fxml=FXMLLoader.load(getClass().getResource("/Gui/AddDemandeEvenement.fxml"));
        rootP.getChildren().removeAll();
        rootP.getChildren().setAll(fxml);
        
        }catch(IOException e){
        e.printStackTrace();}
    }

    @FXML
    private void Client(ActionEvent event) {
         try{fxml=FXMLLoader.load(getClass().getResource("/Gui/ListEvenementClient2.fxml"));
        rootP.getChildren().removeAll();
        rootP.getChildren().setAll(fxml);
        
        }catch(IOException e){
        e.printStackTrace();}
    }
    }    
    

