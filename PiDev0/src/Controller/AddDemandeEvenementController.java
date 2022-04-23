/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.CoutCategorie;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Models.Destination;
import Services.ServiceCoutCategorie;
import Services.ServiceCoutEvenement;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class AddDemandeEvenementController implements Initializable {

    @FXML
    private JFXTimePicker HeureDebut;
    @FXML
    private JFXDatePicker dateDebutEvenement;
    @FXML
    private JFXDatePicker dateDemande;
    @FXML
    private JFXTimePicker HeureFin;
    @FXML
    private JFXComboBox<String> listeDestination;
    @FXML
    private JFXTextField tfDecriptionDemande;
    @FXML
    private JFXDatePicker dateFinEvenement;
    @FXML
    private JFXTextField tfLibelleEvenemet;
    @FXML
    private JFXTextField tfDiscriptionEvenement;
    @FXML
    private JFXTextField tfCapacite;
    @FXML
    private Label lbUtilisateur;
     @FXML
    private ImageView imageVue;

    /**
     * Initializes the controller class.
     */
    ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
    ServiceDestination sd=new ServiceDestination();
    ServiceCoutCategorie scc=new ServiceCoutCategorie();
    ServiceCoutEvenement sce=new ServiceCoutEvenement ();
     List<Destination> destinations = new ArrayList();
       List<String>ListlibelleDestinations=new ArrayList<>();
        List<CoutCategorie>CoutCategories=new ArrayList<>();
         List<String>ListlibelleCoutCategories=new ArrayList<>();
     private String path;
  private String nameImage;
    @FXML
    private AnchorPane scroll;
   
    @FXML
    private JFXTextField tfPrix;
    @FXML
    private JFXComboBox<String> listeLibelleCoutCategorie;
    @FXML
    private JFXTextField tfNbBillet;
    @FXML
    private JFXButton bnAddCoutEvenemet;
    @FXML
    private VBox CoutEvenementLayout;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        destinations=sd.ReadDestinations();
        for(Destination de:destinations){
            ListlibelleDestinations.add(de.getNom());
            
        }
        listeDestination.setItems(FXCollections.observableArrayList( ListlibelleDestinations));
       
        CoutCategories=scc.ReadCoutCategories();
        for(CoutCategorie cc:CoutCategories){
            ListlibelleCoutCategories.add(cc.getLibelle());
        }
        listeLibelleCoutCategorie.setItems(FXCollections.observableArrayList( ListlibelleCoutCategories));
    }   
    
    
    
    public boolean ControleDescriptionDemande()
    {
        String str =tfDecriptionDemande.getText().toLowerCase();
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
      
    }
    
    
    public boolean ControleLibelleEvenement()
    {
        String str =tfLibelleEvenemet.getText().toLowerCase();
		char[] charArray = str.toCharArray();
                
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (!((ch >= 'a' && ch <= 'z') || (String.valueOf(ch)).equals(" "))) {
				return false;
			}
		}
		return true;
      
    }
    
    
    
   public boolean ControleCapacite() {
       if (tfCapacite.getText().matches("[0-9]{4}")) {
			return true;
		}
		return false;
	}
    
    
    @FXML
    private void AjouterDemandeEvenement(ActionEvent event) throws IOException {
        if(tfDecriptionDemande.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(" Description Demande Evenement Field empty");
        alert.showAndWait();}
        else if(ControleDescriptionDemande()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Description Demande Evenement is not valid");
        alert.showAndWait();  
            
        }
        else if (tfCapacite.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Capacite Field empty");
        alert.showAndWait();}
        else if(ControleCapacite()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Capacite is not valid");
        alert.showAndWait();     
        }
        else if (tfLibelleEvenemet.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Libelle Evenement Field empty");
        alert.showAndWait();}
        else if(ControleLibelleEvenement()==false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Libelle Evenement is not valid");
        alert.showAndWait();     
        }
        
        DemandeEvenement de=new DemandeEvenement();
         
        
        LocalDate mydateDebutEvenement=dateDebutEvenement.getValue();
        LocalDate mydateFinEvenement=dateFinEvenement.getValue();
        LocalDate mydateDemande=dateDemande.getValue();
       
        de.setDate_demande(mydateDemande.toString());
        de.setDate_debutEvent(mydateDebutEvenement.toString());
        de.setDate_finEvent(mydateFinEvenement.toString());
       
        LocalTime myHeureDebut=HeureDebut.getValue();
        String myFormattedHeureDebut=myHeureDebut.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        de.setHeure_debutEvent(myFormattedHeureDebut);
        
        LocalTime myHeureFin=HeureFin.getValue();
        String myFormattedHeureFin=myHeureFin.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        de.setHeure_finEvent(myFormattedHeureFin);
       
        de.setLibelleEvenement(tfLibelleEvenemet.getText());
        de.setDescription_event(tfDiscriptionEvenement.getText());
        int id=sd.GetIdDestinationsByNom(listeDestination.getValue());
       
        de.setUtilisateur(2);
        de.setDescription_demande(tfDecriptionDemande.getText());
        de.setCapacite(Integer.parseInt(tfCapacite.getText()));
        de.setDestination(id);
        
        
        
        
        System.out.println("ok");
        
        
         RandomString name=new RandomString();
            
       
         nameImage = RandomString.getAlphaNumericString(20)+".png";
        de.setImage(nameImage);
        Image img3= imageVue.getImage();
   File file = new File("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/image/"+nameImage);
  
  try {
      ImageIO.write(SwingFXUtils.fromFXImage(img3,
              null), "png", file);
    } catch (IOException e) {
     e.printStackTrace();
    }
  
         ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
        sde.addDemandeEvenement(de);
      DemandeEvenement de1=new DemandeEvenement();
      de1.setDestination(id);
      de1.setUtilisateur(2);
      de1.setDate_demande(mydateDemande.toString());
      de1.setStatut("en attente");
      de1.setDescription_demande(tfDecriptionDemande.getText());
      de1.setHeure_debutEvent(myFormattedHeureDebut);
      de1.setCapacite(Integer.parseInt(tfCapacite.getText()));
      de1.setLibelleEvenement(tfLibelleEvenemet.getText());
      de1.setDate_finEvent(mydateFinEvenement.toString());
      de1.setHeure_finEvent(myFormattedHeureFin);
      de1.setDescription_event(tfDecriptionDemande.getText());
      String libelle=tfLibelleEvenemet.getText();
     addcoutEvenemet(libelle);
    // listeLibelleCoutCategorie.setItems(FXCollections.observableArrayList(ListlibelleCoutCategories));
   
      
      
      
    }
    public CoutEvenement addcoutEvenemet(String de){
        CoutEvenement ce=new CoutEvenement();
       // System.out.println("jsndckjsd"+sde.idDemandeEvenementByLibelleDemandeEvenement(de).getId()); 
      
        CoutCategories=scc.GetLibelleCoutCategorie();
        for(CoutCategorie cc:CoutCategories){
            ListlibelleCoutCategories.add(cc.getLibelle());
            int idDemandeEvenemet=sde.idDemandeEvenementByLibelleDemandeEvenement(de).getId();
            int idCoutCategorie=scc.GetIdByLibelleCoutCategorie(listeLibelleCoutCategorie.getValue());
          
          ce.setCoutCtegorie(idCoutCategorie);
          ce.setDemendeEvenement(idDemandeEvenemet);
          ce.setNbBillet(Integer.parseInt(tfNbBillet.getText()));
          ce.setPrix(Integer.parseInt(tfPrix.getText()));
          List<CoutEvenement> coutEvenements= sce.GetIdsCoutEvenementByIdDemandeEvenement(idDemandeEvenemet);
                for(int i=0;i<coutEvenements.size();i++){
          
            FXMLLoader fxmlLoader = new FXMLLoader();
        
             fxmlLoader.setLocation(getClass().getResource("/Gui/CoutEvenement.fxml"));
     
             try {
                 HBox hBox=fxmlLoader.load();
                 CoutEvenementController coutEvenementController=fxmlLoader.getController();
                  coutEvenementController.setData(coutEvenements.get(i));
           
             
              CoutEvenementLayout.getChildren().add(hBox);
             
             } catch (IOException ex) {
                  ex.printStackTrace();
             }
    } 
         // ce.setDemendeEvenement(sde.idDemandeEvenementByLibelleDemandeEvenement(de));
        }
 return ce;

    }

   @FXML
    private void addImage(MouseEvent event) {
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Image Files","*.png","*.jpg"));
        File f=fc.showOpenDialog(null);
        if(f !=null){
             path=f.getAbsolutePath();
        //pImagePath.setText(f.getAbsolutePath());
      Image image = new Image(f.toURI().toString(),imageVue.getFitWidth(),imageVue.getFitHeight(),true,true);
            System.out.println("img5555555555555555555555555555555555555555"+path);
        imageVue.setImage(image);
    }
    
    
    
   }

    @FXML
    private void addCoutEvenemet(ActionEvent event) {
        
         String libelle=tfLibelleEvenemet.getText();
          CoutEvenement ce=new CoutEvenement();
       // System.out.println("jsndckjsd"+sde.idDemandeEvenementByLibelleDemandeEvenement(de).getId()); 
      
        CoutCategories=scc.GetLibelleCoutCategorie();
        for(CoutCategorie cc:CoutCategories){
            ListlibelleCoutCategories.add(cc.getLibelle());
            int idDemandeEvenemet=sde.idDemandeEvenementByLibelleDemandeEvenement(libelle).getId();
            int idCoutCategorie=scc.GetIdByLibelleCoutCategorie(listeLibelleCoutCategorie.getValue());
          
          ce.setCoutCtegorie(idCoutCategorie);
          ce.setDemendeEvenement(idDemandeEvenemet);
          ce.setNbBillet(Integer.parseInt(tfNbBillet.getText()));
          ce.setPrix(Integer.parseInt(tfPrix.getText()));
          sce.addCoutEvenement(ce);
        
    }
    
    
 
   
   
    
}

    
}