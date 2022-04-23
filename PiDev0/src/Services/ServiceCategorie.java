/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceCategorie;
import Models.Categorie;
import Models.SousCategorie;
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
public class ServiceCategorie implements IServiceCategorie{
    
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

    // Create
    @Override
    public void CreateCategorie(Categorie c) {
        
     
        try {
            String req = "INSERT INTO `categorie` ( `libelle`, `description`) VALUES ('"+c.getLibelle()+"', '"+c.getDescription()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Catégorie ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
    
    //Read
    @Override
    public List<Categorie> ReadCategories() {
         ArrayList<Categorie> categories = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM categorie ORDER BY `libelle` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   categories.add(new Categorie(rs.getInt(1), rs.getString("libelle"), rs.getString("description")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return categories;
    }
    
        @Override
    public void UpdateCategorie(Categorie C) {
        
       try {
           
                   String  req="UPDATE Categorie SET libelle='"+C.getLibelle()+"',description ='"+C.getDescription()+"' WHERE `id`="+C.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Catégorie Modifié avec succes.\n");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
    
    //Delete
    
    @Override
    public void DeleteCategorie(int id) {
try {
          String query ="DELETE FROM categorie WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Categorie supprimée avec success\n");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }

    @Override
    public Categorie FindCategorieByID(int id) {
      Categorie cat= null;
       
        try {
            String req = "SELECT * FROM categorie WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
               cat= new Categorie(Res.getInt(1), Res.getString("libelle"), Res.getString("description"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cat;
 }

    @Override
    public List<SousCategorie> listSousCategoriesByCategorie(int id) {
       ArrayList<SousCategorie> souscategories = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM sous_categorie sc ,categorie c where sc.categorie_id=c.id and c.id="+id;
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   souscategories.add(new SousCategorie(rs.getInt(1), rs.getString("libelle"), rs.getString("description"),rs.getInt("categorie_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return souscategories;
    }
    


}

    
                
            
           
        
     
    
    

