/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.VolunteerJob;

import business.EcoSystem;

/**
 *
 * @author 梦菲
 */
public class VolunteerJob {
    private int jobID;
    private String insitution;
    private String jobTitle;
    private String description;
    private String requirement;
    

    public VolunteerJob() {
        jobID = EcoSystem.getInstance().getVolunteerJobID();
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getInsitution() {
        return insitution;
    }

    public void setInsitution(String insitution) {
        this.insitution = insitution;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    
    @Override
    public String toString() {
        return jobTitle;
    }
}
