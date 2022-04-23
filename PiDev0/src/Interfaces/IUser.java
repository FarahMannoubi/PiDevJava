/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Utilisateur;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author ASUS
 */
public interface IUser {
    public void addUser(Utilisateur u);
   // public boolean login(String email,String password)throws Exception ;
    public List<Utilisateur> afficherUsers();
    public void DeleteUser(int id);
    //Update 
    public void modifierUser (Utilisateur u);
    //Login
    public int getId() throws SQLException ;
    //public void UpdatePassword(String email, String password)throws Exception;
    public Utilisateur getByEmail(String email );
}
