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
public class Delegation {
    
    private int id;
    private String nom;
    private int gouvernorat;
    
    public Delegation(){}
    
    public Delegation(int id, String nom, int gouvernorat) {
        this.id = id;
        this.nom = nom;
        this.gouvernorat = gouvernorat;
    }

    public Delegation(String nom, int gouvernorat) {
        this.nom = nom;
        this.gouvernorat = gouvernorat;
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

    public int getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(int gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    @Override
    public String toString() {
        return "Delegation{" + "id=" + id + ", nom=" + nom + ", gouvernorat=" + gouvernorat + '}';
    }
    
 
    
    
    
}
