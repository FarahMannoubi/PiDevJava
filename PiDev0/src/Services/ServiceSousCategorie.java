/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceSousCategorie;
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
public class ServiceSousCategorie implements IServiceSousCategorie {
     Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();
    
    //Read
    @Override
    public List<SousCategorie> ReadSousCategories() {
         ArrayList<SousCategorie> souscategories = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM sous_categorie ORDER BY `libelle` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   souscategories.add(new SousCategorie(rs.getInt(1), rs.getString("libelle"), rs.getString("description"),rs.getInt("categorie_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return souscategories;
    }
    
    //create
    @Override
    public void CreateSousCategorie(SousCategorie c) {
       ServiceCategorie sc=new ServiceCategorie(); 
       if(sc.FindCategorieByID(c.getCategorie())!=null){
        
        try {
            String req = "INSERT INTO `sous_categorie` ( `libelle`, `description`,`categorie_id`) VALUES ('"+c.getLibelle()+"', '"+c.getDescription()+"','"+c.getCategorie()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Sous Catégorie ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
       }
       else 
       {System.out.println("Categorie inexistante \n");}
    }
    

    @Override
    public void UpdateSousCategorie(SousCategorie SC) {
try {
           
                   String  req="UPDATE sous_Categorie SET libelle='"+SC.getLibelle()+"',description ='"+SC.getDescription()+"',categorie_id ='"+SC.getCategorie()+"' WHERE `id`="+SC.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("SousCatégorie Modifiée avec succes.\n");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }    }

    @Override
    public void DeleteSousCategorie(int id) {
try {
          String query ="DELETE FROM sous_categorie WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" SousCategorie supprimée avec success\n");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    } 

    @Override
    public SousCategorie FindSousCategorieByID(int id) {
           SousCategorie cat= null;
       
        try {
            String req = "SELECT * FROM sous_categorie WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
               cat= new SousCategorie(Res.getInt(1), Res.getString("libelle"), Res.getString("description"),Res.getInt("categorie_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cat;    }
}
    
    

