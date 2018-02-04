/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.User.Customer;
import business.UserAccount.EmployeeAccount;
import business.UserAccount.CustomerAccount;
import business.VolunteerJob.VolunteerJob;

/**
 *
 * @author asahoho
 */
public class ApplyVolunteerRequest extends WorkRequest {

    private VolunteerJob job;
    private String feedback;
    private EmployeeAccount receiver;
    private CustomerAccount sender;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public EmployeeAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(EmployeeAccount receiver) {
        this.receiver = receiver;
    }

    public CustomerAccount getSender() {
        return sender;
    }

    public void setSender(CustomerAccount sender) {
        this.sender = sender;
    }

    public VolunteerJob getJob() {
        return job;
    }

    public void setJob(VolunteerJob job) {
        this.job = job;
    }
    
    @Override
    public String toString() {
        return getStatus();
    }

}
