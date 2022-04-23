/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceDelegation;
import Models.Delegation;
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
public class ServiceDelegation implements IServiceDelegation{
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();
    
    
    @Override
    public void CreateDelegation(Delegation d) {
        ServiceGouvernorat SG=new ServiceGouvernorat(); 
       if(SG.FindGouveroratByID(d.getGouvernorat())!=null){
        
        try {
            String req = "INSERT INTO `delegation` ( `nom`, `gouvernorat_id`) VALUES ('"+d.getNom()+"', '"+d.getGouvernorat()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Delegation ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
       }
       else 
       {System.out.println("Gouvernorat n'existe pas \n");}    }

    @Override
    public void UpdateDelegation(Delegation d) {
    try {
           
                   String  req="UPDATE delegation SET nom='"+d.getNom()+"',gouvernorat_id ='"+d.getGouvernorat()+"' WHERE `id`="+d.getId();
                   PreparedStatement pstm = cnx.prepareStatement(req);
                   
                  
                   pstm.executeUpdate(req);
                   System.out.println("Delegation Modifiée avec succes.\n");
               }
           
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }    }

    @Override
    public void DeleteDelegation(int id) {
       try {
          String query ="DELETE FROM delegation WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" Delegation supprimée avec success\n");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}    } 
    

    @Override
    public List<Delegation> ReadDelegations() {
        ArrayList<Delegation> delegations = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM delegation ORDER BY `nom` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   delegations.add(new Delegation(rs.getInt(1), rs.getString("nom"), rs.getInt("gouvernorat_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return delegations;
    }

    @Override
    public Delegation FindSousDelegationByID(int id) {
        Delegation d= null;
       
        try {
            String req = "SELECT * FROM delegation WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
               d= new Delegation(Res.getInt(1), Res.getString("nom"), Res.getInt("gouvernorat_id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return d; 
    }
    
}
