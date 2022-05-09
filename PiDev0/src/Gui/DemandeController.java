/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.DemandeEvenement;
import Services.ServiceDemandeEvenement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
public class DemandeController implements Initializable {

    @FXML
    private Label lbEvenement;
    @FXML
    private Label lbDescriptionEvenement;
    @FXML
    private Label lbDescriptionDemande;
    @FXML
    private Label lbDateDebut;
    @FXML
    private Label lbDateFin;
    @FXML
    private Label lbHeureDebut;
    @FXML
    private Label lbHeureFin;

    /**
     * Initializes the controller class.
     */
    private ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
    DemandeEvenement de;
    @FXML
    private ImageView imageEvenet;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(DemandeEvenement evenement) throws FileNotFoundException{
        this.de=evenement;
    lbEvenement.setText(evenement.getLibelleEvenement());
    lbDescriptionEvenement.setText(evenement.getDescription_event());
    lbDescriptionDemande.setText(evenement.getDescription_demande());
    lbDateDebut.setText(evenement.getDate_debutEvent());
    lbDateFin.setText(evenement.getDate_finEvent());
    lbHeureDebut.setText(evenement.getHeure_debutEvent());
    lbHeureFin.setText(evenement.getHeure_finEvent());
   FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/image/"+evenement.getImage());
       
             Image image= new Image(inputStream);
             
         imageEvenet.setImage(image);
    }
    
     catch (FileNotFoundException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
    }
    @FXML
    private void Accepter(ActionEvent event) {
        sde.updateDemandeEvenementToAccepter(de);
        System.out.println("nnn"+de.getDate_debutEvent());
    }

    @FXML
    private void Refuser(ActionEvent event) {
        sde.updateDemandeEvenementToRefuser(de);
    }
    
}
