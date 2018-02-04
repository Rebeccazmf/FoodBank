/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.UserAccount.CustomerAccount;
import business.UserAccount.EmployeeAccount;

/**
 *
 * @author gundamwings
 */
public class GetHelpRequest extends WorkRequest {

    private EmployeeAccount receiver;
    private CustomerAccount sender;
    private String feedback;

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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
