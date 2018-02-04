/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 梦菲
 */
public class FoodSupplierEnterprise extends Enterprise {

    public FoodSupplierEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.FoodSupplier);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public Set<Type> getOrganizationTypes() {
        Set<Type> set = new HashSet<>();
        set.add(Type.Admin);
        set.add(Type.ManageFood);
        return set;
    }

}
