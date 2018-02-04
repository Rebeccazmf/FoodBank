/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.User.*;
import business.Role.SystemAdminRole;
import business.Role.SystemFoodDistrubtionRole;
import business.UserAccount.UserAccount;

/**
 *
 * @author 梦菲
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Employee employee = system.getUserDirectory().createEmployee("Mengfei", "Zhang");
        if (system.getUserAccountDirectory().checkIfUsernameIsUnique("s")) {
            system.getUserAccountDirectory().createEmployeeAccount("s", "s", employee, new SystemAdminRole());
        }

        employee = system.getUserDirectory().createEmployee("Bod", "Metcalf");
        if (system.getUserAccountDirectory().checkIfUsernameIsUnique("d")) {
            system.getUserAccountDirectory().createEmployeeAccount("d", "d", employee, new SystemFoodDistrubtionRole());
        }

        return system;
    }

}
