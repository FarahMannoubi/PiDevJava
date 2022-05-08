/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.CoutCategorie;
import Models.CoutEvenement;
import Services.ServiceCoutCategorie;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
     List<CoutCategorie>CoutCategories=new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    public void setData(CoutEvenement ce){



        
        CoutCategories=scc.GetLibelleCoutCategorieByIdCoutCategorie(ce.getId());
        for(CoutCategorie cc:CoutCategories){
            System.out.println("cc   "+cc);
             lbCategorie.setText(cc.getLibelle());
              String prixString=Float.toString((float) ce.getPrix());
            String ndDilletsString=Integer.toString( ce.getNbBillet());
            lbNombreBillets.setText(ndDilletsString);
             lbPrix.setText(prixString);
         }
         String ndDilletsString=Integer.toString( ce.getNbBillet());
            lbNombreBillets.setText(ndDilletsString);
        System.out.println("testGit");

    }
    
}
