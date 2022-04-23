/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Categorie;
import Models.Destination;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceDestination {
    
     public void CreateDestination(Destination c);
    public List<Destination> ReadDestinations();
    public void UpdateDestination(Destination c);
    public void DeleteDestination(int id ); 
    public Destination FindDestinationByID(int id );
    public List<Destination> FindDestinationByName(String nom);
    
    public List<Destination> FindDestinationSousCategories(int id);
    public List<Destination> FindDestinationDelegations(int id);


    
    


    
}
