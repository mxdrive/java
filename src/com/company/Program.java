package com.company;

import java.util.Scanner;

public class Program {

    private Deal[] deals = new Deal[10];

    public static void main(String[] args) {
        new Program().allActions();
    }

    private void allActions() {
        input();
        System.out.println("--------------\\--------------");
        output();
    }

    private String keyboard(String message) {
        System.out.print(message + ": ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private void input(){

        int MAX_DEALS = 2;
        deals = new Deal[MAX_DEALS];
        for (int i = 0; i < deals.length; i++) {
            System.out.print((i + 1) + " of " + deals.length + ": ");
            deals[i] = inputDeal();
        }

    }
    private Deal inputDeal() {

        String buyerName = keyboard("Buyer Name");
        Party buyer = new Party();
        buyer.setName(buyerName);

        String sellerName = keyboard("Seller Name");
        Party seller = new Party();
        seller.setName(sellerName);

        int MAX_PRODUCTS = 2;
        Product[] products = new Product[MAX_PRODUCTS];
        for (int i = 0; i < products.length; i++) {
            products[i] = inputProduct();
        }

        Deal deal = new Deal(buyer, seller, products);
        return deal;
    }

    private Product inputProduct(){
        String title = keyboard("Product title");
        //Product product = new Product();
        //product.setName(title);
        if (title.equals("photo")) {
            PhotoPr photo = new PhotoPr();
            photo.setName(title);

            String setMpixStr = keyboard("mpix");
            photo.setMpix(Double.valueOf(setMpixStr));

            String setDigitalStr = keyboard("digital");
            photo.setDigital(Boolean.valueOf(setDigitalStr));

            String priceStr = keyboard("price");
            photo.setPrice(Double.valueOf(priceStr));

            String quantityStr = keyboard("quantity");
            photo.setQuantity(Double.valueOf(quantityStr));
            return photo;

        }
        else if (title.equals("shoes")) {
            Product bot = new BotPr();
            bot.setName(title);

            String priceStr = keyboard("price");
            bot.setPrice(Double.valueOf(priceStr));

            String quantityStr = keyboard("quantity");
            bot.setQuantity(Double.valueOf(quantityStr));
            return bot;
        }


        //дописать else, выделить то, что ниже, в отдельный метод (или if/else в отдельный метод?),
        //вызывать из этого метода
        /*String priceStr = keyboard("price");
        product.setPrice(Double.valueOf(priceStr));

        String quantityStr = keyboard("quantity");
        product.setQuantity(Double.valueOf(quantityStr));
        return product;*/
        return null;
    }

    private void output(){
        for (Deal deal : deals) {
            System.out.println("Date " + deal.getDate());
            System.out.println("  " + deal.getBuyer().getName() + " buys from " + deal.getSeller().getName());

            for (Product product : deal.getProducts()) {
                System.out.println("     " + product.getName() + " "
                        + product.getQuantity() + " x " +
                        product.getPrice() + " = " +
                        product.getPrice()*product.getQuantity());
            }

            System.out.println("Sum: " + deal.getSum());
            System.out.println("______________________");
        }

    }
}
