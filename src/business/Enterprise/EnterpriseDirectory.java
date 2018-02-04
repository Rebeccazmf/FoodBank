/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList();

    }

    //Create Enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.FoodBank) {
            enterprise = new FoodBankEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.FoodSupplier) {
            enterprise = new FoodSupplierEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }

    public void deleteEnterprise(Enterprise enterprise) {
        enterpriseList.remove(enterprise);
    }

    public boolean checkIfEnterpriseNameIsUnique(String name) {
        for (Enterprise ep : enterpriseList) {
            if (ep.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
    

}
