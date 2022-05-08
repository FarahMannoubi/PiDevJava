/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Interfaces.IServiceAvis;
import Interfaces.IServiceMedia;
import Interfaces.IServiceProduit;
import Models.Avis;
import Models.Media;
import Models.Produit;
import Services.ServiceAvis;
import Services.ServiceMedia;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class MediaController implements Initializable {

    @FXML
    private TextField imageTF;
    @FXML
    private TextField videoTF;
    @FXML
    private TextField produitTF;
    @FXML
    private Button add1;
    @FXML
    private Button show2;
    @FXML
    private ListView<Media> mediaview;
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
    IServiceMedia md= new ServiceMedia();

    @FXML
    private void Add(ActionEvent event) {
        if (imageTF.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie l'image");
            alert.show();

        } 
            if (videoTF.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie le video");
            alert.show();
            }
            else {
        md.CreateMedia(new Media(Integer.parseInt(produitTF.getText()), imageTF.getText(), videoTF.getText()));
        
    }
    }
    


    
    @FXML
     private void Show(ActionEvent event) {
         IServiceMedia me= new ServiceMedia();
      List <Media> medview=new ArrayList<> ();
     mediaview.getItems().clear();
        javafx.scene.control.Label  des= new javafx.scene.control.Label();
       for(int i=0;i<me.fetchAllMedia().size();i++){
         Media ut=me.fetchAllMedia().get(i);
      //wrapping the label
      
           
      mediaview.getItems().addAll(ut);
       }
      
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        Media me=(Media) mediaview.getSelectionModel().getSelectedItem();
        md.DeleteMedia(me);
         mediaview.getItems().clear();
        javafx.scene.control.Label  des= new javafx.scene.control.Label();
       for(int i=0;i<md.fetchAllMedia().size();i++){
           Media ut1=md.fetchAllMedia().get(i);
      //wrapping the label
      
          mediaview.getItems().addAll(ut1);
        }
    }
    
     @FXML
    private void Update(ActionEvent event) {
         Media ma=(Media) mediaview.getSelectionModel().getSelectedItem();
         FXMLLoader fxmlLoader = new FXMLLoader();
                    System.out.println(ma);
                  try{
                      
                      fxmlLoader.setLocation(getClass().getResource("/gui/MediaUpdateController.fxml"));
                      Parent root = fxmlLoader.load();
                      Stage mainStage = new Stage();
                      Scene scene = new Scene(root);
                      mainStage.setScene(scene);
                      ProduitUpdateController produit = fxmlLoader.getController();
                      produit.sendData(ma);
                      mainStage.show();
                      mainStage.setResizable(false);

                      
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                      
                  }
        
    }
    
}

