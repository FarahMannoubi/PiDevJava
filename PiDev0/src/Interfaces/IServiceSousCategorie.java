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
public interface IServiceSousCategorie {
    
    public void CreateSousCategorie(SousCategorie c);
    public void UpdateSousCategorie(SousCategorie c);
    public void DeleteSousCategorie(int id );
    public List<SousCategorie> ReadSousCategories();
    public SousCategorie FindSousCategorieByID(int id );

    
}
