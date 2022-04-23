/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author hedib
 */
public class Reclamation {
    private int id,reservation_id,etat;
    private String type,description,date_rec;

    public Reclamation(int id, int reservation_id, String type, String description, String date_rec,int etat) {
        this.id = id;
        this.reservation_id = reservation_id;
        this.etat = etat;
        this.type = type;
        this.description = description;
        this.date_rec = date_rec;
    }

    public Reclamation(int reservation_id,String type, String description, String date_rec,int etat) {
        this.reservation_id = reservation_id;
        this.etat = etat;
        this.type = type;
        this.description = description;
        this.date_rec = date_rec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(String date_rec) {
        this.date_rec = date_rec;
    }

   
    
}
