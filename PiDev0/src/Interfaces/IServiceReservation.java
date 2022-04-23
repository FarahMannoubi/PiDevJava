/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.Reservation;
import java.util.List;


/**
 *
 * @author hedib
 */
public interface IServiceReservation {
      //CRUD
    public void CreateReservation(Reservation res);
    public void UpdateReservation(Reservation res);
    public void DeleteReservation(int id );

 /**
     *
     * @return
     */
    public List<Reservation> ReadReservations();
    

}
