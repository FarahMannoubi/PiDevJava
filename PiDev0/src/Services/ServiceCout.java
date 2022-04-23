/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceCout;
import Models.Cout;
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
public class ServiceCout implements IServiceCout{
       Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();

    // Create
    @Override
    public void CreateCout(Cout c) {

     
        try {
            String req = "INSERT INTO `cout`( `destination_id`, `coutcategorie_id`, `prix`) VALUES  ('"+c.getDestination_id()+"','"+c.getCoutcategorie()+"','"+c.getPrix()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("cout ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
    
    //Read
    @Override
    public List<Cout> ReadCouts() {
         ArrayList<Cout> Couts = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM cout ";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   Couts.add(new Cout(rs.getInt(1), rs.getInt("destination_id"), rs.getInt("coutcategorie_id"),rs.getInt("prix")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return Couts;
    }
    
        @Override
    public void UpdateCout(Cout C) {
        
       try {
           
                   String  req="UPDATE cout SET =destination_id'"+C.getDestination_id()+"',coutcategorie_id ='"+C.getCoutcategorie()+"' WHERE `id`="+C.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Cout Modifié avec succes.\n");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
       }
    
    //Delete
    
    @Override
    public void DeleteCout(int id) {
try {
          String query ="DELETE FROM cout WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Cout supprimée avec success\n");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    }

    @Override
    public Cout FindCoutByID(int id) {
      Cout cout= null;
       
        try {
            String req = "SELECT * FROM cout WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                   cout=new Cout(rs.getInt(1), rs.getInt("destination_id"), rs.getInt("coutcategorie_id"),rs.getInt("prix"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cout;
 }

  

}
