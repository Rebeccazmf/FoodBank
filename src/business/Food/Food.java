/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Food;

import business.EcoSystem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 梦菲
 */
public class Food {

    private int id;
    private String foodName;
    private FoodType foodType;
    private int quantity;

    public enum FoodType {
        BEVERAGE("beverage"),
        STAPLE("staple"),
        MEAT("meat"),
        VEGETABLE("vegetable"),
        FRUIT("fruit"),
        SNACK("snack");

        private final String typeName;

        FoodType(String typeName) {
            this.typeName = typeName;
        }

        @Override
        public String toString() {
            return typeName;
        }
    }

    public Food() {
        id = EcoSystem.getInstance().getFoodID();
        foodType = FoodType.BEVERAGE;
    }

    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return foodName;
    }
    
    public static List<FoodType> getFoodTypes() {
        List<FoodType> types = new ArrayList<>();
        types.add(FoodType.BEVERAGE);
        types.add(FoodType.STAPLE);
        types.add(FoodType.MEAT);
        types.add(FoodType.VEGETABLE);
        types.add(FoodType.FRUIT);
        types.add(FoodType.SNACK);
        return types;
    }
}
