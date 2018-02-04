/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.EcoSystem;
import business.UserAccount.*;
import java.util.Date;

/**
 *
 * @author 梦菲
 */
public abstract class WorkRequest {

    private String message;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private int id;

    public WorkRequest() {
        requestDate = new Date();
        id = EcoSystem.getInstance().getWorkRequestID();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public int getID() {
        return id;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
