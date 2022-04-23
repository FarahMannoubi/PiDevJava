/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Fatma
 */
public class Cout {
    private int id;
    private int destination_id;
    private int coutcategorie;
    private int prix;

    public Cout(int id, int destination_id, int coutcategorie, int prix) {
        this.id = id;
        this.destination_id = destination_id;
        this.coutcategorie = coutcategorie;
        this.prix = prix;
    }

    public Cout(int destination_id, int coutcategorie, int prix) {
        this.destination_id = destination_id;
        this.coutcategorie = coutcategorie;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(int destination_id) {
        this.destination_id = destination_id;
    }

    public int getCoutcategorie() {
        return coutcategorie;
    }

    public void setCoutcategorie(int coutcategorie) {
        this.coutcategorie = coutcategorie;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Cout{" + "id=" + id + ", destination_id=" + destination_id + ", coutcategorie=" + coutcategorie + ", prix=" + prix + '}';
    }
    
    
}
