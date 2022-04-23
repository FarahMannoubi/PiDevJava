/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Delegation;
import Models.Gouvernorat;
import Models.SousCategorie;
import java.util.List;


/**
 *
 * @author Fatma
 */
public interface IServiceGouvernorat {
    
     public List<Gouvernorat> ReadGouvernorat();
     public Gouvernorat FindGouveroratByID(int id );
     public Gouvernorat FindGouveroratByName(String nom);
      public List<Delegation> listDelegationsByGouvernorat(int id);

    
}
