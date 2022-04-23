/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fatma
 */
public class Connexion {
    
    private final static String URL = "jdbc:mysql://127.0.0.1:3306/pidevv0";
    final static String USERNAME = "root";
    final static String PWD = "";
    
    //Connection init
    static Connexion instance = null; //istance de la classe connexion
    private Connection cnx; // variable bech tamlelna la connexion avec la bd
    
    private Connexion() {
        
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD); // pilote eli bechyamlelna connexion bin bd ou projet java 
            //System.out.println("Connexion avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //getters
    public static Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
    
    
    
    
    
}