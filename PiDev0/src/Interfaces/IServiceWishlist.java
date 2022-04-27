/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Wishlist;
import java.util.List;

/**
 *
 * @author manou
 */
public interface IServiceWishlist {
     public void CreateWishlist(Wishlist w);
    public void UpdateWishlist(Wishlist w);
    public void DeleteWishlist(int id );
    public List<Wishlist> ReadWishlists();
   

    
}
