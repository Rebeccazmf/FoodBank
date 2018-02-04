/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.EcoSystem;
import business.User.*;
import business.Role.Role;
import business.UserAccount.UserAccountDirectory;
import business.VolunteerJob.VolunteerJobList;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private UserDirectory userDirectory;
    private static int count;
    private int organizationID;

    public enum Type {
        Admin("Admin Organization"),
        ManageFood("ManageFood Organization"),
        Coordinator("Coordinator Organization"),
        VolunteerService("Volunteer Organization");
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        userDirectory = new UserDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = count++;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public UserDirectory getUserDirectory() {
        return userDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }

}
