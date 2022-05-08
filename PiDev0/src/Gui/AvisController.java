/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Interfaces.IServiceAvis;
import Models.Avis;
import Models.Media;
import Services.ServiceAvis;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AvisController implements Initializable {

    @FXML
    private TextField demandeevenementTF;
    @FXML
    private TextField utilisateurTF;
    @FXML
    private TextField commentaireTF;
    @FXML
    private TextField noteTF;
    @FXML
    private Button add;
    @FXML
    private Button show;
    @FXML
    private ListView<Avis> avissview;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    IServiceAvis ia= new ServiceAvis();

    @FXML
    private void Add(ActionEvent event) {
        if (commentaireTF.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie le commentaire");
            alert.show();

        } else {
            
            ia.CreateAvis(new Avis(commentaireTF.getText(), Integer.parseInt(noteTF.getText()), Integer.parseInt(demandeevenementTF.getText()), Integer.parseInt(utilisateurTF.getText())));
        }
      
    }

    @FXML
    private void Show(ActionEvent event) {
         IServiceAvis sa= new ServiceAvis();
      List <Avis> avisview=new ArrayList<> ();
     avissview.getItems().clear();
        javafx.scene.control.Label  des= new javafx.scene.control.Label();
       for(int i=0;i<sa.fetchAllAvis().size();i++){
           Avis ut=sa.fetchAllAvis().get(i);
      //wrapping the label
      avissview.getItems().addAll(ut);
      
       }
    }

    @FXML
    private void Delete(ActionEvent event) {
    Avis av=(Avis) avissview.getSelectionModel().getSelectedItem();
        ia.DeleteAvis(av.getId());
         avissview.getItems().clear();
        javafx.scene.control.Label  des= new javafx.scene.control.Label();
       for(int i=0;i<ia.fetchAllAvis().size();i++){
           Avis ut1=ia.fetchAllAvis().get(i);
      //wrapping the label
      
          avissview.getItems().addAll(ut1);
        }
    }
    
    
    }
    

