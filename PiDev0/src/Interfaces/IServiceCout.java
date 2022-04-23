/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Cout;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceCout {
    public void CreateCout(Cout c);
    public List<Cout> ReadCouts();
    public void UpdateCout(Cout c);
    public void DeleteCout(int id ); 
    public Cout FindCoutByID(int id );
    
}
