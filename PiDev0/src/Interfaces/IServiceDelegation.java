/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Delegation;
import java.util.List;

/**
 *
 * @author Fatma
 */
public interface IServiceDelegation {
    public void CreateDelegation(Delegation d);
    public void UpdateDelegation(Delegation d);
    public void DeleteDelegation(int id );
    public List<Delegation> ReadDelegations();
    public Delegation FindSousDelegationByID(int id );
}
