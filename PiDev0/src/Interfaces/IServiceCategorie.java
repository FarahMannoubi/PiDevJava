/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Categorie;
import Models.SousCategorie;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceCategorie {
     //CRUD
    public void CreateCategorie(Categorie c);
    public List<Categorie> ReadCategories();
    public void UpdateCategorie(Categorie c);
    public void DeleteCategorie(int id ); 
    public Categorie FindCategorieByID(int id );
    public List<SousCategorie> listSousCategoriesByCategorie(int id);
    
}
