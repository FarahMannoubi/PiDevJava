/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Avis;
import Models.Categorie;
import java.util.List;
/**
 *
 * @author dell
 */



/**
 *
 * @author dell
 */
public interface IServiceAvis {
    
    //create
    public void CreateAvis(Avis A);
    
    //update
     public void UpdateAvis(Avis A);
     
     //delete
     public void DeleteAvis(int id );
    
    //select all
    public List<Avis> fetchAllAvis();
}
