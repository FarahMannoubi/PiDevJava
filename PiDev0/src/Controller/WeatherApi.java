/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Date;


/**
 *
 * @author manou
 */
public class WeatherApi  {
    
    String city,degree_fld,feraniet_fld;
      public void call_me(String city,String date) throws Exception {
            String url = "http://api.weatherapi.com/v1/current.json?key=dfdf748b93e54bac8f3131335223004&q="+city+"&dt="+date;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response);
            //Read JSON response and print
            JSONObject myResponse = new JSONObject(response.toString());
            //System.out.println("result after Reading JSON Response");
           System.out.println( myResponse);
           JSONObject rest = new JSONObject(myResponse.getJSONObject("current").toString());

            degree_fld=(rest.get("temp_c").toString());
           feraniet_fld=(rest.get("temp_f").toString());
           System.out.println(degree_fld);
           /*System.out.println(rest.get("temp_f"+feraniet_fld));
            System.out.println("countryName- "+myResponse.getString("countryName"));
            System.out.println("regionName- "+myResponse.getString("regionName"));
            System.out.println("cityName- "+myResponse.getString("cityName"));
            System.out.println("zipCode- "+myResponse.getString("zipCode"));
            System.out.println("latitude- "+myResponse.getString("latitude"));
            System.out.println("longitude- "+myResponse.getString("longitude"));
*/

        }

















}
