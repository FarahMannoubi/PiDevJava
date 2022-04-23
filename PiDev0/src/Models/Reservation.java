/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author hedib
 */
public class Reservation {

    private int id, demande_event_id, utilisateur_id;
    private String date_res;
    private String heure_res;
    private float statut, cout;

    public Reservation(int id, int demande_event_id, int utilisateur_id, String date_res, String heure_res, float statut, float cout) {
        this.id = id;
        this.demande_event_id = demande_event_id;
        this.utilisateur_id = utilisateur_id;
        this.date_res = date_res;
        this.heure_res = heure_res;
        this.statut = statut;
        this.cout = cout;
    }

    public Reservation(int demande_event_id, int utilisateur_id, String date_res, String heure_res, float statut, float cout) {
        this.demande_event_id = demande_event_id;
        this.utilisateur_id = utilisateur_id;
        this.date_res = date_res;
        this.heure_res = heure_res;
        this.statut = statut;
        this.cout = cout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDemande_event_id() {
        return demande_event_id;
    }

    public void setDemande_event_id(int demande_event_id) {
        this.demande_event_id = demande_event_id;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public String getDate_res() {
        return date_res;
    }

    public void setDate_res(String date_res) {
        this.date_res = date_res;
    }

    public String getHeure_res() {
        return heure_res;
    }

    public void setHeure_res(String heure_res) {
        this.heure_res = heure_res;
    }

    public float getStatut() {
        return statut;
    }

    public void setStatut(float statut) {
        this.statut = statut;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public void modifierUser(Reservation res1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
