/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceProduit;
import Models.Avis;
import Models.Produit;
import Utils.Connexion;
import static java.awt.PageAttributes.MediaType.A;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ServiceProduit implements IServiceProduit{
    
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();
    
     public void CreateProduit(Produit P) {
        try {
         String req = "INSERT INTO `produit`(`avis_id`, `description`) VALUES ('"+P.getAvis_id()+"', '"+P.getDescription()+"')";
     Statement st = cnx.createStatement();
     
        st.executeUpdate(req);
            System.out.println("Produit ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
     
     public ArrayList<Produit> fetchAllProduit() {
         ArrayList<Produit> produits = new ArrayList();
          try {
            Statement st = cnx.createStatement();        
            
           String req = "SELECT * FROM produit";
           
            ResultSet rs = st.executeQuery(req);
            
              while (rs.next()) {  
     
     produits.add(new Produit(rs.getInt(1), rs.getInt("avis_id"), rs.getString("description")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return produits;
    }
     
     //update
    public void UpdateProduit(Produit P) {
        
       try {
           
                   String  req="UPDATE produit SET avis_id='"+P.getAvis_id()+"',description='"+P.getDescription()+"'WHERE `id`="+P.getId();
                                   
                  
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Produit modifiée avec succes.");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }

     //Delete
    
    public void DeleteProduit(int id) {
try {
          String query ="DELETE FROM produit WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Produit supprimée avec success");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }


   
    
    
}
