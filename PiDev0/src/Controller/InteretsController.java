/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListener;
import Models.Categorie;
import Services.ServiceCategorie;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class InteretsController implements Initializable {
    
    @FXML
    private Label labcategorie;
    

    /**
     * Initializes the controller class.
     */
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceCategorie sc=new ServiceCategorie() ;
      List<Categorie> categories = new ArrayList();
      categories= sc.ReadCategories();
      
        System.out.println(categories);
    for(Categorie c:categories){
     setChosenCategorie(c);
    }
        
     }
    
        private void setChosenCategorie(Categorie categorie) {
        
     labcategorie.setText(categorie.getLibelle());
     labcategorie.setText(categorie.getDescription());
            //System.out.println(categorie.getLibelle());
        
  }
      
    

} 
        
     
        
    

