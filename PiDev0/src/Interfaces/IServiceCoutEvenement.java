/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.CoutEvenement;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceCoutEvenement {
    public List<CoutEvenement> GetCoutEvenement();
public void addCoutEvenement(CoutEvenement ce);
public void updateCoutEvenement(CoutEvenement ce);
public void deleteCoutEvenement(int id);
    
}
