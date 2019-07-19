package com.hexaware.canteenmanagement.model;
import java.util.Objects;

public class Menu {
    private int foodId;
    private String foodName;
    private int quantity;
    private int price;
    public Menu(final int foodId, final String foodName, final int quantity, final int price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    Menu menu = (Menu) obj;
        if (Objects.equals(foodId, menu.foodId) && Objects.equals(foodName, menu.foodName)
            && Objects.equals(quantity, menu.quantity) && Objects.equals(price, menu.price)) {
        return true;
    }
    return false;
  }
    @Override
    public final int hashCode() {
        return Objects.hash(foodId, foodName, quantity, price);
    }
    public int getFoodId() {
        return foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getPrice(){
        return price;
    }
    public void setFoodId(final int foodId) {
        this.foodId = foodId;
    }
    public void setFoodName(final String foodName) {
        this.foodName = foodName;
    }
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(final int price) {
        this.price = price;
    }
}