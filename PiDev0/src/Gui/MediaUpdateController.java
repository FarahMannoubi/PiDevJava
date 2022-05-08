/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Media;
import Models.Produit;
import Services.ServiceMedia;
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
public class MediaUpdateController implements Initializable {

    @FXML
    private Button update1;
    @FXML
    private TextField imageTF;
    @FXML
    private TextField videoTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void annuler(ActionEvent event) {
          GOTO(event,"..//gui//Media.fxml");
    }

   @FXML
    private void Update(ActionEvent event) {
       
    
        ServiceMedia ma =new ServiceMedia();
        
        if (imageTF.getText().length() == 0) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur");
            alert1.setHeaderText("Erreur de saisie !");
            alert1.setContentText("Le Champ description est obligatoire");
            alert1.show();}
          
        
      if (videoTF.getText().length() >255) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Erreur");
            alert2.setHeaderText("Erreur de saisie !");
            alert2.setContentText("La description ne doit pas depasser les 255 caractères ");
            alert2.show();}
             else{
    
          ma.UpdateMedia(new Media(imageTF.getText(), videoTF.getText()));
       
          GOTO(event,"..//gui//Media.fxml");  
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

    }
    


