/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.User.*;
import business.Role.Role;
import business.WorkQueue.WorkQueue;

/**
 *
 * @author 梦菲
 */
public abstract class UserAccount {

    private String username;
    private String password;
    private User user;
    
    private WorkQueue workQueue;
    

    public UserAccount() {
        workQueue = new WorkQueue();
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//  
//
//    public Employee getEmployee() {
//        return employee;
//    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
}
