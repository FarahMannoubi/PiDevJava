/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IUser;
import Models.Utilisateur;
import Utils.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ServiceUser implements IUser{
    Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();


    @Override
    public void addUser(Utilisateur u) {
            
            try {
                String c="bonjour";
//                 String Req = "INSERT INTO `utilisateur`(`login`, `password`,`role`,`nom`, `prenom`, `date_naissance`,`email`,`num_tel`) VALUES ('"+u.getLogin()+"', '"+u.getPassword()+"','"+c+"',"+u.getNom()+"','"+u.getPrenom()+"','"+u.getDate_naissance()+"','"+u.getEmail()+"','"+u.getNum_tel()+"')";
                  String Req= "INSERT INTO `utilisateur`(`login`, `password`, `role`, `nom`, `prenom`, `date_naissance`, `email`, `num_tel`, `capatcha_code`, `activation_token`, `reset_token`, `image`) VALUES ('"+u.getLogin()+"','"+u.getPassword()+"','"+c+"','"+u.getNom()+"','"+u.getPrenom()+"','"+u.getDate_naissance()+"','"+u.getEmail()+"','"+u.getNum_tel()+"','"+c+"','"+c+"','"+c+"','"+u.getImage()+"')";
PreparedStatement ps = cnx.prepareStatement(Req);
//                ps.setString(1,u.getLogin());
//                ps.setString(2, u.getPassword());
//                ps.setString(3,u.getNom());
//                ps.setString(4,u.getPrenom());
//                ps.setDate(5, (Date) u.getDate_naissance());
//                ps.setString(6,u.getEmail());
//                ps.setInt(7,u.getNum_tel());
               
                ps.executeUpdate(Req);
                System.out.println("User Added Succesfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }

    @Override
    public List<Utilisateur> afficherUsers() {
       ArrayList<Utilisateur> user = new ArrayList();
          try {
            Statement st = cnx.createStatement(); 
             String req = "SELECT * FROM utilisateur";
            ResultSet rs = st.executeQuery(req);
              while (rs.next()) {  
                   user.add(new Utilisateur(rs.getInt(1),rs.getString("login"), rs.getString("password"), rs.getString("nom"),rs.getString("prenom"),rs.getString("date_naissance"),rs.getString("email"),rs.getInt(7),rs.getString("Image")));
                                }
              } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return user;
    }

    @Override
    public void DeleteUser(int id) {
       try {
          String query ="DELETE FROM utilisateur WHERE id="+id;
         Statement st = cnx.createStatement();
         st.executeUpdate(query);
          System.out.println(" utilisateur supprimée avec success");
      }
      catch(SQLException e){
        System.out.println(e.getMessage());}  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierUser(Utilisateur u) {
    
        try {
        String c="bonjour";
         String  req="UPDATE utilisateur SET login='"+u.getLogin()+"',password='"+u.getPassword()+"',role='"+c+"',nom='"+u.getNom()+"',prenom='"+u.getPrenom()+"',date_naissance='"+u.getDate_naissance()+"',email='"+u.getEmail()+"',num_tel='"+u.getNum_tel()+"',Image='"+u.getImage()+"',capatcha_code='"+c+"',activation_token='"+c+"',reset_token='"+c+"'  WHERE `id`="+u.getId();
      // String req="UPDATE utilisateur SET login='"+u.getLogin()+"',password='"+u.getPassword()"',role='"+c+"',nom='"+u.getNom()+"',prenom='"+u.getPrenom()+"',date_naissance='"+u.getDate_naissance()+"',email='"+u.getEmail()+"',num_tel='"+u.getNum_tel()+"',capatcha_code`="+c+"',activation_token='"+c+"',reset_token='"+c+"',image='"+u.getImage()+"' WHERE `id`="+u.getId();
        PreparedStatement pstm = cnx.prepareStatement(req);
         pstm.executeUpdate(req);
         System.out.println("Utilisateur updated succesfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getId() throws SQLException {
       String sql="SELECT id FROM utilisateur ";
            Statement statement = cnx.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id =  rs.getInt("id"); 
                return id;
              }
        return 0;}

    @Override
    public Utilisateur getByEmail(String email) {
       Utilisateur u =new Utilisateur();
         String query = "SELECT * FROM utilisateur where `email`='"+email+"'";
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                
                u=new Utilisateur(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return u;}
    
    public String getNomUserById(int id){
        String nom="";
          String query = "SELECT `nom` FROM utilisateur where `id`="+id;
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                
                nom=rs.getString("nom");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return nom;
    }
    
}
