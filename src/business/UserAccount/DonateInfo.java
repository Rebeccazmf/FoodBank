/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.UserAccount;

import business.EcoSystem;
import java.util.Date;

/**
 *
 * @author asahoho
 */
public class DonateInfo {
    private Date date;
    private double amount;
    private int donateID;
    private String foodBankName;
    
    public DonateInfo(){
        donateID = EcoSystem.getInstance().getDonateID();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDonateID() {
        return donateID;
    }

    public String getFoodBankName() {
        return foodBankName;
    }

    public void setFoodBankName(String foodBankName) {
        this.foodBankName = foodBankName;
    }
}
