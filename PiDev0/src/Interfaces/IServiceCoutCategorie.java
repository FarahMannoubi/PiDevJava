/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.CoutCategorie;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceCoutCategorie {
     public void CreateCoutCategorie(CoutCategorie c);
    public List<CoutCategorie> ReadCoutCategories();
    public void UpdateCoutCategorie(CoutCategorie c);
    public void DeleteCoutCategorie(int id ); 
    public CoutCategorie FindCoutCategorieByID(int id );
    
}
