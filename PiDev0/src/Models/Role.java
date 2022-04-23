/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Role {
     private ArrayList<UserRole> listUsers = new ArrayList<>();
    
    private int role_id;
    private String role_name;

    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }
    public Role() {
    }
    

    public ArrayList<UserRole> getListUsers() {
        return listUsers;
    }

    public void setListUsers(ArrayList<UserRole> listUsers) {
        this.listUsers = listUsers;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" + "listUsers=" + listUsers + ", role_id=" + role_id + ", role_name=" + role_name + '}';
    }
}
