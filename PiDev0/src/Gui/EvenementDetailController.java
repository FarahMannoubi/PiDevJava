/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.AddDemandeEvenementController;
import Interfaces.MyListener;
import Models.Avis;
import Models.CoutCategorie;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Services.ServiceCoutCategorie;
import Services.ServiceCoutEvenement;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class EvenementDetailController implements Initializable {

    @FXML
    private ImageView imageEvenement;
    
    @FXML
    private Label lbDateDebutEvenement;
    @FXML
    private Label lbNomDestination;
    @FXML
    private Label lbVille;
    @FXML
    private Label lbDateFinEvenement;
    @FXML
    private ListView<CoutEvenement> listBilles;
    @FXML
    private Label lbCategorie;
    @FXML
    private ListView<Avis> listAvis;
    @FXML
    private Button iconDestination;

    /**
     * Initializes the controller class.
     */
    DemandeEvenement de;
    private ServiceDestination sd=new ServiceDestination();
 private ServiceCoutCategorie scc=new ServiceCoutCategorie();
    private ServiceCoutEvenement sce=new ServiceCoutEvenement();
    private ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
    
        private  List<CoutCategorie>CoutCategories=new ArrayList<>();
         private   List<String>ListlibelleCoutCategories=new ArrayList<>();
    @FXML
    private Label lbEvent;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        // TODO
    }    
public void setChosenEvenement(DemandeEvenement evenement){
       this.de=evenement;
      String NomDestination= sd.GetNomDestinationsById(evenement.getDestination());
      
   lbNomDestination.setText(NomDestination);
  lbEvent.setText(evenement.getLibelleEvenement());
  lbDateDebutEvenement.setText(evenement.getDate_debutEvent());
  lbDateFinEvenement.setText(evenement.getDate_finEvent());
  //lbD
           FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/image/"+evenement.getImage());
       
             Image image= new Image(inputStream);
             
       imageEvenement.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        
CoutCategories=scc.ReadCoutCategories();
        for(CoutCategorie cc:CoutCategories){
            ListlibelleCoutCategories.add(cc.getLibelle());
        }
      //  listeLibelleCoutCategorie.setItems(FXCollections.observableArrayList( ListlibelleCoutCategories));
        // TODO
      
       
   
        listBilles.getItems().clear();
        listBilles.setCellFactory(param -> new ListCell<CoutEvenement>(){
            
            protected void updateItem(CoutEvenement ce, boolean empty) {
                super.updateItem( ce, empty);
                if (empty || ce==null) {
                    setGraphic(null);
                    setText(null); 
                }else{
                    CoutCategories=scc.GetLibelleCoutCategorieByIdCoutCategorie(ce.getCoutCtegorie()); 
                    System.out.println("CoutCategories "+CoutCategories);
                    for(CoutCategorie cc:CoutCategories){
                    // set the width's
                    setMinWidth(param.getWidth());
                    setMaxWidth(param.getWidth());
                    setPrefWidth(param.getWidth());
                    // allow wrapping
                    setWrapText(true);
                    // HBox dispose ses enfants sur une seule ligne horizontale.
                    
                    HBox root = new HBox(3);
                    root.setAlignment(Pos.CENTER);
                  root.setPadding(new Insets(10,10,20, 0));
                    
                        String libelleCoutCategorie=cc.getLibelle();
                        System.out.println("libelleCoutCategorie"+libelleCoutCategorie);
                         root.getChildren().add(new Label(libelleCoutCategorie));
                    
                   
                    

                       Region region = new Region();
                   HBox.setHgrow(region, Priority.ALWAYS);
                    root.getChildren().add(region);
                       String prixString=Float.toString((float) ce.getPrix()); 
                      root.getChildren().add(new Label(prixString));
                                         
                      
                     Region region1 = new Region();
                   HBox.setHgrow(region1, Priority.ALWAYS);
                    root.getChildren().add(region1);
                      // String prixString=Float.toString((float) ce.getPrix()); 
                   //   root.getChildren().add(new Button(prixString, this));
             
                    setGraphic(root);
                }
                 }
            
            }
        });
 listBilles.getItems().addAll(sce.GetIdsCoutEvenementByIdDemandeEvenement(evenement.getId()));
                    
    
}
    @FXML
    private void click(MouseEvent event) {
    }
    
}
