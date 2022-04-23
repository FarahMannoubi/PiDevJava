/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controller.AddDemandeEvenementController;
import Interfaces.IServiceDemandeEvenement;
import Models.DemandeEvenement;
import Utils.Connexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author Fatma
 */
public class ServiceDemandeEvenement implements IServiceDemandeEvenement{
 Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

public List<DemandeEvenement> GetDemandeEvenement(){
ArrayList<DemandeEvenement> demandeEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM `demande_evenement`";
            ResultSet rs = st.executeQuery(req);
            DemandeEvenement de=new DemandeEvenement();
            while (rs.next()) {                
     
               demandeEvenements.add(new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3),
 rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14)));
                
           
          
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return demandeEvenements ;
}




        
public List<DemandeEvenement> GetDemandeEvenementById(DemandeEvenement de){ 
 ArrayList<DemandeEvenement> demandeEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM `demande_evenement`WHERE `demande_evenement`.`id`='"+de.getId()+"'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     
             demandeEvenements.add(new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14)));
                  
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return demandeEvenements ;
}

public List<DemandeEvenement> GetDemandeEvenementByIdUtilisateur(DemandeEvenement de){ 
 ArrayList<DemandeEvenement> demandeEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM `demande_evenement`WHERE `demande_evenement`.`utilisateur_id`='"+de.getUtilisateur()+"'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     demandeEvenements.add(new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14)));
                   
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return demandeEvenements ;
}
@Override
public List<DemandeEvenement> GetEvenementDisponible(){ 
String statut="Accepter";
 ArrayList<DemandeEvenement> demandeEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM `demande_evenement"
 + "`WHERE `demande_evenement`.`statut`='"+statut+"'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     demandeEvenements.add(new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return demandeEvenements ;
}

public List<DemandeEvenement> GetDemandeEvenementByIdDestination(DemandeEvenement de){ 
 ArrayList<DemandeEvenement> demandeEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT `id`, `destination_id`, `utilisateur_id`, `date_demande`, "
                    + "`statut`, `description_demande`, `date_debut_event`, `date_fin_event`, `heure_debut_event`, `heure_fin_event`,"
                    + " `description_event`, `capacite`, `libelle_evenement`, `image` FROM `demande_evenement`"
                    + " WHERE `demande_evenement`.`destination_id`='"+de.getDestination()+"'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     demandeEvenements.add(new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14)));
                  
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return demandeEvenements ;
}
public DemandeEvenement idDemandeEvenementByObjetDemandeEvenement(DemandeEvenement de) {
    DemandeEvenement de1=new DemandeEvenement();
     try {
            Statement st = cnx.createStatement();
    String req="SELECT `id`, `destination_id`, `utilisateur_id`, `date_demande`, `statut`, `description_demande`, `date_debut_event`, `date_fin_event`,"
+"`heure_debut_event`, `heure_fin_event`, `description_event`, `capacite`, `libelle_evenement`, `image` FROM `demande_evenement` WHERE "
        +"`demande_evenement`.`destination_id`='"+de.getDestination()+"' and"
        + " `demande_evenement`.`utilisateur_id`='"+de.getUtilisateur()+"' and"
        + " `demande_evenement`.`date_demande`='"+de.getDate_demande()+"' and"
               +" `demande_evenement`.`statut`='"+de.getStatut()+"' and"
               + " `demande_evenement`.`description_demande`='"+de.getDescription_event()+"' and"
               + "`demande_evenement`.`date_debut_event`='"+de.getDate_debutEvent()+"' and"
            + " `demande_evenement`.`date_fin_event`='"+de.getDate_finEvent()+"' and"
               + " `demande_evenement`.`heure_debut_event`='"+de.getHeure_debutEvent()+"' and "
               + "`demande_evenement`.`heure_fin_event`='"+de.getHeure_finEvent()+"' and "
                     +"`demande_evenement`.`description_event`='"+de.getDescription_event()+"' and "
    + "`demande_evenement`.`capacite`='"+de.getCapacite()+"'and `demande_evenement`.`libelle_evenement`='"+de.getLibelleEvenement()+"' " ;
     ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {     
                
     de1=new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14));
                  
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
return de1;
    
}


public DemandeEvenement idDemandeEvenementByLibelleDemandeEvenement(String libelle) {
    DemandeEvenement de1=new DemandeEvenement();
         try {
            Statement st = cnx.createStatement();
    String req="SELECT `id`, `destination_id`, `utilisateur_id`, `date_demande`, `statut`, `description_demande`, `date_debut_event`, `date_fin_event`,"
+"`heure_debut_event`, `heure_fin_event`, `description_event`, `capacite`, `libelle_evenement`, `image` FROM `demande_evenement` WHERE "
     +" `demande_evenement`.`libelle_evenement`='"+libelle+"' " ;
     ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {     
                
     de1=new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14));
                  
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
return de1;
    
}





public List<DemandeEvenement> GetDemandeEvenementEnAttante(){
String statut="En attente";
 ArrayList<DemandeEvenement> demandeEvenements = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT `id`, `destination_id`, `utilisateur_id`, `date_demande`,"
 + " `statut`, `description_demande`, `date_debut_event`, `date_fin_event`, `heure_debut_event`, "
 + "`heure_fin_event`, `description_event`, `capacite`, `libelle_evenement`, `image` "
 + "FROM `demande_evenement"
 + "`WHERE `demande_evenement`.`statut`='"+statut+"'";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     
                demandeEvenements.add(new DemandeEvenement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getInt(12),rs.getString(13),rs.getString(14)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return demandeEvenements ;
}



public void addDemandeEvenement(DemandeEvenement de){
String statut="En attente";
  String req = "INSERT INTO `demande_evenement` (`id`, `destination_id`, `utilisateur_id`, `date_demande`, "
 + "`statut`, `description_demande`, `date_debut_event`, `date_fin_event`, `heure_debut_event`, `heure_fin_event`,"
 + " `description_event`, `capacite`, `libelle_evenement`, `image`)"
 + " VALUES (NULL, '"+de.getDestination()+"','"+de.getUtilisateur()+"','"+de.getDate_demande()+"', '"+statut+"','"+de.getDescription_demande()+"',"
 + " '"+de.getDate_debutEvent()+"','"+de.getDate_finEvent()+"', '"+de.getHeure_debutEvent()+"', '"+de.getHeure_finEvent()+"',"
 + " '"+de.getDescription_event()+"','"+de.getCapacite()+"','"+de.getLibelleEvenement()+"','"+de.getImage()+"' );";
       
  try {
Statement st = cnx.createStatement();
           
          st.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
          int id=de.getId();
            System.out.println("Demande Evenemet ajoutée avec succes."+id);
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
}



public void updateDemandeEvenement(DemandeEvenement de){


           String  req="UPDATE `demande_evenement` SET `destination_id` = '"+de.getDestination()+"', `utilisateur_id` = '"+de.getUtilisateur()+"',"
 + " `date_demande` = '"+de.getDate_demande()+"', `statut` = '"+de.getStatut()+"', `description_demande` = '"+de.getDescription_demande()+"',"
 + " `date_debut_event` = '"+de.getDate_debutEvent()+"', `date_fin_event` = '"+de.getDate_finEvent()+"', `heure_debut_event` = '"+de.getHeure_debutEvent()+"',"
 + " `heure_fin_event` ='"+de.getHeure_finEvent()+"', `description_event` = '"+de.getDescription_event()+"', `capacite` = '"+de.getCapacite()+"', `libelle_evenement` = '"+de.getLibelleEvenement()+"', "
 + "`image` = '"+de.getImage()+"' WHERE `demande_evenement`.`id` ='"+de.getId()+"';";
                  
           try {
             Statement st = cnx.createStatement();
         
                 
                  st.executeUpdate(req);
            System.out.println("Demande Evenemet modifier avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
}

public void updateDemandeEvenementToAccepter(DemandeEvenement de){
String statut="Accepter";

           String  req="UPDATE `demande_evenement` SET `destination_id` = '"+de.getDestination()+"', `utilisateur_id` = '"+de.getUtilisateur()+"',"
 + " `date_demande` = '"+de.getDate_demande()+"', `statut` = '"+statut+"', `description_demande` = '"+de.getDescription_demande()+"',"
 + " `date_debut_event` = '"+de.getDate_debutEvent()+"', `date_fin_event` = '"+de.getDate_finEvent()+"', `heure_debut_event` = '"+de.getHeure_debutEvent()+"',"
 + " `heure_fin_event` ='"+de.getHeure_finEvent()+"', `description_event` = '"+de.getDescription_event()+"', `capacite` = '"+de.getCapacite()+"', `libelle_evenement` = '"+de.getLibelleEvenement()+"', "
 + "`image` = '"+de.getImage()+"' WHERE `demande_evenement`.`id` ='"+de.getId()+"';";
                  
           try {
             Statement st = cnx.createStatement();
         
                 
                  st.executeUpdate(req);
            System.out.println("Demande Evenemet Accepter.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
}

public void updateDemandeEvenementToRefuser(DemandeEvenement de){
String statut="Refuser";

           String  req="UPDATE `demande_evenement` SET `destination_id` = '"+de.getDestination()+"', `utilisateur_id` = '"+de.getUtilisateur()+"',"
 + " `date_demande` = '"+de.getDate_demande()+"', `statut` = '"+statut+"', `description_demande` = '"+de.getDescription_demande()+"',"
 + " `date_debut_event` = '"+de.getDate_debutEvent()+"', `date_fin_event` = '"+de.getDate_finEvent()+"', `heure_debut_event` = '"+de.getHeure_debutEvent()+"',"
 + " `heure_fin_event` ='"+de.getHeure_finEvent()+"', `description_event` = '"+de.getDescription_event()+"', `capacite` = '"+de.getCapacite()+"', `libelle_evenement` = '"+de.getLibelleEvenement()+"', "
 + "`image` = '"+de.getImage()+"' WHERE `demande_evenement`.`id` ='"+de.getId()+"';";
                  
           try {
             Statement st = cnx.createStatement();
         
                 
                  st.executeUpdate(req);
            System.out.println("Demande Evenemet Refuser.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
}

public void deleteDemandeEvenement(int id){

      try {

          String req ="DELETE FROM `demande_evenement` WHERE `demande_evenement`.`id` ="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(req);
          System.out.println(" Demande Evenement bien supprimer");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}
   }

    
   




}
