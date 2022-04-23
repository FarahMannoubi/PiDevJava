/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Utilisateur {
    private int id;
    private String login;
    private String password;
    private ArrayList<UserRole> Roles = new ArrayList<>();
    private String nom;
    private String prenom;
    private String date_naissance;
    private String email;
    private int num_tel;
    private String image;

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public Utilisateur() {
    }

    public Utilisateur(String login, String password, String nom, String prenom, String date_naissance, String email, int num_tel, String image) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
    }

    public Utilisateur(int id, String login, String password, String nom, String prenom, String date_naissance, String email, int num_tel, String image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.num_tel = num_tel;
        this.image = image;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<UserRole> getRoles() {
        return Roles;
    }

    public void setRoles(ArrayList<UserRole> Roles) {
        this.Roles = Roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", login=" + login + ", password=" + password + ", Roles=" + Roles + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", email=" + email + ", image=" + image + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
