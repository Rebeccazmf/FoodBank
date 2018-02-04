/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.ManageFoodRole;
import business.Role.Role;
import business.Role.VolunteerServiceRole;
import java.util.ArrayList;

/**
 *
 * @author asahoho
 */
public class VolunteerServiceOrganization extends Organization{
    
    public VolunteerServiceOrganization() {
        super(Organization.Type.VolunteerService.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();                
        roles.add(new VolunteerServiceRole());
        return roles;
    }
}
