/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.DemandeEvenement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class UpdateDemandeEvenementController implements Initializable {

    @FXML
    private Label lbDateFinEvent;
    @FXML
    private Label lbDateDemandeEvenement2;
    @FXML
    private Label lbDestination;
    @FXML
    private Label lbHeureDeb;
    @FXML
    private Label lbHeureFinEvent;
    @FXML
    private Label lbCapacite;
    @FXML
    private Label lbEvenement;
    @FXML
    private Label lbDescriptionDemandeEvent;
    @FXML
    private Label lbDescriptionEvenement;
    @FXML
    private TextField tfEvenement;
    @FXML
    private Label lbDateDemandeEvenement1;
    @FXML
    private TextField tfDescriptionDemandeEvenement1;
    @FXML
    private TextField tfDescriptionEvenement;
    @FXML
    private TextField tfCapacite;
    @FXML
    private TextField tfDateFinEvenement;
    @FXML
    private TextField tfDateDebEvenement;
    @FXML
    private ImageView imageEvent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(DemandeEvenement de){
        tfEvenement.setText(de.getLibelleEvenement());
        tfDescriptionDemandeEvenement1.setText(de.getDescription_demande());
        tfDateFinEvenement.setText(de.getDate_finEvent());
        tfDateDebEvenement.setText(de.getDate_debutEvent());
        System.out.println("de  "+de);
        
    }

    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
