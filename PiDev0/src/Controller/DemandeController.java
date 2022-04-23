/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.MyListener;
import Models.DemandeEvenement;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import Services.ServiceUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class DemandeController implements Initializable {

    @FXML
    private Label lbDateDemande;
    @FXML
    private Label lbUtilisateur;
    @FXML
    private Label lbDestination;
    @FXML
    private Label lbLibelleEvenement;

    /**
     * Initializes the controller class.
     */
     private MyListener myListener ;
    private DemandeEvenement evenemet;
    private ServiceUser su=new ServiceUser();
    private ServiceDestination sd=new ServiceDestination();
     ServiceDemandeEvenement de =new ServiceDemandeEvenement();
    @FXML
    private HBox HBoxDemnade;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(DemandeEvenement evenement,MyListener myListener){
          this.myListener=myListener;
         this.evenemet=evenement;
        String NameUser=su.getNomUserById(evenement.getUtilisateur());
        String nomDestination=sd.GetNomDestinationsById(evenement.getDestination());
        lbDateDemande.setText(evenement.getDate_demande());
        lbLibelleEvenement.setText(evenement.getLibelleEvenement());
        lbUtilisateur.setText(NameUser);
       lbDestination.setText(nomDestination);
       if(evenement.getStatut()=="Accepter" ){
            
        lbDateDemande.setText(evenement.getDate_demande());
        lbLibelleEvenement.setText(evenement.getLibelleEvenement());
        lbUtilisateur.setText(NameUser);
       lbDestination.setText(nomDestination);
       String coleur="f09797";
       HBoxDemnade.setStyle("-fx-background-color: #"+coleur+";");
       }
        
    }
        
    

    @FXML
    private void click(MouseEvent event) {
          myListener.onClickListener(evenemet);
    }

    @FXML
    private void SupprimerDemenedeEvenement(ActionEvent event) {
        de.deleteDemandeEvenement(evenemet.getId());
    }
}
