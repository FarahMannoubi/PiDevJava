/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.AddDemandeEvenementController;
import Models.DemandeEvenement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class EvenementFavorableController implements Initializable {

    @FXML
    private ImageView imageEvenement;
    @FXML
    private Label lbLibelleEvenement;

    /**
     * Initializes the controller class.
     */
    private DemandeEvenement evenemet;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  setData(evenemet);
        // TODO
    }    
    public void setData(DemandeEvenement evenement){
        System.out.println("evenemet "+evenemet);
          this.evenemet=evenement;
        lbLibelleEvenement.setText(evenemet.getLibelleEvenement());
        FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/dell/Desktop/PIDEV_CACT/PIDEV_CACT/public/upload/imageJava/"+evenement.getImage());
       
             Image image= new Image(inputStream);
             
        imageEvenement.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
