/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Food.FoodCatalog;
import business.Organization.*;
import static java.lang.reflect.Array.set;
import java.util.Set;

/**
 *
 * @author 梦菲
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private FoodCatalog foods;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public enum EnterpriseType {

        FoodBank("FoodBank"),
        FoodSupplier("FoodSupplier");

        private EnterpriseType(String value) {
            this.value = value;
        }
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        foods = new FoodCatalog();
    }

    public FoodCatalog getFoods() {
        if (foods == null) {
            foods = new FoodCatalog();
        }
        return foods;
    }

    public void setFoods(FoodCatalog foods) {
        this.foods = foods;
    }

    public abstract Set<Organization.Type> getOrganizationTypes();

    @Override
    public String toString() {
        return getName();
    }

}
