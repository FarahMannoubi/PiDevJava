/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Interfaces.IServiceAvis;
import Interfaces.IServiceProduit;
import Models.Avis;
import Models.Produit;
import Services.ServiceAvis;
import Services.ServiceProduit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ProduitController implements Initializable {

    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField avisTF;
    @FXML
    private Button add;
    @FXML
    private Button showp;
    @FXML
    private Label show;
    @FXML
    private ListView<Produit> prodview;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    IServiceProduit pa= new ServiceProduit();

    @FXML
    private void Add(ActionEvent event) {
        if (descriptionTF.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie le description");
            alert.show();

        } else {
        pa.CreateProduit(new Produit(Integer.parseInt(avisTF.getText()), descriptionTF.getText()));
        
    }
    }

    @FXML
     void Show(ActionEvent event) {
        IServiceProduit pa= new ServiceProduit();
      List <Produit> pdview=new ArrayList<> ();
    prodview.getItems().clear();
        javafx.scene.control.Label  des= new javafx.scene.control.Label();
       for(int i=0;i<pa.fetchAllProduit().size();i++){
           Produit ut=pa.fetchAllProduit().get(i);
      //wrapping the label
           
      prodview.getItems().addAll(ut);
       }
     }

    @FXML
    private void Delete(ActionEvent event) {
        Produit pt=(Produit) prodview.getSelectionModel().getSelectedItem();
        pa.DeleteProduit(pt);
         prodview.getItems().clear();
        javafx.scene.control.Label  des= new javafx.scene.control.Label();
       for(int i=0;i<pa.fetchAllProduit().size();i++){
           Produit ut1=pa.fetchAllProduit().get(i);
      //wrapping the label
      
          prodview.getItems().addAll(ut1);
        }
         }  

    @FXML
    private void Update(ActionEvent event) {
         Produit pr=(Produit) prodview.getSelectionModel().getSelectedItem();
         FXMLLoader fxmlLoader = new FXMLLoader();
                    System.out.println(pr);
                  try{
                      
                      fxmlLoader.setLocation(getClass().getResource("/gui/ProduitUpdateController.fxml"));
                      Parent root = fxmlLoader.load();
                      Stage mainStage = new Stage();
                      Scene scene = new Scene(root);
                      mainStage.setScene(scene);
                      ProduitUpdateController produit = fxmlLoader.getController();
                      produit.sendData(pr);
                      mainStage.show();
                      mainStage.setResizable(false);

                      
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                      
                  }
        
    }
}

    
   
        
    
    

