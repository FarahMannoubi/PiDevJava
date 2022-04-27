/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceWishlist;
import Models.Wishlist;
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
 * @author manou
 */
public class ServiceWishlist implements IServiceWishlist{

 Connexion instance = Connexion.getInstance();
    Connection cnx = instance.getCnx();



    @Override
    public void CreateWishlist(Wishlist w) {
      try {
            String req = "INSERT INTO `wishlist`(`id`, `utilisateur_id`, `demande_evenement_id`) VALUES (NULL, '"+w.getUtilisateur_id()+"', '"+w.getDemande_evenement_id()+"')";

            PreparedStatement st = cnx.prepareStatement(req);   
           
            st.executeUpdate(req);
            System.out.println("Wishlist ajoutée avec succes.\n");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public void UpdateWishlist(Wishlist w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteWishlist(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Wishlist> ReadWishlists() {
      
ArrayList<Wishlist> Wishlists = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT `id`, `utilisateur_id`, `demande_evenement_id` FROM `wishlist`";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
     
                Wishlists.add(new Wishlist(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return Wishlists ;
    }
    
}
