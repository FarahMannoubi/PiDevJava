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
        private String Nom;
       private String Libelle;
       private int Prix;

    public Produit(int id, int avis_id, String description, String Nom, String Libelle, int Prix) {
        this.id = id;
        this.avis_id = avis_id;
        this.description = description;
        this.Nom = Nom;
        this.Libelle = Libelle;
        this.Prix = Prix;
    }

    public Produit(int avis_id, String description, String Nom, String Libelle, int Prix) {
        this.avis_id = avis_id;
        this.description = description;
        this.Nom = Nom;
        this.Libelle = Libelle;
        this.Prix = Prix;
    }
public Produit(String description) {
        this.description = description;
    }

    public Produit(int parseInt, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
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
         return "Produit{" + "id=" + id + ", avis_id=" + avis_id + ", description=" + description + ", Nom=" + Nom + ", Libelle=" + Libelle + ", Prix=" + Prix + '}';
    }
        
}
