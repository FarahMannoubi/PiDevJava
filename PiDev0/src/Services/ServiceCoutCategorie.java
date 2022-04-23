/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceCoutCategorie;
import Models.Categorie;
import Models.CoutCategorie;
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
public class ServiceCoutCategorie implements IServiceCoutCategorie{
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();
    
    
    @Override
    public void CreateCoutCategorie(CoutCategorie c) {
          try {
            String req = "INSERT INTO `cout_categorie` ( `libelle`, `description`) VALUES ('"+c.getLibelle()+"', '"+c.getDescription()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Cout Catégorie ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public List<CoutCategorie> ReadCoutCategories() {
        ArrayList<CoutCategorie> coutcategories = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM cout_categorie ORDER BY `libelle` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   coutcategories.add(new CoutCategorie(rs.getInt(1), rs.getString("libelle"), rs.getString("description")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return coutcategories;
    }
    
    
    
     public List <CoutCategorie> GetLibelleCoutCategorieByIdCoutCategorie(int id) {
    ArrayList<CoutCategorie> coutCategories = new ArrayList();
       
        try {
            String req = "SELECT * FROM cout_categorie WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
               coutCategories.add(new CoutCategorie(rs.getInt(1), rs.getString("libelle"), rs.getString("description")));
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return coutCategories;
    }
     
     
     
     public List<CoutCategorie> GetLibelleCoutCategorie() {
    ArrayList<CoutCategorie> coutCategories = new ArrayList();
       
        try {
            String req = "SELECT `libelle` FROM cout_categorie ";
            PreparedStatement pst = cnx.prepareStatement(req);
          //  pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
               coutCategories.add(new CoutCategorie(rs.getString("libelle"))); 
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return coutCategories;
    }
     
     
       public int GetIdByLibelleCoutCategorie(String libelle) {
    //ArrayList<CoutCategorie> coutCategories = new ArrayList();
       int id=0;
        try {
            
            String req = "SELECT `id` FROM `cout_categorie` WHERE `cout_categorie`.`libelle`='"+libelle+"'";
            PreparedStatement pst = cnx.prepareStatement(req);
          //  pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
               id=rs.getInt("id"); 
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
     
     

    @Override
    public void UpdateCoutCategorie(CoutCategorie C) {
        try {
           
                   String  req="UPDATE cout_categorie SET libelle='"+C.getLibelle()+"',description ='"+C.getDescription()+"' WHERE `id`="+C.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Cout catégorie Modifié avec succes.\n");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }

    @Override
    public void DeleteCoutCategorie(int id) {
     try {
          String query ="DELETE FROM cout_categorie WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Cout catégorie supprimée avec success\n");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }


    @Override
    public CoutCategorie FindCoutCategorieByID(int id) {
       CoutCategorie cat= null;
       
        try {
            String req = "SELECT * FROM cout_categorie WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
               cat= new CoutCategorie(Res.getInt(1), Res.getString("libelle"), Res.getString("description"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cat;
    }


    
    
    
    
}
