/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Enterprise.Enterprise.EnterpriseType;
import business.Food.FoodCatalog;
import business.Role.Role;
import business.VolunteerJob.VolunteerJobList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author asahoho
 */
public class FoodBankEnterprise extends Enterprise {

    private String phone;
    private String email;
    private String address;
    private String about;
    private String serviceDescription;
    private VolunteerJobList volunteerJobs;
    private double balance;

    /**
     *
     * @param name
     */
    public FoodBankEnterprise(String name) {
        super(name, EnterpriseType.FoodBank);
        volunteerJobs = new VolunteerJobList();
        balance = 0;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public VolunteerJobList getVolunteerJobs() {
        return volunteerJobs;
    }

    @Override
    public Set<Type> getOrganizationTypes() {
        Set<Type> set = new HashSet<>();
        set.add(Type.Admin);
        set.add(Type.ManageFood);
        set.add(Type.Coordinator);
        set.add(Type.VolunteerService);
        return set;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
