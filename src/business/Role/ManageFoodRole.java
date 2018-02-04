/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Food.Food;
import business.Organization.ManageFoodOrganization;
import business.Organization.Organization;
import business.UserAccount.EmployeeAccount;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ManageFoodRole.ManageFoodWorkAreaJPanel;

/**
 *
 * @author asahoho
 */
public class ManageFoodRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManageFoodWorkAreaJPanel(userProcessContainer, (EmployeeAccount) account,
                (ManageFoodOrganization) organization, enterprise, EcoSystem.getInstance());
    }
}
