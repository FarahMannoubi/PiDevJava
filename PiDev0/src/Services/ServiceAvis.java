/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceAvis;
import Models.Avis;
import Models.Categorie;
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
public class ServiceAvis implements IServiceAvis {
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

    @Override
    public void CreateAvis(Avis A) {
        try {
         String req = "INSERT INTO `avis`(`demande_event_id`, `utilisateur_id`, `commentaire`, `note`) VALUES ('"+A.getDemande_event_id()+"', '"+A.getUtilisateur_id()+"','"+A.getCommentaire()+"','"+A.getNote()+"')";
     Statement st = cnx.createStatement();
     
        st.executeUpdate(req);
            System.out.println("Avis ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
    //Read
    @Override
    public List<Avis> fetchAllAvis() {
         ArrayList<Avis> aviss = new ArrayList();
          try {
            Statement st = cnx.createStatement();        
            
           String req = "SELECT * FROM avis";
           
            ResultSet rs = st.executeQuery(req);
            
              while (rs.next()) {  
     
     aviss.add(new Avis(rs.getInt(1), rs.getString("commentaire"), rs.getFloat("note"), rs.getInt("demande_event_id"), rs.getInt("utilisateur_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return aviss;
    }
    
     //update
    public void UpdateAvis(Avis A) {
        
       try {
           
                   String  req="UPDATE Avis SET demande_event_id='"+A.getDemande_event_id()+"',utilisateur_id ='"+A.getUtilisateur_id()+"',commentaire ='"+A.getCommentaire()+"',note ='"+A.getNote()+ "'WHERE `id`="+A.getId();
                  
                   
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Avis modifiée avec succes.");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
     //Delete
    
    public void DeleteAvis(int id) {
try {
          String query ="DELETE FROM avis WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Avis supprimée avec success");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }


}