package com.company;

/**
 * Created by snakehunter on 22.12.15.
 */
public abstract class Product {
    private double quantity;
    private double price;
    private String title;
    private static final int DISCOUNT = 10;

    public void setPrice(Double newP){
        this.price = newP;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(Double newQ){
        this.quantity = newQ;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getName() {
        return title;
    }

    public void setName(String newName){
        this.title = newName;
    }

    public double getCost(){
        double realCost = quantity * price;
        return realCost - (realCost * calcDiscount())/100;
    }

    protected int calcDiscount() {
        if (quantity > 10) return DISCOUNT;
        else return 0;
    }
}
