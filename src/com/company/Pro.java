//package com.company;
//
//import java.util.Scanner;
//
///**
// * Created by snakehunter on 22.12.15.
// */
//public class Pro {
//
//    private Deal[] deals;
//
//    public static void main(String[] args) {
//        new Pro().allActions();
//    }
//
//    private void allActions() {
//        input();
//        System.out.println("-----------------------------");
//        output();
//    }
//
//    private String keyboard(String message) {
//        System.out.print(message + ": ");
//        Scanner scan = new Scanner(System.in);
//        return scan.next();
//    }
//
//    private Deal input(){
//
//        int MAX_DEALS = 2;
//        deals = new Deal[MAX_DEALS];
//
//        String buyerName = keyboard("Buyer Name");
//        Party buyer = new Party();
//        buyer.setName(buyerName);
//
//        String sellerName = keyboard("Seller Name");
//        Party seller = new Party();
//        seller.setName(sellerName);
//
//        int MAX_PRODUCTS = 2;
//        Product[] products = new Product[MAX_PRODUCTS];
//        for (int i = 0; i < products.length; i++) {
//            products[i] = inputProduct();
//        }
//
//        return new Deal(buyer, seller, products);
//    }
//
//    private Product inputProduct(){
//        String title = keyboard("Product title");
//        Product product = new Product();
//        product.setName(title);
//        String priceStr = keyboard("price");
//        product.setPrice(Double.valueOf(priceStr));
//        String quantityStr = keyboard("quantity");
//        product.setQuantity(Double.valueOf(quantityStr));
//        return product;
//    }
//
//    private void output(){
//        for (Deal deal : deals) {
//            System.out.println("Date " + deal.getDate());
//            System.out.println("  " + deal.getBuyer().getName() + " buys from " + deal.getSeller().getName());
//
//            for (Product product : deal.getProducts()) {
//                System.out.println("     " + product.getName() + " "
//                        + product.getQuantity() + " x " +
//                        product.getPrice() + " = " +
//                        product.getPrice()*product.getQuantity());
//            }
//
//            System.out.println("Sum: " + deal.getSum());
//            System.out.println("______________________");
//        }
//
//    }
//}
