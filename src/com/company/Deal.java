package com.company;

import java.util.Collection;
import java.util.Date;

/**
 * Created by snakehunter on 22.12.15.
 */
public class Deal {
    private Date date = new Date();
    private Party seller;
    private Party buyer;
    private Collection<Product> products;

    public Deal(Party buyer, Party seller, Collection<Product> products){
        date = new Date();
        this.buyer = buyer;
        this.seller = seller;
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
    public Collection<Product> getProducts(){
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
