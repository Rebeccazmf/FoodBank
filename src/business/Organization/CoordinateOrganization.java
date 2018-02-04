/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.CoordinateRole;
import business.Role.Role;
import business.Role.VolunteerServiceRole;
import java.util.ArrayList;

/**
 *
 * @author asahoho
 */
public class CoordinateOrganization extends Organization{
    public CoordinateOrganization() {
        super(Organization.Type.Coordinator.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();                
        roles.add(new CoordinateRole());
        return roles;
    }
}
