/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.DemandeEvenement;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceDemandeEvenement {
    public List<DemandeEvenement> GetDemandeEvenement();
public List<DemandeEvenement> GetDemandeEvenementById(DemandeEvenement de);
public List<DemandeEvenement> GetDemandeEvenementByIdUtilisateur(DemandeEvenement de);
public List<DemandeEvenement> GetEvenementDisponible();
public List<DemandeEvenement> GetDemandeEvenementEnAttante();
public List<DemandeEvenement> GetDemandeEvenementByIdDestination(DemandeEvenement de);

public void addDemandeEvenement(DemandeEvenement de);
public void updateDemandeEvenement(DemandeEvenement de);
public void updateDemandeEvenementToAccepter(DemandeEvenement de);
public void updateDemandeEvenementToRefuser(DemandeEvenement de);
public void deleteDemandeEvenement(int id);
    
}
