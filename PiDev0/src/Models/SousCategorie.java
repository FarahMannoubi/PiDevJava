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
public class SousCategorie {
    private int id;
    private String libelle;
    private String description;
    private int    categorie;
    
    public SousCategorie(){}

    public SousCategorie(int id, String libelle, String description, int categorie) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.categorie = categorie;
    }

    public SousCategorie(String libelle, String description, int categorie) {
        this.libelle = libelle;
        this.description = description;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "SousCategorie{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + ", categorie=" + categorie + '}';
    }

   

}
