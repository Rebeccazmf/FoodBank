/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Food.FoodCatalog;
import business.Network.Network;
import business.Role.SystemAdminRole;
import business.Organization.Organization;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class EcoSystem extends Organization {

    private ArrayList<Network> networkList;
    private static EcoSystem business;
    private int foodID, orgID, employeeID, customerID, donateID, volunteerJobID, workRequestID;

    public int getFoodID() {
        return foodID++;
    }

    public int getOrgID() {
        return orgID++;
    }

    public int getEmployeeID() {
        return employeeID++;
    }

    public int getCustomerID() {
        return customerID++;
    }

    public int getDonateID() {
        return donateID++;
    }

    public int getVolunteerJobID() {
        return volunteerJobID++;
    }

    public int getWorkRequestID() {
        return workRequestID++;
    }

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public static void setInstance(EcoSystem system) {
        business = system;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public void deleteNetwork(Network network) {
        networkList.remove(network);
    }

    public boolean checkIfNetworknameIsUnique(String name) {
        for (Network nw : networkList) {
            if (nw.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
