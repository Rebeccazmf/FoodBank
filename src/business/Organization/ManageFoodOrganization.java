/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.ManageFoodRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class ManageFoodOrganization extends Organization{
        public ManageFoodOrganization() {
        super(Organization.Type.ManageFood.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();                
        roles.add(new ManageFoodRole());
        return roles;
    }

}
