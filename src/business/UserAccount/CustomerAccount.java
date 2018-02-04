/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.User.Customer;
import business.VolunteerJob.VolunteerJob;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 梦菲
 */
public class CustomerAccount extends UserAccount {

    private Customer customer;
    private ArrayList<DonateInfo> donateHistory;
    private Map<Date, VolunteerJob> volunteerJobHistory;

    public CustomerAccount() {
        super();
        donateHistory = new ArrayList<>();
        volunteerJobHistory = new HashMap<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<DonateInfo> getDonateHistory() {
        return donateHistory;
    }

    public Map<Date, VolunteerJob> getVolunteerJobHistory() {
        return volunteerJobHistory;
    }

}
