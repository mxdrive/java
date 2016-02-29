package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Deal {
    private Date date = new Date();
    private Party seller;
    private Party buyer;
    private Map<Product, Double> products = new HashMap<>();

    public Deal(Party buyer, Party seller, Map<Product, Double> products){
        date = new Date();
        this.buyer = buyer;
        this.seller = seller;
        this.products = products;
    }

    public Date getDate() {
        return date;
    }

    public Party getBuyer(){
        return buyer;
    }
    public Party getSeller(){
        return seller;
    }
    public Map<Product, Double> getProducts(){
        return products;
    }

    public double getSum(){
        double res = 0;
        for (Map.Entry<Product, Double>entry:products.entrySet()){
            res += entry.getKey().getCost();
        }
        return res;
    }
}
