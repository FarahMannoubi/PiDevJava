/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceMedia;
import Models.Avis;
import Models.Media;
import Models.Produit;
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
 * @author dell
 */
public class ServiceMedia implements IServiceMedia{
    
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

     public void CreateMedia(Media M) {
        try {
         String req = "INSERT INTO `media`(`produit_id`, `image`, `video`) VALUES ('"+M.getProduit_id()+"', '"+M.getImage()+"','"+M.getVideo()+"')";
     Statement st = cnx.createStatement();
     
        st.executeUpdate(req);
            System.out.println("Media ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
     
    /**
     *
     * @return
     */
    @Override
      public ArrayList<Media> fetchAllMedia(){
         ArrayList<Media> medias = new ArrayList();
          try {
            Statement st = cnx.createStatement();        
            
           String req = "SELECT * FROM media";
           
            ResultSet rs = st.executeQuery(req);
            
              while (rs.next()) {  
     
     medias.add(new Media(rs.getInt(1), rs.getInt("produit_id"), rs.getString("image"), rs.getString("video")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return medias;
    }
    
      //update
    public void UpdateMedia(Media M) {
        
       try {
           
                   String  req="UPDATE media SET produit_id='"+M.getProduit_id()+"',image='"+M.getImage()+"',video='"+M.getVideo()+"'WHERE `id`="+M.getId();
                                   
                  
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Media modifiée avec succes.");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }

    
    //Delete
    
    public void DeleteMedia(Media M) {
try {
          String query ="DELETE FROM media WHERE id="+M.getId();
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Media supprimée avec success");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }
    
public int getId() throws SQLException {
       String sql="SELECT id FROM `media`";
            Statement statement = cnx.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =  rs.getInt("id"); 
                return id;
              }
        return 0;}   
}



    


