/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import pidev0.*;
import Models.Categorie;
import Models.SousCategorie;
import Services.ServiceCategorie;
import Services.ServiceSousCategorie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fatma
 */
public class PiDev0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("================== CRUD Categorie ====================\n");
         ServiceCategorie sCategorie=new ServiceCategorie();
        
        // *********** Read Categorie *******************
        /*
        System.out.println("********* Liste des categories ****************\n");
        List<Categorie> categories=sCategorie.ReadCategories();
        for(int i=0;i<categories.size();i++)
        {System.out.println(categories.get(i).toString()+"\n");}
        */
    
    
        // *********** Create Categorie *******************
        /*
        System.out.println("********* Ajout d'une nouvelle categorie ****************");
        Categorie c=new Categorie("Test","test test test test");
        sCategorie.CreateCategorie(c);
        */
        
        
        // *********** Update Categorie *******************
        /*
        System.out.println("********* Modification d'une categorie ****************");
        Categorie cat1=new Categorie(90,"bla","test bla bla bla bla test test");
        sCategorie.UpdateCategorie(cat1);
        */
        
        // *********** Delete Categorie *******************
        /*
        System.out.println("********* Suppresion d'une categorie ****************");
        sCategorie.DeleteCategorie(90);
        */
       
        // *********** Find Categorie By ID *******************
        /*
        System.out.println("********* Recherche d'une categorie par id ****************\n");
        if(sCategorie.FindCategorieByID(0)!=null)
        {System.out.println(sCategorie.FindCategorieByID(0));
        }
        else {System.out.println("Categorie n'existe pas\n");}
         */
        
        // *********** Find SousCategorie By Categoire *******************
         /*
        System.out.println("********* Recherche des sous categorie par Categorie *************\n");
        List<SousCategorie> souscategories=sCategorie.listSousCategoriesByCategorie(71);
        for(int i=0;i<souscategories.size();i++)
        {System.out.println(souscategories.get(i).toString()+"\n");}
        */
         
         
            
        System.out.println("================== CRUD Sous-Categorie ====================\n");
        ServiceSousCategorie sSousCategories=new ServiceSousCategorie();
        
        // *********** Read Sous-Categorie *******************
        /*
        System.out.println("********* Liste des sous categories ****************\n");
        List<SousCategorie> souscategories=sSousCategories.ReadSousCategories();
        for(int i=0;i<souscategories.size();i++)
        {System.out.println(souscategories.get(i).toString()+"\n");}
        */
    
    
        // *********** Create Sous-Categorie *******************
        /*
        System.out.println("********* Ajout d'une nouvelle sous-categorie ****************\n");
        SousCategorie sc=new SousCategorie("Test","test test test test",1);
        sSousCategories.CreateSousCategorie(sc);
        */
        
        
        // *********** Update Sous-Categorie *******************
        /*
        System.out.println("********* Modification d'une sous-categorie **************** \n");
        SousCategorie sc=new SousCategorie(32,"bla","test bla bla bla bla test test",71);
        sSousCategories.UpdateSousCategorie(sc);
        */
        
        // *********** Delete Categorie *******************
        /*
        System.out.println("********* Suppresion d'une sous-categorie ****************\n");
        sSousCategories.DeleteSousCategorie(32);
        */
        
        // *********** Find Sous-Categorie By ID *******************
        /*
        System.out.println("********* Recherche d'une sous-categorie par id ****************\n");
        if(sSousCategories.FindSousCategorieByID(21)!=null)
        {System.out.println(sSousCategories.FindSousCategorieByID(21));
        }
        else {System.out.println("sous-Categorie n'existe pas\n");}
        */
               
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
