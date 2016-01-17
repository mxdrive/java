package com.company;

import java.util.Date;

/**
 * Created by snakehunter on 22.12.15.
 */
public class Deal {
    private Date date = new Date();
    private Party seller;
    private Party buyer;
    private Product[] products;

    public Deal(Party seller, Party buyer, Product[] products){
        date = new Date();
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;
    }
    //getSeller, getBuyer, getProducts

    public Date getDate() {
        return date;
    }

    public Party getBuyer(){
        return buyer;
    }
    public Party getSeller(){
        return seller;
    }
    public Product[] getProducts(){
        return products;
    }
    public double getSum(){
        double res = 0;
        for (Product product:products){
            res += product.getCost();
        }
        return res;
    }
}
