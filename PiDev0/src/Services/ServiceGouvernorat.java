/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceGouvernorat;
import Models.Delegation;
import Models.Gouvernorat;
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
public class ServiceGouvernorat implements IServiceGouvernorat{
    
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();
    
    //Read
 
    @Override
    public List<Gouvernorat> ReadGouvernorat() {
          ArrayList<Gouvernorat> gouvernorats = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
            String req = "SELECT * FROM gouvernorat ORDER BY `nom` ASC";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   gouvernorats.add(new Gouvernorat(rs.getInt(1), rs.getString("nom")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return gouvernorats;  
    }

    @Override
    public Gouvernorat FindGouveroratByID(int id) {
       Gouvernorat gouv= null;
       
        try {
            String req = "SELECT * FROM gouvernorat WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
               gouv= new Gouvernorat(Res.getInt(1), Res.getString("nom"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return gouv;    }   
    
    
    
    @Override
    public Gouvernorat FindGouveroratByName(String nom) {
       Gouvernorat gouv= null;
       
        try {
            String req = "SELECT * FROM gouvernorat WHERE nom=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1,nom);
            ResultSet Res=pst.executeQuery();
            if(Res.next())
            {
               gouv= new Gouvernorat(Res.getInt(1), Res.getString("nom"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return gouv;    }   

    @Override
    public List<Delegation> listDelegationsByGouvernorat(int id) {
         ArrayList<Delegation> delegations = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM delegation d ,gouvernorat g where d.gouvernorat_id=g.id and g.id="+id;
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   delegations.add(new Delegation(rs.getInt(1), rs.getString("nom"), rs.getInt("gouvernorat_id")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return delegations;    }



}
    

