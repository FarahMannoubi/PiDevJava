/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev0;

import Models.Avis;
import Models.Categorie;
import Models.CoutEvenement;
import Models.DemandeEvenement;
import Models.Produit;
import Models.Reclamation;
import Models.Reservation;
import Models.SousCategorie;
import Models.Utilisateur;
import Services.ServiceAvis;
import Services.ServiceCategorie;
import Services.ServiceCoutCategorie;
import Services.ServiceCoutEvenement;
import Services.ServiceDemandeEvenement;
import Services.ServiceDestination;
import Services.ServiceProduit;
import Services.ServiceReclamation;
import Services.ServiceReservation;
import Services.ServiceSousCategorie;
import Services.ServiceUser;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fatma
 */
public class PiDev0 {

   

  
private List<CoutEvenement> coutEvenements=new ArrayList<>();
//CoutEvenement ce =new CoutEvenement();
 
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws SQLException {
        
       //////////////////////////////////////CRUD DemandeEvenement //////////////////////////////////////////////////////////////////////////////////////////////////////////

        // TODO code application logic here
        ServiceDemandeEvenement sde=new ServiceDemandeEvenement();

        //System.out.println("la liste"+sde.GetDemandeEvenement());

 Date dateDemande ,dateDebutEvenement,dateFinEvenement;
dateDemande = null;
dateDebutEvenement=null;
dateFinEvenement=null;
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    try {
      dateDemande = format.parse("2012-06-22");
dateDebutEvenement=format.parse("2010-06-22");
dateFinEvenement=format.parse("2020-06-22");
    } catch (ParseException e) {
      e.printStackTrace();
    }
ServiceCoutEvenement sce=new ServiceCoutEvenement();
//CoutEvenement ce=new CoutEvenement(31,1,45, 100, 222);
//System.out.println("CoutCategorieByIdDemandeEvenement"+sce.GetIdCoutCategorieByIdDemandeEvenement(60));
//System.out.println("GetIdCoutCategorieByIdCoutEvenement"+sce.GetIdsCoutEvenementByIdDemandeEvenement(83));
//idcoutEvenements=new ArrayList<>();
DemandeEvenement de =  new DemandeEvenement(3, 1,format.format(dateDemande)," ", "Evènement pour les enfant "
        ,format.format(dateDebutEvenement),format.format(dateFinEvenement), "00:00:00","00:00:00","film disney",121
        , "Encanto: la fantastique famille Madrigal","animation-enfants-evenements.jpg");
sde.addDemandeEvenement(de);
        System.out.println("lllllll"+sde.idDemandeEvenementByLibelleDemandeEvenement("Encanto: la fantastique famille Madrigal"));
List<CoutEvenement> coutEvenements=sce.GetIdsCoutEvenementByIdDemandeEvenement(0);

ServiceDestination sd=new ServiceDestination();
String nom="fgff";
        System.out.println(sd.GetIdDestinationsByNom(nom));
        ServiceCoutCategorie scc=new ServiceCoutCategorie();
        System.out.println(scc.ReadCoutCategories());
          System.out.println(scc.GetLibelleCoutCategorie());
          double prix =sce.GetPrixCoutEvenementById(22);
           String prixString=Float.toString((float) prix);
        System.out.println("tttttttt"+prixString);
      
    }
}
    
    
    

 // System.out.println("listes cout categories"+scc.GetLibelleCoutCategorieByIdCoutCategorie(1));
    

        
        /*// DemandeEvenement de =  new DemandeEvenement(3, 1,format.format(dateDemande)," ", "Evènement pour les enfant ",format.format(dateDebutEvenement),format.format(dateFinEvenement), "00:00:00","00:00:00","film disney",121, "Encanto: la fantastique famille Madrigal","animation-enfants-evenements.jpg");
 //DemandeEvenement de1 =  new DemandeEvenement(18,3, 1,format.format(dateDemande)," ", "Evènement pour les adultes",format.format(dateDebutEvenement),format.format(dateFinEvenement), "00:00:00","00:00:00","ghodwa",10, "JCI","7cc93dac5e27e34f79ac2ff12325a159.jpg");
//ystem.out.println("Listes des demande By Id"+"\n"+sde.GetDemandeEvenementById(de)); 
//System.out.println("Listes des demande By IdUtilisateur"+"\n"+sde.GetDemandeEvenementByIdUtilisateur(de));        
//.out.println("Listes des demande By IdDestination"+"\n"+sde.GetDemandeEvenementByIdDestination(de));

//sde.addDemandeEvenement(de);
        System.out.println("Listes des demande En Attante"+"\n"+sde.GetDemandeEvenementEnAttante());

//sde.updateDemandeEvenement(de1);
sde.updateDemandeEvenementToAccepter(de1);
//sde.updateDemandeEvenementToRefuser(de1);
System.out.println(sde.GetDemandeEvenement());
sde.deleteDemandeEvenement(18);
System.out.println(sde.GetDemandeEvenement());
//sde.deleteDemandeEvenement(41);
//////////////////////////////////////CRUD CoutEvenement //////////////////////////////////////////////////////////////////////////////////////////////////////////
ServiceCoutEvenement sce=new ServiceCoutEvenement();
System.out.println(sce.GetCoutEvenement());
       CoutEvenement ce=new CoutEvenement(1, 2, 100, 222);
//CoutEvenement ce=new CoutEvenement(31,1, 44, 100, 222);
sce.addCoutEvenement(ce);
//sce.updateCoutEvenement(ce);
//sce.deleteCoutEvenement(25);
    

*/
//===================Crud User ====================
 // ServiceUser u=new ServiceUser();
      // Utilisateur ut= new Utilisateur("safsouf","hdefj","nejma","foulena","2000-12-15","kehiasofiene800@gmail.com",96920229,"hfhkfk");
       //u.addUser(ut);
        // affiche
        //System.out.println(u.afficherUsers());
        //update 
      //Utilisateur ut1=new Utilisateur(3,"hshl","mohamed","nma","foulen","2000-12-15","kehiasofiene9@gmail.com",98456789,"hfhkfk");
       // u.modifierUser(ut1);
        //delete
    //   u.DeleteUser(4);
       // Utilisateur ut2=new Utilisateur();
       // u.getId();
       // u.getByEmail("kehiasofiene80@gmail.com");
    
       //========================= crud avis ======================
         //Avis
         // ServiceAvis sAvis = new ServiceAvis();
       // Avis Av = new Avis();
        
        //Add avis
  //  Avis avi= new Avis("pidev", (float) 3.8, 2, 1);
  //  sAvis.CreateAvis(avi);
        
         //fetchAllAvis
  // System.out.println(sAvis.fetchAllAvis());
     
      //update avis
  //   Avis avi1= new Avis(16,"nour", (float) 3.2, 2, 1);
  //  sAvis.UpdateAvis(avi1);
       
    //delete avis
  // sAvis.DeleteAvis(16);
    
    
        //Produits
   //    ServiceProduit sProduit = new ServiceProduit();
         
   //Add produit
    //Produit prod= new Produit(7, "céramique");
    //sProduit.CreateProduit(prod);
     
      //fetchAllProduit
    //System.out.println(sProduit.fetchAllProduit());
     
     //update produit
    //Produit prod1= new Produit(3, 7, "céramique3");
     //sProduit.UpdateProduit(prod1);
      
      //delete produit
    //sProduit.DeleteProduit(3); 
    
    //=================Crud reservation ================
       //ServiceReservation res= new ServiceReservation();
    //  Reservation r= new Reservation(2,1,"2000-05-16","1919",102,10); 
     //   res.CreateReservation(r);
      // System.out.println(res.ReadReservations());
      //  Reservation res1=new Reservation(6,2,1,"2000-05-18","1920",105,10); 
      //  res.UpdateReservation(res1);
       //  res.DeleteReservation(7);
         
         
         
        //ServiceReclamation rec= new ServiceReclamation();
        //Reclamation rec1=new Reclamation(5,"cc","hello","200-05-05",7); 

       //rec.CreateReclamation(rec1);
       // System.out.println(rec.ReadReclamations());
       //Reclamation rec1=new Reclamation(1,5,"cc","hello","200-05-05",7); 
       // rec.UpdateReclamation(rec1);
        //rec.DeleteReclamation(2);
       