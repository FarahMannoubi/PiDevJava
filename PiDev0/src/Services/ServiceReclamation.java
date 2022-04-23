/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceReclamation;
import Models.Reclamation;
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
 * @author hedib
 */
public class ServiceReclamation implements IServiceReclamation{ 
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

    @Override
    public void CreateReclamation(Reclamation rec) {
          try {
            String req = "INSERT INTO `reclamation`( `reservation_id`, `type`, `description`, `date_rec`, `etat`) VALUES ('"+rec.getReservation_id()+"','"+rec.getType()+"','"+rec.getDescription()+"','"+rec.getDate_rec()+"','"+rec.getEtat()+"')";
            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Reclamation ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }

    

    @Override
    public void UpdateReclamation(Reclamation rec) {
           try {
           
                   String  req="UPDATE Reclamation SET reservation_id='"+rec.getReservation_id()+"',type ='"+rec.getType()+"',description='"+rec.getDescription()+"',date_rec='"+rec.getDate_rec()+"',etat ='"+rec.getEtat()+"' WHERE `id`="+rec.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Reclamation modifiée avec succes.");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
      
    }

    @Override
    public void DeleteReclamation(int id) {
           try {
          String query ="DELETE FROM reclamation WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Reclamation supprimée avec success");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());} 
    }

    @Override
    public List<Reclamation> ReadReclamations() {
         ArrayList<Reclamation> Reclamations = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM reclamation";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   Reclamations.add(new Reclamation(rs.getInt(1), rs.getInt("reservation_id"),rs.getString("type"),rs.getString("description"),rs.getString("date_rec"),rs.getInt("etat")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return Reclamations;
    }

    
   
}
