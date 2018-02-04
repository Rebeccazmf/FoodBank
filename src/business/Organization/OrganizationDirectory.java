/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.ManageFood.getValue())){
            organization = new ManageFoodOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Coordinator.getValue())){
            organization = new CoordinateOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.VolunteerService.getValue())){
            organization = new VolunteerServiceOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    public void deleteOrganization(Organization organization){
        organizationList.remove(organization);
    }
}
