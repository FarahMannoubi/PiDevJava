/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Models.Delegation;
import Models.Gouvernorat;
import Services.ServiceDelegation;
import Services.ServiceGouvernorat;
import Services.ServiceSousCategorie;
import java.util.List;

/**
 *
 * @author Fatma
 */
public class gouvernorat_delegations {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        System.out.println("================== CRUD Gouvernorat ====================\n");
        ServiceGouvernorat sGouvernorat=new ServiceGouvernorat();
        
        // *********** Read Gouvernorat *******************
        /*
        System.out.println("********* Liste des Gouvernorats ****************\n");
        List<Gouvernorat> gouvernorats=sGouvernorat.ReadGouvernorat();
        for(int i=0;i<gouvernorats.size();i++)
        {System.out.println(gouvernorats.get(i).toString()+"\n");}
        */
        
         // *********** Find Gouvernorat By ID *******************
         /*
        System.out.println("********* Recherche d'un Gouvernorat par id ****************\n");
        if(sGouvernorat.FindGouveroratByID(3)!=null)
        {System.out.println(sGouvernorat.FindGouveroratByID(3));
        }
        else {System.out.println("Gouvernorat n'existe pas\n");}
        */
         
        // *********** Find Gouvernorat By Name *******************
        /*
        System.out.println("********* Recherche d'un Gouvernorat par nom ****************\n");
        if(sGouvernorat.FindGouveroratByName("Ariana")!=null)
        {System.out.println(sGouvernorat.FindGouveroratByName("Ariana"));
        }
        else {System.out.println("Gouvernorat n'existe pas\n");}
        */
         // *********** Find Delegations By Gouvernorat *******************
        // /*
        System.out.println("********* Recherche des delegations par Gouvernorat *************\n");
        List<Delegation> delegations=sGouvernorat.listDelegationsByGouvernorat(1);
        for(int i=0;i<delegations.size();i++)
        {System.out.println(delegations.get(i).toString()+"\n");}
        //*/
        
        
        
        System.out.println("================== CRUD Delegations ====================\n");
        ServiceDelegation sDelegation=new ServiceDelegation();
        
        // *********** Read Delegations *******************
        /*
        System.out.println("********* Liste des delegations ****************\n");
        List<Delegation> delegations=sDelegation.ReadDelegations();
        for(int i=0;i<delegations.size();i++)
        {System.out.println(delegations.get(i).toString()+"\n");}
        */
        
         // *********** Create Delegation *******************
        /*
        System.out.println("********* Ajout d'une nouvelle Delegation ****************\n");
        Delegation del=new Delegation("TEST",1);
        sDelegation.CreateDelegation(del);
        */
        
        
        // *********** Update Delegation *******************
        /*
        System.out.println("********* Modification d'une delegation **************** \n");
        Delegation d=new Delegation(29,"Mourouj",2);
        sDelegation.UpdateDelegation(d);
        */
        
         // *********** Delete Delegation *******************
        /*
        System.out.println("********* Suppresion d'une Delegation ****************\n");
        sDelegation.DeleteDelegation(29);
        */
        
         // *********** Find Delegation By ID *******************
         /*
        System.out.println("********* Recherche d'une delegation par id ****************\n");
        if(sDelegation.FindSousDelegationByID(30)!=null)
        {System.out.println(sDelegation.FindSousDelegationByID(30));
        }
        else {System.out.println("Delegation n'existe pas\n");}
        */


        
    }
}
