/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.AddDemandeEvenementController;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.zoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * FXML Controller class
 *
 * @author manou
 */
public class WeatherApiController implements Initializable {

    @FXML
    private Label lbDate;
    @FXML
    private ImageView imgVIcon;
    @FXML
    private Label lbMax;
    @FXML
    private Label lbMin;

    /**
     * Initializes the controller class.
     */
  // Image image;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              String dateDemande = ("2022-05-01");
      
        
           String ville="Nabeul";
        try {
            call_me(ville,dateDemande);
            // TODO
        } catch (Exception ex) {
            Logger.getLogger(WeatherApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    String city,degree_fld,feraniet_fld,icon,maxtemp_c,mintemp_c;
    
   
    
    
      public void call_me(String city,String date) throws Exception {
         
            String url = " https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"+city+"/"+date+"?unitGroup=metric&key=QW6W3ATCWRWTST7S63F3GQ328";
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
            inputStream = new FileInputStream("C:/Users/manou/OneDrive/Desktop/PIDEV_CACT/public/upload/WeatherIcons/"+icon+".png");
       
             Image image= new Image(inputStream);
             
     imgVIcon.setImage(image);
        
    } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
      }
    
    
    
    
    
    
    
    
    
    
    /*
      public void call_me(String city,String date) throws Exception {
            String url = "http://api.weatherapi.com/v1/history.json?key=dfdf748b93e54bac8f3131335223004&q="+city+"&dt="+date;
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
           
          JSONObject rest = new JSONObject(myResponse.getJSONObject("location").toString());
System.out.println(rest);

JSONObject timelineResponse = new JSONObject(myResponse.getJSONObject("forecast").toString());
System.out.println("3  "+ timelineResponse);
JSONArray values=timelineResponse.getJSONArray("forecastday");
 System.out.println("list "+values);
 for (int i = 0; i < values.length(); i++) {
    JSONObject dayValue = values.getJSONObject(i);
     System.out.println(" dayValue "+ dayValue);
 }
// JSONArray values1=values.getJSONArray("date");

//JSONObject jsonRoot = new JSONObject(myResponse);
 //System.out.println("list "+jsonRoot);
 //List<String> list = new ArrayList<String>();   
 // JSONArray jsonList = jsonRoot.getJSONArray("forecastday");
 // for (int i = 0; i < jsonList.length(); i++) {
 //         list.add(jsonList.getString(i));
 //  }
  //        System.out.println("list "+list);
 //for (JSONObject s : rest1){
     
 //}

//JSONObject rest2 = new JSONObject(myResponse.getJSONObject("forecastday").toString());
 //System.out.println("4  "+rest2);
           // degree_fld=(rest2.get("forecastday").toString());
           //feraniet_fld=(rest.get("temp_f").toString());
       //    icon=(rest1.get("icon").toString());
        //  maxtemp_c=(rest.get("maxtemp_c").toString());
         // mintemp_c=(rest.get("mintemp_c").toString());
       //    System.out.println(degree_fld);
        
           

          
         //  URL url1 = new URL("http:"+icon);

              BufferedImage image = null; 
    //  image = ImageIO.read(url1);
    //   Image image1 = SwingFXUtils.toFXImage(image, null);
     //     System.out.println(image);
         

             
    //    imgVIcon.setImage(image1);
        //lbMax.setText(maxtemp_c);
        //lbMin.setText(mintemp_c);
        
  //  } 
        //catch (FileNotFoundException ex) {
        //    Logger.getLogger(AddDemandeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
       // }
           /*System.out.println(rest.get("temp_f"+feraniet_fld));
            System.out.println("countryName- "+myResponse.getString("countryName"));
            System.out.println("regionName- "+myResponse.getString("regionName"));
            System.out.println("cityName- "+myResponse.getString("cityName"));
            System.out.println("zipCode- "+myResponse.getString("zipCode"));
            System.out.println("latitude- "+myResponse.getString("latitude"));
            System.out.println("longitude- "+myResponse.getString("longitude"));
    }
*/

    
      }
    

      
