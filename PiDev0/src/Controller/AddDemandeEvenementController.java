/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Gui.AddCoutEvenementController;
import Gui.HomeController;
import Models.CoutCategorie;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Models.Destination;
import Services.ServiceCoutCategorie;
import Services.ServiceCoutEvenement;
import Services.ServiceDelegation;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONObject;

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
       private Parent fxml;
        private AnchorPane root;
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
   LocalDateTime now = LocalDateTime.now();  
 
    ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
    ServiceDestination sd=new ServiceDestination();
  ServiceDelegation sDel=new ServiceDelegation();
    ServiceCoutEvenement sce=new ServiceCoutEvenement ();
     List<Destination> destinations = new ArrayList();
       List<String>ListlibelleDestinations=new ArrayList<>();
      
      DemandeEvenement de;
         List<CoutEvenement>CoutEvenements=new ArrayList<>();
        
     private String path;
  private String nameImage;
  private int idDestination;
  
  
    @FXML
    private AnchorPane scroll;
    @FXML
    private Label lbDate;
    @FXML
    private ImageView imgVIcon;
    @FXML
    private Label lbMax;
    @FXML
    private Label lbMin;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  String dateDemande = (dtf.format(now));
      
        
           String ville="Nabeul";
        try {
            call_me(ville,dateDemande);
            // TODO
        } catch (Exception ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(dtf.format(now)); 
          
        destinations=sd.ReadDestinations();
        for(Destination de:destinations){
            ListlibelleDestinations.add(de.getNom());
            
        }
        listeDestination.setItems(FXCollections.observableArrayList( ListlibelleDestinations));
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
        
        
         
         LocalDate mydateDebutEvenement=dateDebutEvenement.getValue();
    
        LocalDate mydateFinEvenement=dateFinEvenement.getValue();

         String  date=mydateDebutEvenement.toString();
        
     String dateDemande = (dtf.format(now));
     de=new DemandeEvenement();
        de.setDate_demande(dateDemande);
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
        idDestination=sd.GetIdDestinationsByNom(listeDestination.getValue());
       
        de.setUtilisateur(2);
        de.setDescription_demande(tfDecriptionDemande.getText());
        de.setCapacite(Integer.parseInt(tfCapacite.getText()));
        de.setDestination(idDestination);
        
        
        
        
        System.out.println("ok");
        
        
         RandomString name=new RandomString();
            
       
         nameImage = RandomString.getAlphaNumericString(20)+".png";
        de.setImage(nameImage);
        Image img3= imageVue.getImage();
   File file = new File("C:/Users/dell/Desktop/PIDEV_CACT/PIDEV_CACT/public/upload/imageJava/"+nameImage);
  
  try {
      ImageIO.write(SwingFXUtils.fromFXImage(img3,
              null), "png", file);
    } catch (IOException e) {
     e.printStackTrace();
    }
  
         ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
        sde.addDemandeEvenement(de);
      DemandeEvenement de1=new DemandeEvenement();
      de1.setDestination(idDestination);
      de1.setUtilisateur(2);
      de1.setDate_demande(dateDemande);
      de1.setStatut("en attente");
      de1.setDescription_demande(tfDecriptionDemande.getText());
      de1.setHeure_debutEvent(myFormattedHeureDebut);
      de1.setCapacite(Integer.parseInt(tfCapacite.getText()));
      de1.setLibelleEvenement(tfLibelleEvenemet.getText());
      de1.setDate_finEvent(mydateFinEvenement.toString());
      de1.setHeure_finEvent(myFormattedHeureFin);
      de1.setDescription_event(tfDecriptionDemande.getText());
      String libelle=tfLibelleEvenemet.getText();
    // addcoutEvenemet(libelle);
    // listeLibelleCoutCategorie.setItems(FXCollections.observableArrayList(ListlibelleCoutCategories));
   
      
      
      
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


        
 public List<CoutEvenement> GetCoutEvenement(CoutEvenement ce){
     
     
       List<CoutEvenement> coutEvenements=new ArrayList<>();
     
     return coutEvenements;
 }

     
    

  



    @FXML
    private void DateCanged(ContextMenuEvent event) {
    }
        String ville,degree_fld,feraniet_fld,icon,maxtemp_c,mintemp_c;
     public void call_me(String ville,String date) throws Exception {
         
            String url = " https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"+ville+"/"+date+"?unitGroup=metric&key=QW6W3ATCWRWTST7S63F3GQ328";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            //System.out.println("\nSending 'GET' request to URL : " + url);
            //System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            System.out.println("1 "+response);
            //Read JSON response and print
            JSONObject myResponse = new JSONObject(response.toString());
            //System.out.println("result after Reading JSON Response");
           System.out.println("2  "+ myResponse);
           
          

JSONObject timelineResponse = new JSONObject(response.toString());
JSONArray values=timelineResponse.getJSONArray("days");
ZoneId zoneId=ZoneId.of(timelineResponse.getString("timezone"));
		
System.out.printf("Date\tMaxTemp\tMinTemp\tPrecip\tSource%n");
for (int i = 0; i < values.length(); i++) {
    JSONObject dayValue = values.getJSONObject(i);

    ZonedDateTime datetime=
        ZonedDateTime.ofInstant(Instant.ofEpochSecond(
            dayValue.getLong("datetimeEpoch")), zoneId);
            icon=dayValue.getString("icon"); 
    double maxtemp=dayValue.getDouble("tempmax");
    maxtemp_c=Float.toString((float)maxtemp);
    double mintemp=dayValue.getDouble("tempmin");
    mintemp_c=Float.toString((float)mintemp);
    double pop=dayValue.getDouble("precip");
    String source=dayValue.getString("source");
    date= datetime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%s%n",         
        datetime.format(DateTimeFormatter.ISO_LOCAL_DATE),
            maxtemp, mintemp, pop,source );
    System.out.println("icon "+icon);
}
lbDate.setText(date);
lbMax.setText(maxtemp_c);
lbMin.setText(mintemp_c);
  FileInputStream inputStream;
        try  {
            inputStream = new FileInputStream("C:/Users/dell/Desktop/PIDEV_CACT/PIDEV_CACT/public/upload/WeatherIcons/"+icon+".png");
       
             Image image= new Image(inputStream);
             
     imgVIcon.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
      }

    @FXML
    private void DateDebutChanged(ActionEvent event) throws Exception {
        idDestination=sd.GetIdDestinationsByNom(listeDestination.getValue());
     //   System.out.println("idDestination  "+idDestination);
      int idDel=  sd.GetIdGouvernoratByIdDestination(idDestination);
        
      //  System.out.println("sd.GetIdGouvernoratByIdDestination(idDestination);"+idDel);
      String nomDel=  sDel.getNomDelegationByID(idDel);
       // System.out.println("nomDel "+nomDel);
        //   System.out.println("Date : ");
                   
        // System.out.println(dtf.format(now));  
         
         LocalDate mydateDebutEvenement=dateDebutEvenement.getValue();
         String DateDeb=mydateDebutEvenement.toString();
       //  System.out.println("  DateDeb  "+DateDeb);
          String ville=nomDel;
         call_me(ville,DateDeb);
    }

    @FXML
    private void DateFinChanged(ActionEvent event) throws Exception {
        idDestination=sd.GetIdDestinationsByNom(listeDestination.getValue());
        //System.out.println("idDestination  "+idDestination);
      int idDel=  sd.GetIdGouvernoratByIdDestination(idDestination);
       // System.out.println("sd.GetIdGouvernoratByIdDestination(idDestination);"+idDel);
      String nomDel=  sDel.getNomDelegationByID(idDel);
      System.out.println("nomDel "+nomDel);
    //  System.out.println(dtf.format(now));  
         LocalDate mydateFinEvenement=dateFinEvenement.getValue();
         String DateDeb=mydateFinEvenement.toString();
    //     System.out.println("  DateDeb  "+DateDeb);
          String ville=nomDel;
         call_me(ville,DateDeb);
    }
    

    @FXML
    private void AddCoutEvenement(ActionEvent event) throws IOException {
         try {
            fxml=FXMLLoader.load(getClass().getResource("/gui/AddCoutEvenement.fxml"));
              scroll.getChildren().removeAll();
              scroll.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  FXMLLoader fxmlLoader = new FXMLLoader();
    // fxmlLoader.setLocation(getClass().getResource("/gui/AddCoutEvenement.fxml"));
    // Parent root = fxmlLoader.load();
                     // Stage stage;
                     // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                     // Scene scene=new Scene(root);
                    //  stage.setScene(scene);
                     // stage.show();
    AddCoutEvenementController addCoutEvenementController=new AddCoutEvenementController();
   String libelle=de.getLibelleEvenement();
         int idDemandeEvenemet=sde.idDemandeEvenementByLibelleDemandeEvenement(libelle).getId();
   de.setId(idDemandeEvenemet);
       addCoutEvenementController.AjouterCoutEvenement(de);
   
            }
    
    
    
   
    
}

    
