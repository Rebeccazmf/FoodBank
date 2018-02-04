/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import business.EcoSystem;

/**
 *
 * @author 梦菲
 */
public class Employee extends User{
    private int id;

    public Employee() {
        id = EcoSystem.getInstance().getEmployeeID();
    }

    public int getId() {
        return id;
    }
    
        
}
