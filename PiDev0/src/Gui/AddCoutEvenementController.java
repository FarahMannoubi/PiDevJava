/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.CoutEvenementController;
import Models.CoutCategorie;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Services.ServiceCoutCategorie;
import Services.ServiceCoutEvenement;
import Services.ServiceDemandeEvenement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class AddCoutEvenementController implements Initializable {

    @FXML
    private JFXComboBox<String> listeLibelleCoutCategorie;
    @FXML
    private JFXTextField tfNbBillet;
    @FXML
    private JFXTextField tfPrix;
    @FXML
    private JFXButton bnAddCoutEvenemet;
    @FXML
    private VBox CoutEvenementLayout;
 // int idDemande=30;   
 //int id =41;
private DemandeEvenement demandeEvenement;
    /**
     * Initializes the controller class.
     */
    private ServiceCoutCategorie scc=new ServiceCoutCategorie();
    private ServiceCoutEvenement sce=new ServiceCoutEvenement();
    private ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
     private  List<CoutCategorie>CoutCategories=new ArrayList<>();
       private   List<String>ListlibelleCoutCategories=new ArrayList<>();
       List <CoutEvenement> coutEvenement=new ArrayList<>();
       private CoutEvenement ce=new CoutEvenement();
       private DemandeEvenement de;
    @FXML
    private ListView<CoutEvenement> listView;
    @FXML
    private AnchorPane root2;
       
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        int id=demandeEvenement.getId();
  //      System.out.println("iddddd"+id);
        CoutCategories=scc.ReadCoutCategories();
        for(CoutCategorie cc:CoutCategories){
            ListlibelleCoutCategories.add(cc.getLibelle());
        }
        listeLibelleCoutCategorie.setItems(FXCollections.observableArrayList( ListlibelleCoutCategories));
       
        //System.out.println("de  "+de.getId());        
// TODO
        //Afficher();
    
    
    
    
    }   
   public void Afficher(){
        listView.getItems().clear();
        listView.setCellFactory(param -> new ListCell<CoutEvenement>(){
            
            protected void updateItem(CoutEvenement ce, boolean empty) {
                super.updateItem( ce, empty);
                if (empty || ce==null) {
                    setGraphic(null);
                    setText(null); 
                }else{
                    CoutCategories=scc.GetLibelleCoutCategorieByIdCoutCategorie(ce.getCoutCtegorie()); 
                   
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
                      String ndDilletsString=Integer.toString( ce.getNbBillet());
                      root.getChildren().add(new Label(ndDilletsString));
                                         
                      Region region1 = new Region();
                   HBox.setHgrow(region1, Priority.ALWAYS);
                    root.getChildren().add(region1);
                        String prixString=Float.toString((float) ce.getPrix()); 
                      root.getChildren().add(new Label(prixString));
                    
             
                    setGraphic(root);
                }
                 }
            
            }
        });
 listView.getItems().addAll(sce.GetIdsCoutEvenementByIdDemandeEvenement(de.getId()));
                    
   }

    @FXML
    private void addCoutEvenemet(ActionEvent event) {
      
          int idCoutCategorie=scc.GetIdByLibelleCoutCategorie(listeLibelleCoutCategorie.getValue());
        
        ce.setCoutCtegorie(idCoutCategorie);
    
       ce.setDemendeEvenement(de.getId());
    
        ce.setNbBillet(Integer.parseInt(tfNbBillet.getText()));
        ce.setPrix(Integer.parseInt(tfPrix.getText()));
           
               
         sce.addCoutEvenement(ce);
         getListCoutEvenementById(idCoutCategorie);
         Afficher();
                 
  
        
    }
    public void getListCoutEvenementById(int id){
        coutEvenement.clear();
      coutEvenement=sce.GetIdsCoutEvenementByIdDemandeEvenement(id);
 
        
    }
    
    
    
    public void AjouterCoutEvenement(DemandeEvenement de ){
        
        this.de=de;
         
     //id =de.getId();  
      
   
        
    }

    public void setDemandeEvenement(DemandeEvenement demandeEvenement) {
        this.demandeEvenement = demandeEvenement;
    }
    
    
    
}
