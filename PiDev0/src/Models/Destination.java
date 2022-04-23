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
public class Destination {
    private int id;
    private String nom;
    private String description;
    private String image;
    private String adresse;
    private int num_tel;
    private String email;
    private int souscategorie;
    private int delegtion;
  
    
    public Destination(){}

    public Destination(int id, String nom, String description, String image, String adresse, int num_tel, String email, int souscategorie, int delegtion) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.souscategorie = souscategorie;
        this.delegtion = delegtion;
    }

    public Destination(String nom, String description, String image, String adresse, int num_tel, String email, int souscategorie, int delegtion) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.souscategorie = souscategorie;
        this.delegtion = delegtion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(int souscategorie) {
        this.souscategorie = souscategorie;
    }

    public int getDelegtion() {
        return delegtion;
    }

    public void setDelegtion(int delegtion) {
        this.delegtion = delegtion;
    }

    @Override
    public String toString() {
        return "Destination{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", image=" + image + ", adresse=" + adresse + ", num_tel=" + num_tel + ", email=" + email + ", souscategorie=" + souscategorie + ", delegtion=" + delegtion + '}';
    }
    
    
    }
    

