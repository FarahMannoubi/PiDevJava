/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceCoutEvenement;
import Models.CoutEvenement;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fatma
 */
public class ServiceCoutEvenement implements IServiceCoutEvenement{
 Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

public List<CoutEvenement> GetCoutEvenement(){
ArrayList<CoutEvenement> coutEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM `cout_evenement`";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     
                coutEvenements.add(new CoutEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return coutEvenements ;
}
    public List<CoutEvenement> GetIdsCoutEvenementByIdDemandeEvenement(int id){
ArrayList<CoutEvenement> idcoutEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
     String req = "SELECT * FROM `cout_evenement` WHERE `cout_evenement`.`demande_event_id`='"+id+"'; ";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     
                idcoutEvenements.add(new CoutEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return idcoutEvenements ;
}

 public List GetIdCoutCategorieByIdCoutEvenement(int id) {
    ArrayList<Integer> coutCategories = new ArrayList();
       
      try {
           String req = "SELECT `coutcategorie_id` FROM cout_evenement WHERE demande_event_id="+id+"";
           PreparedStatement pst = cnx.prepareStatement(req);
   
          ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
             coutCategories.add(Res.getInt("coutcategorie_id")); 
           }
     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
       }
        return coutCategories;
    }
 public double GetPrixCoutEvenementById(int id){
    double prix=0.0;
     try {
          
           String req = "SELECT `prix` FROM cout_evenement WHERE id="+id+"";
           PreparedStatement pst = cnx.prepareStatement(req);
   
          ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
           prix=(Res.getDouble("prix")); 
           }
     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
       }
        return prix;
 }
  
public void addCoutEvenement(CoutEvenement ce){
String req = "INSERT INTO `cout_evenement` (`coutcategorie_id`, `demande_event_id`, `nb_billet`, `prix`) VALUES ('"+ce.getCoutCtegorie()+"', '"+ce.getDemendeEvenement()+"','"+ce.getNbBillet()+"','"+ce.getPrix()+"' );";

  try {
Statement st = cnx.createStatement();
           
            st.executeUpdate(req);
            System.out.println("Cout Evenemet ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
}
public void updateCoutEvenement(CoutEvenement ce){
String req="UPDATE `cout_evenement` SET `coutcategorie_id` = '"+ce.getCoutCtegorie()+"', `demande_event_id` = '"+ce.getDemendeEvenement()+"', `nb_billet` ='"+ce.getNbBillet()+"', `prix` = '"+ce.getPrix()+"' WHERE `cout_evenement`.`id` = '"+ce.getId()+"'; ";
try {
             Statement st = cnx.createStatement();
         
                 
                  st.executeUpdate(req);
            System.out.println("Cout Evenemet modifier avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
//
}
public void deleteCoutEvenement(int id){

try {

          String req ="DELETE FROM `cout_evenement` WHERE `cout_evenement`.`id` ="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(req);
          System.out.println(" cout Evenement bien supprimer");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}



}
}
