/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Reclamation;
import java.util.List;

/**
 *
 * @author hedib
 */
public interface IServiceReclamation {
    //CRUD
    public void CreateReclamation(Reclamation rec);
    public void UpdateReclamation(Reclamation rec);
    public void DeleteReclamation(int id );

 /**
     *
     * @return
     */
    public List<Reclamation> ReadReclamations();

  
}
