/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author manou
 */
public class Wishlist {
    private int id;
    private int utilisateur_id;
    private int demande_evenement_id;

    public Wishlist(int id, int utilisateur_id, int demande_evenement_id) {
        this.id = id;
        this.utilisateur_id = utilisateur_id;
        this.demande_evenement_id = demande_evenement_id;
    }

    public Wishlist() {
    }

    public Wishlist(int utilisateur_id, int demande_evenement_id) {
        this.utilisateur_id = utilisateur_id;
        this.demande_evenement_id = demande_evenement_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getDemande_evenement_id() {
        return demande_evenement_id;
    }

    public void setDemande_evenement_id(int demande_evenement_id) {
        this.demande_evenement_id = demande_evenement_id;
    }

    @Override
    public String toString() {
        return "Wishlist{" + "id=" + id + ", utilisateur_id=" + utilisateur_id + ", demande_evenement_id=" + demande_evenement_id + '}';
    }
    
    
}
