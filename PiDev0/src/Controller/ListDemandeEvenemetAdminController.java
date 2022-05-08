/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListener;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class ListDemandeEvenemetAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ServiceDemandeEvenement de =new ServiceDemandeEvenement();
    private ServiceDestination sd=new ServiceDestination();
     private DemandeEvenement evenement;
     private MyListener myListener ; 
    @FXML
    private VBox DemandeEvenementLayout;
   
    @FXML
    private HBox heureDebut;
    @FXML
    private ImageView imageEvent;
    @FXML
    private Label lbDestination;
    @FXML
    private Label LbDesDemande;
    @FXML
    private Label lbLibEvenement;
    @FXML
    private Label LbCapacite;
    @FXML
    private Label LbDateDebEvent;
    @FXML
    private Label LbHeureDebEvent;
    @FXML
    private Label LbHeureFinEvent;
    @FXML
    private Label LbDateFinEvent;
    @FXML
    private JFXButton buttonAccepter;
    @FXML
    private JFXButton buttonRefuser;
    @FXML
    private Label lbDescriptionEvenement;
    @FXML
    private VBox CoutEvenementLayout;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbNombreBillets;
    @FXML
    private Label lbPrix;
    
     
    
    
     private DemandeEvenement setChosenEvenement(DemandeEvenement evenement) {
 this.evenement=evenement;
  lbLibEvenement.setText(evenement.getLibelleEvenement());
   String nomDestination=sd.GetNomDestinationsById(evenement.getDestination());
  lbDestination.setText(nomDestination);
  LbDesDemande.setText(evenement.getDescription_demande());
  lbLibEvenement.setText(evenement.getLibelleEvenement());
 // LbCapacite.setText(evenement.getCapacite());
 LbDateDebEvent.setText(evenement.getDate_debutEvent());
 LbHeureDebEvent.setText(evenement.getHeure_debutEvent());
 LbHeureFinEvent.setText(evenement.getHeure_finEvent());
 lbDescriptionEvenement.setText(evenement.getDescription_event());
        
   LbDateFinEvent.setText(evenement.getDate_finEvent());
  
        
       FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/dell/Desktop/PIDEV_CACT/PIDEV_CACT/public/upload/imageJava/"+evenement.getImage());
       
             Image image= new Image(inputStream);
             
        imageEvent.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evenement;
         }  
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         List<DemandeEvenement> evenements=de.GetDemandeEvenement();
              if (evenements.size() > 0) {
            setChosenEvenement(evenements.get(0));
          myListener = new MyListener() {
                @Override
                public void onClickListener(DemandeEvenement evenement) {
                    setChosenEvenement(evenement);
                }

                
            };
        }
          for(int i=0;i<evenements.size();i++){
          
            FXMLLoader fxmlLoader = new FXMLLoader();
        
             fxmlLoader.setLocation(getClass().getResource("/Gui/Demande.fxml"));
     
             try {
                 HBox hBox=fxmlLoader.load();
                  DemandeController demandeController=fxmlLoader.getController();
                  demandeController.setData(evenements.get(i),myListener);
           
             
             DemandeEvenementLayout.getChildren().add(hBox);
             
             } catch (IOException ex) {
                  ex.printStackTrace();
             }
    } 
    }

    @FXML
    private void AccepterDemenedeEvenement(ActionEvent event) {
      de.updateDemandeEvenementToAccepter(evenement);
    }

    @FXML
    private void RefuserDemenedeEvenement(ActionEvent event) {
        de.updateDemandeEvenementToRefuser(evenement);
    }

    
    
}
