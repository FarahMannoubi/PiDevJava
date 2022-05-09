/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controller.EvenementController;
import Interfaces.MyListener;
import Models.DemandeEvenement;
import Models.Wishlist;
import Services.ServiceCoutCategorie;
import Services.ServiceDemandeEvenement;
import Services.ServiceSousCategorie;
import Services.ServiceWishlist;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author manou
 */
public class ListEvenementClient2Controller implements Initializable {

    @FXML
    private HBox listEvenementFavorable;

    /**
     * Initializes the controller class.
     */
    private   List<Integer>listIdEvenementFromWishList=new ArrayList<>();
    private ServiceDemandeEvenement sde=new ServiceDemandeEvenement();
      private ServiceWishlist sw=new ServiceWishlist();
     private ServiceSousCategorie ssc=new ServiceSousCategorie();
    private  ServiceCoutCategorie scc=new ServiceCoutCategorie();
      private   List<Integer> listidCategorieByIdEvenementFromWishlists=new ArrayList<>();
       private List <Wishlist> Wishlist=new ArrayList<>();
           private   List<Integer> listIdEvenementFromWishListMethodGetIdCategorieByIdEvenementFromWishlists=new ArrayList<>();
           private List<Integer>listSousCategorieByIdEvenementFromWishlists=new ArrayList<>();
      private List<DemandeEvenement>  EvenementDisponibleByIdSousCategorie1=new ArrayList<>();
 private List<DemandeEvenement>  EvenementDisponibleByIdSousCategorie=new ArrayList<>();
  private   List<Integer>listidSousCategorieByIdEvenementFromWishlistsGetIdSousCategorieByIdEvenementFromWishlists=new ArrayList<>();
//private List<DemandeEvenement>  EvenementDisponibleByIdSousCategorie=new ArrayList<>();
           private  int idUtilisateur=1;
     private MyListener myListener ; 
     Parent fxml;
   
    @FXML
    private GridPane EvenementContainer;
    private AnchorPane ListEvenementClient;
    @FXML
    private AnchorPane ListEvenementClient1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // System.out.println("listidCategorieByIdEvenementFromWishlists  "+GetIdCategorieByIdEvenementFromWishlists(1));
      //  System.out.println(" GetIdSousCategorieByIdCategorie(int idUser)   "+ GetIdSousCategorieByIdCategorie(2));
        System.out.println("GetEvenementDisponibleByIdCategorieFromWishlists "+GetEvenementDisponibleByIdSousCategorieFromWishlists(1));
        
        GetListEvnementFavorable();
        GetListEvnement();
        // TODO
    }   
     public void GetListEvnementFavorable(){
         
     
           List<DemandeEvenement> evenements=GetEvenementDisponibleByIdSousCategorieFromWishlists(1);
           
           try{
    for(int i=0;i<evenements.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
    
             fxmlLoader.setLocation(getClass().getResource("EvenementFavorable.fxml"));
     
             HBox eventBox = fxmlLoader.load();
             EvenementFavorableController evenementFavorableController=fxmlLoader.getController();
                // System.out.println("evenements "+evenements.get(i));
             evenementFavorableController.setData(evenements.get(i));
             listEvenementFavorable.getChildren().add(eventBox);
               
           }
      
           }
           catch(IOException e){
    e.printStackTrace();
    
     }
    
}
      public void GetListEvnement(){
            List<DemandeEvenement> evenements=sde.GetDemandeEvenement();
                //     if (evenements.size() > 0) {
           // setChosenEvenement(evenements.get(0));
          
        //}
           int column=0;
           int row=1;
           try{
    for(int i=0;i<evenements.size();i++){
  
                FXMLLoader fxmlLoader = new FXMLLoader();
    
             fxmlLoader.setLocation(getClass().getResource("Evenement.fxml"));
     
             AnchorPane eventBox = fxmlLoader.load();
             EvenementController evenementController=fxmlLoader.getController();
            
             evenementController.setData(evenements.get(i));
          
           
            if(column==4)
            {
                column=0;
                ++row;
            }  
            EvenementContainer.add(eventBox, column++, row);
            GridPane.setMargin(eventBox, new Insets(10));
           }
      
           }
           catch(IOException e){
    e.printStackTrace();
    
     }
          
          
      
            }
           
           ///////////////////////////////////////////////////////////////////////////////////////////////////////
            public List GetIdEvenementFromWishlists(int idUser){
      listIdEvenementFromWishList.clear();
       //int id=1;
        Wishlist= sw.ReadWishlists(idUser);
       for(Wishlist w:Wishlist){
           int idEvent=w.getDemande_evenement_id();
           listIdEvenementFromWishList.add(idEvent);}
      return listIdEvenementFromWishList ;
  }
    
      public List GetIdCategorieByIdEvenementFromWishlists(int idUser){
     listidCategorieByIdEvenementFromWishlists.clear();
        listIdEvenementFromWishListMethodGetIdCategorieByIdEvenementFromWishlists=GetIdEvenementFromWishlists(idUser);
        for(int id:listIdEvenementFromWishListMethodGetIdCategorieByIdEvenementFromWishlists){
               
         listidCategorieByIdEvenementFromWishlists.add(ssc.GetIdCategorieByIdDemandeEvenement(id));     
      }
     return listidCategorieByIdEvenementFromWishlists;
  }
     
      
      public List GetIdSousCategorieByIdCategorie(int idUser){
          listSousCategorieByIdEvenementFromWishlists.clear();
          listIdEvenementFromWishListMethodGetIdCategorieByIdEvenementFromWishlists=GetIdEvenementFromWishlists(idUser);
        for(int id:listIdEvenementFromWishListMethodGetIdCategorieByIdEvenementFromWishlists){
         
            listSousCategorieByIdEvenementFromWishlists.add(ssc.GetIdSousCategorieByIdDemandeEvenement(id));     
        }
        return listSousCategorieByIdEvenementFromWishlists;
      }
       
           
           
         public List GetEvenementDisponibleByIdSousCategorieFromWishlists(int idUser){
       
         EvenementDisponibleByIdSousCategorie1.clear();
         EvenementDisponibleByIdSousCategorie.clear();
          listidSousCategorieByIdEvenementFromWishlistsGetIdSousCategorieByIdEvenementFromWishlists=GetIdCategorieByIdEvenementFromWishlists(idUser);
          
         for(int id:listidSousCategorieByIdEvenementFromWishlistsGetIdSousCategorieByIdEvenementFromWishlists){
             System.out.println(id);
               
               EvenementDisponibleByIdSousCategorie= sde.GetEvenementDisponibleByIdSousCategorie(id);
       for(DemandeEvenement de:EvenementDisponibleByIdSousCategorie){
            EvenementDisponibleByIdSousCategorie1.add(de);
       }      
       }
        
      return  EvenementDisponibleByIdSousCategorie1;
  }  
           
           
           
           
           
     
      
    //  public void AfficheEvenementDetail(Parent fxml){
     //     this.fxml=fxml;
     //     ListEvenementClient1.getChildren().removeAll();
     //        ListEvenementClient1.getChildren().setAll(fxml);
    //  }

    @FXML
    private void histoire(MouseEvent event) {
        
    }

    @FXML
    private void loisir(MouseEvent event) {
    }

    @FXML
    private void culture(MouseEvent event) {
    }
     
}
