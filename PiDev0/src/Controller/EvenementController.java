/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListener;
import Models.DemandeEvenement;
import java.awt.event.MouseEvent;
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
public class EvenementController implements Initializable {

    @FXML
    private Label lbEvenement;
    @FXML
    private ImageView ImageEvenement;
  
  

    /**
     * Initializes the controller class.
     */
        private DemandeEvenement evenemet;
        private MyListener myListener ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  setData(evenemet);
        // TODO
    }    
      public void setData(DemandeEvenement evenement,MyListener myListener){
          this.myListener=myListener;
        this.evenemet=evenement;
        lbEvenement.setText(evenement.getLibelleEvenement());
         FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/image/"+evenement.getImage());
       
             Image image= new Image(inputStream);
             
        ImageEvenement.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    @FXML
    private void click(javafx.scene.input.MouseEvent event) {
        myListener.onClickListener(evenemet);
    }

  

   
     
}
