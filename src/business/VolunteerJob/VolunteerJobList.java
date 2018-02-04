/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.VolunteerJob;

import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class VolunteerJobList {

    private ArrayList<VolunteerJob> volunteerJobList;

    public VolunteerJobList() {
        volunteerJobList = new ArrayList<>();
    }

    public ArrayList<VolunteerJob> getVolunteerJobList() {
        return volunteerJobList;
    }

    public VolunteerJob createVolunteerJob(String jobTitle, String description, String requirement) {
        VolunteerJob volunteerJob = new VolunteerJob();
        volunteerJob.setJobTitle(jobTitle);
        volunteerJob.setDescription(description);
        volunteerJob.setRequirement(requirement);
        volunteerJobList.add(volunteerJob);
        return volunteerJob;
    }

    public void setVolunteerJobList(ArrayList<VolunteerJob> volunteerJobList) {
        this.volunteerJobList = volunteerJobList;
    }

    public void deleteVolunteerJob(VolunteerJob vj) {
        volunteerJobList.remove(vj);
    }

}
