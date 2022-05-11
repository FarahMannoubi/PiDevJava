/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gui.HomeController;
import Gui.UpdateDemandeEvenementController;
import Models.DemandeEvenement;
import Models.Destination;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import Services.ServiceSousCategorie;
import Services.ServiceUser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class ListDemendeEvenementPartenaireController implements Initializable {
    private Parent fxml;
ServiceDestination sd=new ServiceDestination();
        ServiceSousCategorie ssc = new ServiceSousCategorie();
        ServiceDemandeEvenement sde = new ServiceDemandeEvenement();
       ServiceUser su=new ServiceUser();
        private String nomDestination;
        private String nomUser;
        private String evenement,nomSousCategorie;
    @FXML
    private ListView<DemandeEvenement> listView;
    @FXML
    private AnchorPane ParentListDemendeEvenementPartenaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Afficher();
    }    
public void Afficher(){

 listView.getItems().clear();
 listView.setCellFactory(param -> new ListCell<DemandeEvenement>(){
            
            protected void updateItem(DemandeEvenement de, boolean empty) {
                super.updateItem( de, empty);
                if (empty || de==null) {
                    setGraphic(null);
                    setText(null); 
                }else{
                    
                    // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    // allow wrapping
                    setWrapText(true);
                    // HBox dispose ses enfants sur une seule ligne horizontale.
                    HBox root = new HBox(10);
                    root.setAlignment(Pos.CENTER);
                    root.setPadding(new Insets(10 ,10, 20, 0));
                            
                    root.getChildren().add(new Label(de.getStatut()));
                    
                    Region region = new Region();
                    HBox.setHgrow(region, Priority.ALWAYS);
                    root.getChildren().add(region);
                    
                    
                    root.getChildren().add(new Label(de.getDate_demande()));
                     
                     Region region1 = new Region();
                    HBox.setHgrow(region1, Priority.ALWAYS);
                    root.getChildren().add(region1);
               
                   // evenement=sde.getNomUserById(de.getUtilisateur());
                    nomDestination=sd.GetNomDestinationsById(de.getDestination());
                      root.getChildren().add(new Label(nomDestination));
                     
                    Region region2 = new Region();
                    HBox.setHgrow(region2, Priority.ALWAYS);
                    root.getChildren().add(region2);
                    
                     root.getChildren().add(new Label(de.getLibelleEvenement()));
                     
                    Region region3 = new Region();
                    HBox.setHgrow(region3, Priority.ALWAYS);
                    root.getChildren().add(region3);
                      root.getChildren().add(new Label(de.getDate_debutEvent()));
                     
                    Region region4 = new Region();
                    HBox.setHgrow(region4, Priority.ALWAYS);
                    root.getChildren().add(region4);
                    
                    root.getChildren().add(new Label(de.getDate_finEvent()));
                     
                    Region region5 = new Region();
                    HBox.setHgrow(region5, Priority.ALWAYS);
                    root.getChildren().add(region5);
                    
                    
                    //nomSousCategorie=ssc.GetSousCategorieByIdDemandeEvenement(de.get)
setGraphic(root);
                 }
            
            }
        });
 listView.getItems().addAll(sde.GetDemandeEvenement());
            }
         
    





@FXML
    private void modifierDemande(ActionEvent event) {
         DemandeEvenement de=(DemandeEvenement)  listView.getSelectionModel().getSelectedItem();
         if(de!=null){
         FXMLLoader fxmlLoader = new FXMLLoader();
         try {
             
               fxmlLoader.setLocation(getClass().getResource("/gui/UpdateDemandeEvenement.fxml"));
           
               Parent root = fxmlLoader.load();
                      Stage stage;
                      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                      Scene scene=new Scene(root);
                      stage.setScene(scene);
                      stage.show();
                      UpdateDemandeEvenementController updateDemandeEvenementController =fxmlLoader.getController();
 
  
updateDemandeEvenementController.setData(de);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    }

    @FXML
    private void SupprimarDemande(ActionEvent event) {
    }

    @FXML
    private void ajouterDemade(ActionEvent event) {
         try {
              FXMLLoader fxmlLoader = new FXMLLoader();
               //fxmlLoader.setLocation(getClass().getResource("/gui/AddCoutEvenement.fxml"));
           fxml=FXMLLoader.load(getClass().getResource("/gui/AddDemandeEvenement.fxml"));
          ParentListDemendeEvenementPartenaire.getChildren().removeAll();
            ParentListDemendeEvenementPartenaire.getChildren().setAll(fxml);
              
                     
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    @FXML
    private void getListDemandeEnAttante(ActionEvent event) {
        listView.getItems().clear();
    listView.setCellFactory(param -> new ListCell<DemandeEvenement>(){
            
     protected void updateItem(DemandeEvenement de, boolean empty) {
                super.updateItem( de, empty);
                if (empty || de==null) {
                    setGraphic(null);
                    setText(null); 
                }else{
                     // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    // allow wrapping
                    setWrapText(true);
                    // HBox dispose ses enfants sur une seule ligne horizontale.
                    HBox root = new HBox(10);
                    root.setAlignment(Pos.CENTER);
                    root.setPadding(new Insets(10 ,10, 20, 0));
                            
                    root.getChildren().add(new Label(de.getStatut()));
                    
                    Region region = new Region();
                    HBox.setHgrow(region, Priority.ALWAYS);
                    root.getChildren().add(region);
                    
                    
                    root.getChildren().add(new Label(de.getDate_demande()));
                     
                     Region region1 = new Region();
                    HBox.setHgrow(region1, Priority.ALWAYS);
                    root.getChildren().add(region1);
               
                   // evenement=sde.getNomUserById(de.getUtilisateur());
                    nomDestination=sd.GetNomDestinationsById(de.getDestination());
                      root.getChildren().add(new Label(nomDestination));
                     
                    Region region2 = new Region();
                    HBox.setHgrow(region2, Priority.ALWAYS);
                    root.getChildren().add(region2);
                    
                     root.getChildren().add(new Label(de.getLibelleEvenement()));
                     
                    Region region3 = new Region();
                    HBox.setHgrow(region3, Priority.ALWAYS);
                    root.getChildren().add(region3);
                      root.getChildren().add(new Label(de.getDate_debutEvent()));
                     
                    Region region4 = new Region();
                    HBox.setHgrow(region4, Priority.ALWAYS);
                    root.getChildren().add(region4);
                    
                    root.getChildren().add(new Label(de.getDate_finEvent()));
                     
                    Region region5 = new Region();
                    HBox.setHgrow(region5, Priority.ALWAYS);
                    root.getChildren().add(region5);
                    
                    
                    //nomSousCategorie=ssc.GetSousCategorieByIdDemandeEvenement(de.get)
setGraphic(root);
                 }
            
     }
        });
listView.getItems().addAll(sde.GetDemandeEvenementEnAttante());
        
    }

    @FXML
    private void getListDemandeAccepter(ActionEvent event) {
        
        
                listView.getItems().clear();
    listView.setCellFactory(param -> new ListCell<DemandeEvenement>(){
            
     protected void updateItem(DemandeEvenement de, boolean empty) {
                super.updateItem( de, empty);
                if (empty || de==null) {
                    setGraphic(null);
                    setText(null); 
                }else{
                     // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    // allow wrapping
                    setWrapText(true);
                    // HBox dispose ses enfants sur une seule ligne horizontale.
                    HBox root = new HBox(10);
                    root.setAlignment(Pos.CENTER);
                    root.setPadding(new Insets(10 ,10, 20, 0));
                            
                    root.getChildren().add(new Label(de.getStatut()));
                    
                    Region region = new Region();
                    HBox.setHgrow(region, Priority.ALWAYS);
                    root.getChildren().add(region);
                    
                    
                    root.getChildren().add(new Label(de.getDate_demande()));
                     
                     Region region1 = new Region();
                    HBox.setHgrow(region1, Priority.ALWAYS);
                    root.getChildren().add(region1);
               
                   // evenement=sde.getNomUserById(de.getUtilisateur());
                    nomDestination=sd.GetNomDestinationsById(de.getDestination());
                      root.getChildren().add(new Label(nomDestination));
                     
                    Region region2 = new Region();
                    HBox.setHgrow(region2, Priority.ALWAYS);
                    root.getChildren().add(region2);
                    
                     root.getChildren().add(new Label(de.getLibelleEvenement()));
                     
                    Region region3 = new Region();
                    HBox.setHgrow(region3, Priority.ALWAYS);
                    root.getChildren().add(region3);
                      root.getChildren().add(new Label(de.getDate_debutEvent()));
                     
                    Region region4 = new Region();
                    HBox.setHgrow(region4, Priority.ALWAYS);
                    root.getChildren().add(region4);
                    
                    root.getChildren().add(new Label(de.getDate_finEvent()));
                     
                    Region region5 = new Region();
                    HBox.setHgrow(region5, Priority.ALWAYS);
                    root.getChildren().add(region5);
                    
                    
                    //nomSousCategorie=ssc.GetSousCategorieByIdDemandeEvenement(de.get)
setGraphic(root);
                 }
            
     }
        });
listView.getItems().addAll(sde.GetEvenementDisponible());
    }
    

    @FXML
    private void getListDemandReffuser(ActionEvent event) {
        listView.getItems().clear();
    listView.setCellFactory(param -> new ListCell<DemandeEvenement>(){
            
     protected void updateItem(DemandeEvenement de, boolean empty) {
                super.updateItem( de, empty);
                if (empty || de==null) {
                    setGraphic(null);
                    setText(null); 
                }else{
                     // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    // allow wrapping
                    setWrapText(true);
                    // HBox dispose ses enfants sur une seule ligne horizontale.
                    HBox root = new HBox(10);
                    root.setAlignment(Pos.CENTER);
                    root.setPadding(new Insets(10 ,10, 20, 0));
                            
                    root.getChildren().add(new Label(de.getStatut()));
                    
                    Region region = new Region();
                    HBox.setHgrow(region, Priority.ALWAYS);
                    root.getChildren().add(region);
                    
                    
                    root.getChildren().add(new Label(de.getDate_demande()));
                     
                     Region region1 = new Region();
                    HBox.setHgrow(region1, Priority.ALWAYS);
                    root.getChildren().add(region1);
               
                   // evenement=sde.getNomUserById(de.getUtilisateur());
                    nomDestination=sd.GetNomDestinationsById(de.getDestination());
                      root.getChildren().add(new Label(nomDestination));
                     
                    Region region2 = new Region();
                    HBox.setHgrow(region2, Priority.ALWAYS);
                    root.getChildren().add(region2);
                    
                     root.getChildren().add(new Label(de.getLibelleEvenement()));
                     
                    Region region3 = new Region();
                    HBox.setHgrow(region3, Priority.ALWAYS);
                    root.getChildren().add(region3);
                      root.getChildren().add(new Label(de.getDate_debutEvent()));
                     
                    Region region4 = new Region();
                    HBox.setHgrow(region4, Priority.ALWAYS);
                    root.getChildren().add(region4);
                    
                    root.getChildren().add(new Label(de.getDate_finEvent()));
                     
                    Region region5 = new Region();
                    HBox.setHgrow(region5, Priority.ALWAYS);
                    root.getChildren().add(region5);
                    
                    
                    //nomSousCategorie=ssc.GetSousCategorieByIdDemandeEvenement(de.get)
setGraphic(root);
                 }
            
     }
        });
listView.getItems().addAll(sde.GetDemandeEvenementRefuser());
    }
    
}
