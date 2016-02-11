package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Program {

    private Deal[] deals = new Deal[10];
//    Product bot = new BotPr();
//    PhotoPr photo = new PhotoPr();
//    private double PhMpix;
//    private String PhDig;

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

//        String buyerName = keyboard("Buyer Name");
//        Party buyer = new Party();
//        buyer.setName(buyerName);
//        String bAddr = keyboard("Buyer address");
//        buyer.setAddress(bAddr);
//
//        String sellerName = keyboard("Seller Name");
//        Party seller = new Party();
//        seller.setName(sellerName);
//        String sAddr = keyboard("Seller address");
//        seller.setAddress(sAddr);
        System.out.println("Buyer: ");
        Party buyer = inputParty();

        System.out.println("Seller: ");
        Party seller = inputParty();

        int MAX_PRODUCTS = 2;
        Collection<Product> products = new LinkedList<>();
        while (products.size() < MAX_PRODUCTS){
        //for (Product product:products) {
            products.add(inputProduct());
        }

        Deal deal = new Deal(buyer, seller, products);
        return deal;
    }

    private Party inputParty() {
        String partyName = keyboard("    Party name");
        String partyAddress = keyboard("    Party address");

        String[] keys = new String[2];
        String[] values = new String[2];
        for (int i = 0; i < values.length; i++) {
            keys[i] = keyboard("Input key ");
            values[i] = keyboard("Input value ");
        }

        Party party = new Party();
        party.setName(partyName);
        party.setAddress(partyAddress);
        party.setKeys(keys);
        party.setValues(values);

        return party;
    }

    private Product inputProduct(){
        String title = keyboard("Product title");
        //Product product = new Product();
        //product.setName(title);
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

            // output testing. Хуйня. Не работает
            //PhDig = setDigitalStr;
            //PhMpix = photo.getMpix();
            product = photo;
            //return photo;
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

            //output testing
            //PhDig = Boolean.parseBoolean(null);
            product = bot;
            //return bot;
        }


        //дописать else, выделить то, что ниже, в отдельный метод (или if/else в отдельный метод?),
        //вызывать из этого метода
        /*String priceStr = keyboard("price");
        product.setPrice(Double.valueOf(priceStr));

        String quantityStr = keyboard("quantity");
        product.setQuantity(Double.valueOf(quantityStr));*/
        return product;
        //return null;
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

            for (Product product : deal.getProducts()) {

//                //переделать. С блядскими ифами аще нихуя не выводится почему-то
//                if (PhDig == "true") {
//                    System.out.println("Photo is digital");
//                }else if (PhDig == "false"){
//                    System.out.println("Photo isn't digital");
//                }else {
//                }

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
