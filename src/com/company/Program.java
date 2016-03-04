package com.company;

import java.util.*;

public class Program {

    private Deal[] deals = new Deal[10];

    Map<Product, Double> products = new LinkedHashMap<>();

    String choice = null;

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

        //TODO product choosing
        int MAX_PRODUCTS = 4;
//        Map<Product, Double> products = new LinkedHashMap<>();
        while (products.size() < MAX_PRODUCTS){
            Product product = null;
            String msg = keyboard("Do you want to choose product from existing?\n Yes - 1, No - 2");
            if (msg.equals("1")) {
                if (products.size() == 0) {
                    System.out.println("Product base is empty! Enter new product");
                } else {
//                    for (int i = 0; i < products.size(); i++) {
//                        for (Map.Entry<Product, Double> entry:products.entrySet()) {
//                            product = entry.getKey();
//                            System.out.println(i + " - " + product.getName() + "\n");
//                        }
//                    }
//
//                    String choice = keyboard("Please input number of product");
//
//                    for (int k = 0; k < products.size(); k++) {
////                        String choice = keyboard("Please input number of product");
//                        for (Map.Entry<Product, Double> entry:products.entrySet()) {
//                            product = entry.getKey();
//                            System.out.println("getKey" + product);
//                            System.out.println(product);
//                            if (k == Integer.valueOf(choice)) {
//                                System.out.println(products + "before adding");
//                                System.out.println(product + "inside");
//                                products.put(product, product.getQuantity());
//                                System.out.println(products + "after adding");
//                                break;
//                            }
//                        }
//                    }


                }
            } else if (msg.equals("2")) {
                product = inputProduct();
                products.put(product, product.getQuantity());
            } else {
                System.out.println("Input is incorrect. Please retry");
            }

        }

        Deal deal = new Deal(buyer, seller, products);
        return deal;
    }

    private Product mapIterator() {
        int i = 0;
        Product product = null;
        for (Map.Entry<Product,Double> entry:products.entrySet()) {
            product = entry.getKey();
            System.out.println(i + " - " + product);
            if (i == Integer.valueOf(choice)) {
                return product;
            } else return null;
        }
        return product;
    }

    private Party inputParty() {
        String partyName = keyboard("    Party name");
        String partyAddress = keyboard("    Party address");

        int MAX_KV = 2;
        Map<String, String> kv = new HashMap<>(MAX_KV);
        for (int i = 0; i < MAX_KV; i++) {
            kv.put(inputKey(), inputValue());
        }

        Party party = new Party();
        party.setName(partyName);
        party.setAddress(partyAddress);
        party.setKeysValues(kv);

        return party;
    }

    private String inputKey() {
        String key = keyboard("    Key ");
        return key;
    }

    private String inputValue() {
        String value = keyboard("    Value ");
        return value;
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
        System.out.println(party.getKeysValues());
        System.out.println("--------------------");
    }

    private void output(){
        for (Deal deal : deals) {
            System.out.println("Date " + deal.getDate());
            System.out.println("  " + deal.getBuyer().getName() + " buys from " + deal.getSeller().getName());

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
