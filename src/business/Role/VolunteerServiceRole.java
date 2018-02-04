/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Enterprise.FoodBankEnterprise;
import business.Organization.Organization;
import business.Organization.VolunteerServiceOrganization;
import business.UserAccount.EmployeeAccount;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Volunteer.VolunteerWorkAreaJPanel;
import userinterface.VolunteerServiceRole.VolunteerServiceWorkAreaJPanel;

/**
 *
 * @author asahoho
 */
public class VolunteerServiceRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new VolunteerServiceWorkAreaJPanel(userProcessContainer, (EmployeeAccount)account, (VolunteerServiceOrganization)organization, (FoodBankEnterprise)enterprise);
    }
}
