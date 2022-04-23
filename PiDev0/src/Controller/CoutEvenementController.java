/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.CoutEvenement;
import Services.ServiceCoutCategorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class CoutEvenementController implements Initializable {

    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbNombreBillets;
    @FXML
    private Label lbPrix;

    /**
     * Initializes the controller class.
     */
     ServiceCoutCategorie scc=new ServiceCoutCategorie();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(CoutEvenement ce){
        scc.GetLibelleCoutCategorieByIdCoutCategorie(ce.getId());
<<<<<<< HEAD
        
=======
        System.out.println("testGit");
>>>>>>> event
        //lbCategorie
    }
    
}
