/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Interfaces.MyListener;
import Interfaces.MyListenerCoutEvenement;
import Models.CoutCategorie;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Services.ServiceCoutCategorie;
import Services.ServiceCoutEvenement;
import Services.ServiceDemandeEvenement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class ListeEvenementCilentController implements Initializable {

    private Label lblisteEvenement;
    @FXML
    private Label lbDateFinEvenement;
    @FXML
    private Label lbseparationDate;
    @FXML
    private Label lbDateDebutEvenement;
    @FXML
    private Label lbSeparationDateHeure;
    @FXML
    private Label lbHeureDebutEvenement;
    @FXML
    private Label lbSeparationHeure;
    @FXML
    private Label lbPrix;
    @FXML
    private ComboBox<String> lbLibelleCoutEvenement;
    @FXML
    private Button btnReservation;
    @FXML
    private VBox choisirEvenement;
    @FXML
    private ImageView ImageEvenement;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label lbLibelleEvenementchosen;
       @FXML
    private Label lbHeureFinEvenement;

    /**
     * Initializes the controller class.
     */
private List<DemandeEvenement> evenement=new ArrayList<>();
 private  List<CoutCategorie>libelleCoutCategorieOne=new ArrayList<>();
 private   List<String>libelleCoutCategories=new ArrayList<>();
 private  List<String> libelleCoutCategoriesByEvent=new ArrayList<>();
ServiceDemandeEvenement de =new ServiceDemandeEvenement();
ServiceCoutEvenement sce=new ServiceCoutEvenement();
ServiceCoutCategorie scc=new ServiceCoutCategorie();
 private MyListener myListener ; 
 private MyListenerCoutEvenement myListenerCoutEvenement ; 
 private Image image;
 private CoutEvenement ce;
 
 
 public List<String> addItem(CoutEvenement ce) {
    
    
        System.out.println("id cout "+ce.getCoutCtegorie());
       System.out.println("libelle1"+scc.GetLibelleCoutCategorieByIdCoutCategorie(ce.getCoutCtegorie()));
       
       libelleCoutCategorieOne=scc.GetLibelleCoutCategorieByIdCoutCategorie(ce.getCoutCtegorie());
  for(CoutCategorie cc:libelleCoutCategorieOne){
      libelleCoutCategories.add(cc.getLibelle());
  }    

       
       return libelleCoutCategories;
        
 }
 

 private void setChosenEvenement(DemandeEvenement evenement) {
     libelleCoutCategoriesByEvent.clear();
  System.out.println(evenement.getLibelleEvenement());
  List<CoutEvenement> coutEvenements=sce.GetIdsCoutEvenementByIdDemandeEvenement(evenement.getId());
  System.out.println("listeCoutEvenementById"+coutEvenements);
  
  for(CoutEvenement ce:coutEvenements){
  System.out.println("Listes id cout evenement byId demande evenement"+coutEvenements);
        lbLibelleEvenementchosen.setText(evenement.getLibelleEvenement());
        lbDateFinEvenement.setText(evenement.getDate_finEvent());
        lbDateDebutEvenement.setText(evenement.getDate_debutEvent());
        lbHeureDebutEvenement.setText(evenement.getHeure_debutEvent());
        lbHeureFinEvenement.setText(evenement.getHeure_finEvent());
        
        libelleCoutCategoriesByEvent=addItem(ce);
        lbLibelleCoutEvenement.setItems(FXCollections.observableArrayList(libelleCoutCategoriesByEvent));
      
       this.ce=ce;
      
      myListenerCoutEvenement=new MyListenerCoutEvenement() {
      @Override
      public void onClickListenerGetPrixByCoutEvenement(CoutEvenement ce) {
            String  libelleCoutEvenement=lbLibelleCoutEvenement.getValue();
             System.out.println("libelleCoutEvenement  "+libelleCoutEvenement);
           int id=scc.GetIdByLibelleCoutCategorie(libelleCoutEvenement);
           System.out.println("iddddddd"+  id);
          double prix= sce.GetPrixCoutEvenementById(id);
          String prixString=Float.toString((float) prix);
         
        lbPrix.setText(prixString);
     }
 };
       FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/image/"+evenement.getImage());
       
             Image image= new Image(inputStream);
             
        ImageEvenement.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  System.out.println("libelle"+addItem(ce));
        }  
        
        // lbLibelleCoutEvenement.setItems(list);
     // lbLibelleCoutEvenement.setItems((ObservableList<CoutEvenement>) coutEvenemets);

       // image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
      //  fruitImg.setImage(image);
      //  chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
      //          "    -fx-background-radius: 30;");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      List<DemandeEvenement> evenements=de.GetEvenementDisponible();
         if (evenements.size() > 0) {
            setChosenEvenement(evenements.get(0));
          myListener = new MyListener() {
                @Override
                public void onClickListener(DemandeEvenement evenement) {
                    setChosenEvenement(evenement);
                }

             
            };
        }
         int column=0;
        int row=1;
         try {
        for(int i=0;i<evenements.size();i++){
          
            FXMLLoader fxmlLoader = new FXMLLoader();
        
             fxmlLoader.setLocation(getClass().getResource("/Gui/Evenement.fxml"));
     
              AnchorPane anchorPane = fxmlLoader.load();
         
                EvenementController evenementController=fxmlLoader.getController();
                  System.out.println("testtt"+evenements.get(i));
                evenementController.setData(evenements.get(i),myListener);
                
                if(column==3){
                    column=0;
                    row++;
                }
                
                
               grid.add(anchorPane,column++, row);
               //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
               GridPane.setMargin(anchorPane, new Insets(10));
          }
          
          } 
        catch (IOException ex) {
            ex.printStackTrace();
              //Logger.getLogger(ListeEvenementCilentController.class.getName()).log(Level.SEVERE, null, ex);
          } 
        
      
    }  
    

    @FXML
    private void libelleCoutEvenement(MouseEvent event) {
        
       myListenerCoutEvenement.onClickListenerGetPrixByCoutEvenement(ce);
        
        
        
    }
    
  
        
        
    }
    

