/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Models.CoutCategorie;
import Models.Destination;
import Services.ServiceCoutCategorie;
import Services.ServiceDestination;
import java.util.List;

/**
 *
 * @author Fatma
 */
public class cout {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("================== CRUD Cout-Categorie ====================\n");
         ServiceCoutCategorie sCoutCategorie=new ServiceCoutCategorie();
        
        // *********** Read Cout-Categorie *******************
        /*
        System.out.println("********* Liste des couts-categories ****************\n");
        List<CoutCategorie> coutscategorie=sCoutCategorie.ReadCoutCategories();
        for(int i=0;i<coutscategorie.size();i++)
        {System.out.println(coutscategorie.get(i).toString()+"\n");}
        */
    
    
        // *********** Create Cout-Categorie *******************
        /*
        System.out.println("********* Ajout d'une nouvelle categorie-cout ****************");
        CoutCategorie c=new CoutCategorie("TEST","TEST");
        sCoutCategorie.CreateCoutCategorie(c);
        */
        
        
        // *********** Update Cout-Categorie *******************
        /*
        System.out.println("********* Modification Cout-categorie ****************");
        CoutCategorie cat1=new CoutCategorie(11,"cout","cout");
        sCoutCategorie.UpdateCoutCategorie(cat1);
        */
        
        // *********** Delete Cout-Categorie *******************
        /*
        System.out.println("********* Suppresion cout-categorie ****************");
        sCoutCategorie.DeleteCoutCategorie(11);
        */
       
        // *********** Find Cout-Categorie By ID *******************
        /*
        System.out.println("********* Recherche cout-categorie par id ****************\n");
        if(sCoutCategorie.FindCoutCategorieByID(1)!=null)
        {System.out.println(sCoutCategorie.FindCoutCategorieByID(1));
        }
        else {System.out.println("Cout-Categorie n'existe pas\n");}
        */
    
        
        
          System.out.println("================== CRUD Destination ====================\n");
         ServiceDestination sDestination=new ServiceDestination();
        
        // *********** Read Destination *******************
        /*
        System.out.println("********* Liste des couts-categories ****************\n");
        List<Destination> destinations=sDestination.ReadDestinations();
        for(int i=0;i<destinations.size();i++)
        {System.out.println(destinations.get(i).toString()+"\n");}
        */
        
         // *********** Create Destinations *******************
        /*
        System.out.println("********* Ajout d'une nouvelle Destination ****************\n");
        Destination des=new Destination("test", "description test","image", "adresse image",58785555, "email test", 21,28);
        sDestination.CreateDestination(des);
        */
        
          // *********** Update Destination *******************
        
        /*System.out.println("********* Modification d'une Destination **************** \n");
        Destination des=new Destination(4,"fatma", "description test","image", "adresse image",58785555, "fatma.esprit.tn", 21,28);
        sDestination.UpdateDestination(des);*/
        
        
           // *********** Delete Destination *******************
       
        System.out.println("********* Suppresion d'une Destination ****************\n");
        sDestination.DeleteDestination(45);
       
       
       // *********** Find Destination By ID *******************
        /*
        System.out.println("********* Recherche d'une destination par id ****************\n");
        if(sDestination.FindDestinationByID(42)!=null)
        {System.out.println(sDestination.FindDestinationByID(42));
        }
        else {System.out.println("destination n'existe pas\n");}
        */
        
         // *********** Find Destination By Name *******************
        /*
        System.out.println("********* Recherche des destination par nom ****************\n");
        if(sDestination.FindDestinationByName("test").size()!=0)
        {System.out.println(sDestination.FindDestinationByName("test"));
        }
        else {System.out.println("destination n'existe pas\n");}
        */
        
        // *********** Find Destination par sous-categorie *******************
        /*
        System.out.println("********* Liste des destination par sous-categorie ****************\n");
        if(sDestination.FindDestinationSousCategories(21).size()!=0)
        {System.out.println(sDestination.FindDestinationSousCategories(21));
        }
        else {System.out.println("destination n'existe pas\n");}
        */
        
        // *********** Find Destination par delegation *******************
        /*
        System.out.println("********* Liste des destination par delegation ****************\n");
        if(sDestination.FindDestinationDelegations(28).size()!=0)
        {System.out.println(sDestination.FindDestinationDelegations(28));
        }
        else {System.out.println("destination n'existe pas\n");}
        */

        
    
}
}