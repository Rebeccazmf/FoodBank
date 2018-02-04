/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import business.EcoSystem;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class Customer extends User{

    private int id;
    
    public Customer() {
        id = EcoSystem.getInstance().getCustomerID();
    }

    public int getId() {
        return id;
    }

    private String emailAddress;
    private String phone;
    private String address;
    private String selfIntroduce;    

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelfIntroduce() {
        return selfIntroduce;
    }

    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce;
    }

}
