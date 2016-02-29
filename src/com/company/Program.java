package com.company;

import java.util.*;

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

        System.out.println("Buyer: ");
        Party buyer = inputParty();

        System.out.println("Seller: ");
        Party seller = inputParty();

        int MAX_PRODUCTS = 2;
        Map<Product, Double> products = new HashMap<>();
        while (products.size() < MAX_PRODUCTS){
            Product product = inputProduct();
            products.put(product, product.getQuantity());
        }

        Deal deal = new Deal(buyer, seller, products);
        return deal;
    }

    private Party inputParty() {
        String partyName = keyboard("    Party name");
        String partyAddress = keyboard("    Party address");

//        String[] keys = new String[2];
//        String[] values = new String[2];
//        for (int i = 0; i < values.length; i++) {
//            keys[i] = keyboard("Input key ");
//            values[i] = keyboard("Input value ");
//        }

        Party party = new Party();
        party.setName(partyName);
        party.setAddress(partyAddress);
//        party.setKeys(keys);
//        party.setValues(values);

        return party;
    }

    private Product inputProduct(){
        String title = keyboard("Product title");
        Product product = null;
        if (title.equals("photo")) {
            PhotoPr photo = new PhotoPr();
            photo.setName(title);

            String setMpixStr = keyboard("Mpix");
            photo.setMpix(Double.valueOf(setMpixStr));

            String setDigitalStr = keyboard("Digital");
            photo.setDigital(Boolean.valueOf(setDigitalStr));

            String priceStr = keyboard("Price");
            photo.setPrice(Double.valueOf(priceStr));

            String quantityStr = keyboard("Quantity");
            photo.setQuantity(Double.valueOf(quantityStr));

            product = photo;
        }
        else if (title.equals("shoes")) {
            BotPr bot = new BotPr();
            bot.setName(title);

            String sizeStr = keyboard("Shoes size");
            bot.setSize(Double.valueOf(sizeStr));

            String priceStr = keyboard("Price");
            bot.setPrice(Double.valueOf(priceStr));

            String quantityStr = keyboard("Quantity");
            bot.setQuantity(Double.valueOf(quantityStr));

            product = bot;
        }

        return product;
    }

    private void outputParty(Party party) {
        System.out.println(party.getName() + ": ");
        System.out.println(party.getAddress());
        System.out.println("--------------------");
    }

    private void output(){
        for (Deal deal : deals) {
            System.out.println("Date " + deal.getDate());
            System.out.println("  " + deal.getBuyer().getName() + " buys from " + deal.getSeller().getName());
//            System.out.println(PhDig);

            for (Map.Entry<Product, Double> entries:deal.getProducts().entrySet()) {
                Product product = entries.getKey();
                System.out.println("     " + product.getName() + " "
                        + product.getQuantity() + " x " +
                        product.getPrice() + " = " +
                        product.getPrice()*product.getQuantity());
            }



            System.out.println("Sum: " + deal.getSum());
            System.out.println("______________________");

            outputParty(deal.getBuyer());
            outputParty(deal.getSeller());
        }

    }
}
