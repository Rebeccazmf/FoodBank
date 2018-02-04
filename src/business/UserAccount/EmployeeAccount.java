/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.User.*;
import business.Role.Role;

/**
 *
 * @author 梦菲
 */
public class EmployeeAccount extends UserAccount {

    private Employee employee;
    private int workRequestHandled;
    private Role role;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void incrementReuqestHandled() {
        workRequestHandled++;
    }

    public int getReuqestHandled() {
        return workRequestHandled;
    }
}
