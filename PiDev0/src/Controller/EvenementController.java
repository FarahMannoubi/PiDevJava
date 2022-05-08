/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gui.EvenementDetailController;
import Gui.HomeController;
import Gui.ListEvenementClient2Controller;
import Interfaces.MyListener;
import Models.DemandeEvenement;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        private Parent fxml; 
        ListEvenementClient2Controller lec2c=new  ListEvenementClient2Controller();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        // TODO
    }   

    public void setData(DemandeEvenement evenement){

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
        try {
       
        FXMLLoader fxmlLoader = new FXMLLoader();
          fxmlLoader.setLocation(getClass().getResource("/Gui/EvenementDetail.fxml"));
          Parent root = fxmlLoader.load();
                      Stage stage;
                      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                      Scene scene=new Scene(root);
                      stage.setScene(scene);
                      stage.show();
           EvenementDetailController evenementDetailController=fxmlLoader.getController();
           evenementDetailController.setChosenEvenement(evenemet);
      
             
         
        // fxml=FXMLLoader.load(getClass().getResource("/Gui/EvenementDetail.fxml"));
    // lec2c.AfficheEvenementDetail(fxml);
         

       } catch (IOException ex) {
           Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

  

   
     
}
