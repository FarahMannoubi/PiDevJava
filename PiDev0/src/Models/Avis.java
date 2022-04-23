/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author dell
 */
public class Avis {
     private int id;
    private String commentaire;
    private float note;
    private int demande_event_id;
    private int utilisateur_id;
    

    public Avis(int id, String commentaire, float note, int demandeEvent, int utilisateur) {
        this.id = id;
        this.commentaire = commentaire;
        this.note = note;
        this.demande_event_id = demandeEvent;
        this.utilisateur_id = utilisateur;
        
    }

    public Avis(String commentaire, float note, int demandeEvent, int utilisateur) {
        this.commentaire = commentaire;
        this.note = note;
        this.demande_event_id = demandeEvent;
        this.utilisateur_id = utilisateur;
        
    }

    public Avis() {
       
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getDemande_event_id() {
        return demande_event_id;
    }

    public void setDemandeEvent(int demandeEvent) {
        this.demande_event_id = demande_event_id;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", commentaire=" + commentaire + ", note=" + note + ", demande_event_id=" + demande_event_id + ", utilisateur_id=" + utilisateur_id + '}';
    }

     
}

    

