/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Categorie;
import Models.Produit;
import java.util.List;

/**
 *
 * @author dell
 */
public interface IServiceProduit {
    public void CreateProduit(Produit p);
    public void UpdateProduit(Produit p);
    public void DeleteProduit(Produit P );

    //select all
    public List<Produit> fetchAllProduit();

    
}
