/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Media;
import Models.Produit;
import Services.ServiceProduit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ProduitUpdateController implements Initializable {

    @FXML
    private TextField descriptionTF;
    @FXML
    private Button update1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void annuler(ActionEvent event) {
          GOTO(event,"..//gui//Produit.fxml");
    }
    @FXML
    private void Update(ActionEvent event) {
        ServiceProduit sp =new ServiceProduit();
        
      if (descriptionTF.getText().length() >255) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Erreur");
            alert2.setHeaderText("Erreur de saisie !");
            alert2.setContentText("La description ne doit pas depasser les 255 caractères ");
            alert2.show();}
             else{
    
          sp.UpdateProduit(new Produit(descriptionTF.getText()));
       
          GOTO(event,"..//gui//Produit.fxml");  
    }
    }


            
             private void GOTO (ActionEvent event ,String interfaceFXML){
         try{
                 FXMLLoader loader=new FXMLLoader(getClass().getResource(interfaceFXML));
                 Parent root =loader.load();
                 Stage stage;
                 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                 Scene scene=new Scene(root);
                 stage.setScene(scene);
                 stage.show();
             }
        catch(IOException ex){
        ex.printStackTrace();}
    }

    void sendData(Produit pr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void sendData(Media ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
    

