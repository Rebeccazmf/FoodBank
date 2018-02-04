/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Food;

import business.Food.Food.FoodType;
import java.util.ArrayList;

/**
 *
 * @author 梦菲
 */
public class FoodCatalog {

    private ArrayList<Food> foodList;

    public FoodCatalog() {
        foodList = new ArrayList<>();
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public boolean hasFood(String foodName, FoodType foodType) {
        for (Food food : foodList) {
            if (food.getFoodName().toLowerCase().contains(foodName.toLowerCase()) && food.getFoodType() == foodType) {
                return true;
            }
        }
        return false;
    }

    public void addFood(Food f) {
        for (Food food : foodList) {
            if (food.getFoodName().equals(f.getFoodName()) && food.getFoodType() == f.getFoodType()) {
                food.setQuantity(food.getQuantity() + f.getQuantity());
                return;
            }
        }
        foodList.add(f);
    }

    public void createFood(String foodName, FoodType ft, int q) {
        Food f = new Food();
        f.setFoodName(foodName);
        f.setFoodType(ft);
        f.setQuantity(q);
        foodList.add(f);
    }
}
