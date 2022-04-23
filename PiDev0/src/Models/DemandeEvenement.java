/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.scene.image.Image;

/**
 *
 * @author Fatma
 */
public class DemandeEvenement {
    private int id;
private String date_demande;
private String statut;
private String description_demande;
private String date_debutEvent;
private String date_finEvent;
private String heure_debutEvent;
private String heure_finEvent;
private String description_event;
private int capacite;
private int destination;
private String libelleEvenement;
private int utilisateur;
private String image;
private Image img;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }


 public DemandeEvenement(){}

    public DemandeEvenement(int destination,int utilisateur ,String date_demande, String statut, String description_demande,String date_debutEvent,String date_finEvent, String heure_debutEvent, String heure_finEvent, String description_event, int capacite,  String libelleEvenement) {
        this.date_demande = date_demande;
        this.statut = statut;
        this.description_demande = description_demande;
        this.date_debutEvent=
        this.date_finEvent = date_finEvent;
        this.heure_debutEvent = heure_debutEvent;
        this.heure_finEvent = heure_finEvent;
        this.description_event = description_event;
        this.capacite = capacite;
        this.destination = destination;
        this.libelleEvenement = libelleEvenement;
        this.utilisateur = utilisateur;
    }

    public DemandeEvenement(int destination,int utilisateur, String date_demande, String statut, String description_demande, String date_debutEvent, String date_finEvent, String heure_debutEvent, String heure_finEvent, String description_event, int capacite, String libelleEvenement, String image) {
this.destination = destination;  
this.utilisateur = utilisateur;
       
 this.date_demande = date_demande;
        this.statut = statut;
        this.description_demande = description_demande;
        this.date_debutEvent = date_debutEvent;
        this.date_finEvent = date_finEvent;
        this.heure_debutEvent = heure_debutEvent;
        this.heure_finEvent = heure_finEvent;
        this.description_event = description_event;
        this.capacite = capacite;
        
        this.libelleEvenement = libelleEvenement;
      
        this.image = image;
    }

    public DemandeEvenement(int id,int destination,int utilisateur, String date_demande, String statut, String description_demande, String date_debutEvent, String date_finEvent, String heure_debutEvent, String heure_finEvent, String description_event, int capacite, String libelleEvenement, String image) {
        this.id = id;
        this.date_demande = date_demande;
        this.statut = statut;
        this.description_demande = description_demande;
        this.date_debutEvent = date_debutEvent;
        this.date_finEvent = date_finEvent;
        this.heure_debutEvent = heure_debutEvent;
        this.heure_finEvent = heure_finEvent;
        this.description_event = description_event;
        this.capacite = capacite;
        this.destination = destination;
        this.libelleEvenement = libelleEvenement;
        this.utilisateur = utilisateur;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_demande() {
        return date_demande;
    }

    public void setDate_demande(String date_demande) {
        this.date_demande = date_demande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription_demande() {
        return description_demande;
    }

    public void setDescription_demande(String description_demande) {
        this.description_demande = description_demande;
    }

    public String getDate_debutEvent() {
        return date_debutEvent;
    }

    public void setDate_debutEvent(String date_debutEvent) {
        this.date_debutEvent = date_debutEvent;
    }

    public String getDate_finEvent() {
        return date_finEvent;
    }

    public void setDate_finEvent(String date_finEvent) {
        this.date_finEvent = date_finEvent;
    }

    public String getHeure_debutEvent() {
        return heure_debutEvent;
    }

    public void setHeure_debutEvent(String heure_debutEvent) {
        this.heure_debutEvent = heure_debutEvent;
    }

    public String getHeure_finEvent() {
        return heure_finEvent;
    }

    public void setHeure_finEvent(String heure_finEvent) {
        this.heure_finEvent = heure_finEvent;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String getLibelleEvenement() {
        return libelleEvenement;
    }

    public void setLibelleEvenement(String libelleEvenement) {
        this.libelleEvenement = libelleEvenement;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

     @Override
    public String toString() {
        return" id "+id+" idDestination "+destination+" idUtilisateur "+utilisateur+" Date demande "+ date_demande + " Statut " + statut + " Description Demande " + description_demande + " Date Debut Evenement "
 +date_debutEvent+" Date Fin Evenement "
 +date_finEvent+" heure Debut Evenement "+heure_debutEvent+" heure Fin Evenement "+heure_finEvent+" Description Evenement "+description_event+
" capacite "+capacite+" libelleEvenement "+libelleEvenement+" image "+image+"\n";
    }
    
}
