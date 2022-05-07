/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceDestination;
import Models.Destination;
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
public class ServiceDestination implements IServiceDestination{
    
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();
    
    ServiceDelegation del=new ServiceDelegation();
    ServiceSousCategorie  souscateg=new ServiceSousCategorie();


    // Create
    @Override
    public void CreateDestination(Destination des) {
        if((del.FindSousDelegationByID(des.getDelegtion())!=null )&& (souscateg.FindSousCategorieByID(des.getSouscategorie())!=null))
        {
        try {
            String req = "INSERT INTO `Destination` (`souscategorie_id`, `delegation_id`, `description`, `image`, `adresse`, `num_tel`, `email`, `nom`)"+
            " VALUES ('"+des.getSouscategorie()+"', '"+des.getDelegtion()+"', '"+des.getDescription()+"', '"+des.getImage()+"', '"+des.getAdresse()+"', '"+des.getNum_tel()+"', '"+des.getEmail()+"', '"+des.getNom()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Destination ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        }
        else
        {System.out.println("Delegation ou sous categorie inexistantes");}
    }

    @Override
    public List<Destination> ReadDestinations() {
          ArrayList<Destination> destinations = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM destination ORDER BY `nom` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   destinations.add(new Destination(rs.getInt(1), rs.getString("nom"), rs.getString("description"), rs.getString("image"), rs.getString("adresse"),rs.getInt("num_tel"),rs.getString("email"),rs.getInt("souscategorie_id"),rs.getInt("delegation_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return destinations;   
    }
 
    public List<String> GetNomDestinations() {
          ArrayList<String> destinations = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT `nom` FROM destination ORDER BY `nom` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   destinations.add(rs.getString("nom"));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return destinations;    }
    
    
     public int GetIdDestinationsByNom(String nom) {
          
           int id=2;
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT `id` FROM `destination` WHERE `destination`.`nom`='"+nom+"'";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   id=rs.getInt("id");
                   System.out.println(rs.getInt("id"));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return id;    }
     
     public int GetIdGouvernoratByIdDestination(int id) {
          
           //int id=2;
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT `delegation_id` FROM `destination` WHERE `destination`.`id`="+id;
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   id=rs.getInt("delegation_id");
                //   System.out.println(rs.getInt("gouvernorat_id"+gouvernorat_id));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return id;    }

     public String GetNomDestinationsById(int id) {
          
           String nom="";
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT `nom` FROM `destination` WHERE `destination`.`id`="+id;
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   nom=rs.getString("nom");
                 
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return nom;    }
    
    
    
    @Override
    public void UpdateDestination(Destination des) {
         if(del.FindSousDelegationByID(des.getDelegtion())!=null && souscateg.FindSousCategorieByID(des.getSouscategorie())!=null)
        {
    try {
           
                   String  req="UPDATE destination SET `souscategorie_id`='"+des.getSouscategorie()+"',`delegation_id`='"+des.getDelegtion()+"',`description`='"+des.getDescription()+"',"
                           + "`image`='"+des.getImage()+"',`adresse`='"+des.getAdresse()+"',`num_tel`='"+des.getNum_tel()+"',`email`='"+des.getEmail()+"',`nom`='"+des.getNom()+"' WHERE `id`="+des.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Destination Modifiée avec succes.\n");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }   
     }
        else
        {System.out.println("Delegation ou sous categorie inexistantes");}
    }

    @Override
    public void DeleteDestination(int id) {
       try {
          String query ="DELETE FROM destination WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Destination supprimée avec success\n");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }

    @Override
    public Destination FindDestinationByID(int id) {
        Destination des= null;
       
        try {
            String req = "SELECT * FROM destination WHERE id="+id;
            PreparedStatement pst = cnx.prepareStatement(req);
           
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
               des= new Destination(rs.getInt(1), rs.getString("nom"), rs.getString("description"), rs.getString("image"), rs.getString("adresse"),rs.getInt("num_tel"),rs.getString("email"),rs.getInt("souscategorie_id"),rs.getInt("delegation_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return des;      }

    @Override
    public List<Destination> FindDestinationByName(String nom) {
         ArrayList<Destination> destinations = new ArrayList();
          try {
             String req = "SELECT * FROM destination WHERE nom=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1,nom);
            ResultSet rs=pst.executeQuery();
              while (rs.next()) {  
                   destinations.add(new Destination(rs.getInt(1), rs.getString("nom"), rs.getString("description"), rs.getString("image"), rs.getString("adresse"),rs.getInt("num_tel"),rs.getString("email"),rs.getInt("souscategorie_id"),rs.getInt("delegation_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return destinations;}

    @Override
    public List<Destination> FindDestinationSousCategories(int id) {
        ArrayList<Destination> destinations = new ArrayList();
          try {
             String req = "SELECT * FROM destination d ,sous_categorie sc WHERE d.souscategorie_id=sc.id and sc.id="+id;
            PreparedStatement pst = cnx.prepareStatement(req);
           
            ResultSet rs=pst.executeQuery();
              while (rs.next()) {  
                   destinations.add(new Destination(rs.getInt(1), rs.getString("nom"), rs.getString("description"), rs.getString("image"), rs.getString("adresse"),rs.getInt("num_tel"),rs.getString("email"),rs.getInt("souscategorie_id"),rs.getInt("delegation_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return destinations;    }

    @Override
    public List<Destination> FindDestinationDelegations(int id) {
ArrayList<Destination> destinations = new ArrayList();
          try {
             String req = "SELECT * FROM destination d ,delegation del WHERE d.delegation_id=del.id and del.id="+id;
            PreparedStatement pst = cnx.prepareStatement(req);
           
            ResultSet rs=pst.executeQuery();
              while (rs.next()) {  
                   destinations.add(new Destination(rs.getInt(1), rs.getString("nom"), rs.getString("description"), rs.getString("image"), rs.getString("adresse"),rs.getInt("num_tel"),rs.getString("email"),rs.getInt("souscategorie_id"),rs.getInt("delegation_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return destinations;      }
    
    
}
