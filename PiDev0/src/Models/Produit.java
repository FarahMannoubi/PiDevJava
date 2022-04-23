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
public class Produit {
    
     private int id;
      private int avis_id;
       private String description;

    public Produit(int id, int avis_id, String description) {
        this.id = id;
        this.avis_id = avis_id;
        this.description = description;
    }

    public Produit(int avis_id, String description) {
        this.avis_id = avis_id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvis_id() {
        return avis_id;
    }

    public void setAvis_id(int avis_id) {
        this.avis_id = avis_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", avis_id=" + avis_id + ", description=" + description + '}';
    }
        
}
