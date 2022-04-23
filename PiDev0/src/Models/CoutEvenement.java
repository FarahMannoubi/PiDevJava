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
public class CoutEvenement {
    private int id ;
private int coutCtegorie;
private int demendeEvenement;
private int nbBillet;
private double prix;

    public CoutEvenement() {
    }

    public CoutEvenement(int id, int coutCtegorie, int demendeEvenement, int nbBillet, double prix) {
        this.id = id;
        this.coutCtegorie = coutCtegorie;
        this.demendeEvenement = demendeEvenement;
        this.nbBillet = nbBillet;
        this.prix = prix;
    }

    public CoutEvenement(int coutCtegorie, int demendeEvenement, int nbBillet, int prix) {
        this.coutCtegorie = coutCtegorie;
        this.demendeEvenement = demendeEvenement;
        this.nbBillet = nbBillet;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoutCtegorie() {
        return coutCtegorie;
    }

    public void setCoutCtegorie(int coutCtegorie) {
        this.coutCtegorie = coutCtegorie;
    }

    public int getDemendeEvenement() {
        return demendeEvenement;
    }

    public void setDemendeEvenement(int demendeEvenement) {
        this.demendeEvenement = demendeEvenement;
    }

    public int getNbBillet() {
        return nbBillet;
    }

    public void setNbBillet(int nbBillet) {
        this.nbBillet = nbBillet;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

      @Override
    public String toString() {
        return " cout evenemet "+ " CoutCategorie " + coutCtegorie + " demendeEvenement " + demendeEvenement + " nbBillet " + nbBillet + " prix " +prix+"";
    }
    
}
