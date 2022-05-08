/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.EvenementController;
import Interfaces.MyListener;
import Models.DemandeEvenement;
import Services.ServiceDemandeEvenement;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class ListEvenementClient2Controller implements Initializable {

    @FXML
    private HBox listEvenementFavorable;

    /**
     * Initializes the controller class.
     */
    ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
     private MyListener myListener ; 
     Parent fxml;
   
    @FXML
    private GridPane EvenementContainer;
    private AnchorPane ListEvenementClient;
    @FXML
    private AnchorPane ListEvenementClient1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GetListEvnementFavorable();
        GetListEvnement();
        // TODO
    }   
     public void GetListEvnementFavorable(){
         
     
           List<DemandeEvenement> evenements=sde.GetDemandeEvenement();
           
           try{
    for(int i=0;i<evenements.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
    
             fxmlLoader.setLocation(getClass().getResource("EvenementFavorable.fxml"));
     
             HBox eventBox = fxmlLoader.load();
             EvenementFavorableController evenementFavorableController=fxmlLoader.getController();
                // System.out.println("evenements "+evenements.get(i));
             evenementFavorableController.setData(evenements.get(i));
             listEvenementFavorable.getChildren().add(eventBox);
               
           }
      
           }
           catch(IOException e){
    e.printStackTrace();
    
     }
    
}
      public void GetListEvnement(){
            List<DemandeEvenement> evenements=sde.GetDemandeEvenement();
                //     if (evenements.size() > 0) {
           // setChosenEvenement(evenements.get(0));
          
        //}
           int column=0;
           int row=1;
           try{
    for(int i=0;i<evenements.size();i++){
  
                FXMLLoader fxmlLoader = new FXMLLoader();
    
             fxmlLoader.setLocation(getClass().getResource("Evenement.fxml"));
     
             AnchorPane eventBox = fxmlLoader.load();
             EvenementController evenementController=fxmlLoader.getController();
            
             evenementController.setData(evenements.get(i));
          
           
            if(column==5)
            {
                column=0;
                ++row;
            }  
            EvenementContainer.add(eventBox, column++, row);
            GridPane.setMargin(eventBox, new Insets(10));
           }
      
           }
           catch(IOException e){
    e.printStackTrace();
    
     }
          
          
          
      }
    //  public void AfficheEvenementDetail(Parent fxml){
     //     this.fxml=fxml;
     //     ListEvenementClient1.getChildren().removeAll();
     //        ListEvenementClient1.getChildren().setAll(fxml);
    //  }
     
}
