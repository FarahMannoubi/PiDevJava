/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Interfaces.IServiceReservation;
import Models.Reclamation;
import Models.Reservation;
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
public class ServiceReservation implements IServiceReservation { 
Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

    // Create
    @Override
    public void CreateReservation(Reservation res){
 {
        
     
        try {
            String req = "INSERT INTO `reservation`( `demande_event_id`, `utilisateur_id`, `date_res`, `heure_res`, `statut`, `cout`) VALUES ('"+res.getDemande_event_id()+"','"+res.getUtilisateur_id()+"','"+res.getDate_res()+"','"+res.getHeure_res()+"','"+res.getStatut()+"','"+res.getCout()+"')";
            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Reservation ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
}

    @Override
    public void UpdateReservation(Reservation res) {
          try {
           
                   String  req="UPDATE Reservation SET demande_event_id='"+res.getDemande_event_id()+"',utilisateur_id ='"+res.getUtilisateur_id()+"',date_res ='"+res.getDate_res()+"',heure_res='"+res.getHeure_res()+"',statut='"+res.getStatut()+"',cout='"+res.getCout()+"' WHERE `id`="+res.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Reservation modifiée avec succes.");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
      
    }

    @Override
    public void DeleteReservation(int id) {
        try {
          String query ="DELETE FROM reservation WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Reservation supprimée avec success");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }
    


    @Override
    public List<Reservation> ReadReservations() {
         ArrayList<Reservation> Reservations = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM reservation";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   Reservations.add(new Reservation(rs.getInt(1), rs.getInt("demande_event_id"), rs.getInt("utilisateur_id"),rs.getString("date_res"),rs.getString("heure_res"),rs.getFloat("statut"),rs.getFloat("cout")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return Reservations;
    }


  
 }
    
    

