/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.User.*;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }

    public EmployeeAccount createEmployeeAccount(String username, String password, Employee employee, Role role) {
        EmployeeAccount employeeAccount = new EmployeeAccount();
        employeeAccount.setUsername(username);
        employeeAccount.setPassword(password);
        employeeAccount.setEmployee(employee);
        employeeAccount.setRole(role);
        userAccountList.add(employeeAccount);
        return employeeAccount;
    }

    public ArrayList<EmployeeAccount> getEmployeeAccountList() {
        ArrayList<EmployeeAccount> list = new ArrayList<>();
        for (UserAccount ua : userAccountList) {
            if (ua instanceof EmployeeAccount) {
                list.add((EmployeeAccount) ua);
            }
        }
        return list;
    }
    
    public ArrayList<CustomerAccount> getCustomerAccountList() {
        ArrayList<CustomerAccount> list = new ArrayList<>();
        for (UserAccount ua : userAccountList) {
            if (ua instanceof CustomerAccount) {
                list.add((CustomerAccount) ua);
            }
        }
        return list;
    }

    public CustomerAccount createCustomerAccount(String username, String password, Customer customer) {
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUsername(username);
        customerAccount.setPassword(password);
        customerAccount.setCustomer(customer);
        userAccountList.add(customerAccount);
        return customerAccount;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public void deleteEmployeeAccount(EmployeeAccount ea){
        userAccountList.remove(ea);
    }
}
