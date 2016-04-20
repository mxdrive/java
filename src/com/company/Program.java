package com.company;

import java.util.*;

public class Program {

    //private Deal[] deals = new Deal[10];
    private Collection<Deal> deals = new LinkedList<>();
    //сделал product приватной глобальной переманной, покомментил, где он был локальным. Вроде, все ок
    private Product product = null;

    private LinkedList<PhotoPr> photos = new LinkedList<>();
    private LinkedList<BotPr> shoes = new LinkedList<>();
    private Product localProduct = null;

//    Map<Product, Double> products = new LinkedHashMap<>();
    private LinkedList<Product> prods = new LinkedList<>();

    private int choice = 0;

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

        while (deals.size() < MAX_DEALS) {
            Deal deal = inputDeal();
            deals.add(deal);
            System.out.println("getProducts - " + deal.getProducts());
            System.out.println("quantity of deals - " + deals);
            System.out.println("quantity of prods - " + prods);
        }

    }
    private Deal inputDeal() {

        System.out.println("Buyer: ");
        Party buyer = inputParty();

        System.out.println("Seller: ");
        Party seller = inputParty();

        Deal deal = new Deal(buyer, seller);

        int MAX_PRODUCTS = 4;
        while (deal.getProducts().size() < MAX_PRODUCTS){

            String msg = keyboard("Do you want to choose product from existing?\n Yes - 1, No - 2");
            if (msg.equals("1")) {
                if (prods.size() == 0) {
                    System.out.println("Product base is empty! Enter new product");
                } else {
                    mapIterator();
                    choice = Integer.valueOf(keyboard("Please input number of product"));
                    product = mapIteratorChoice();
                    String quantity = keyboard(" Input quantity");
                    localProduct.setQuantity(Double.valueOf(quantity));
                    deal.getProducts().put(localProduct, Double.valueOf(quantity));
                    System.out.println(deal.getProducts());
                }
            } else if (msg.equals("2")) {
                product = inputProduct();
                prods.add(product);
                deal.getProducts().put(product, product.getQuantity());
            } else {
                System.out.println("Input is incorrect. Please retry");
            }

        }

        return deal;
    }

    private void mapIterator() {

        for (int i = 0; i < prods.size(); i++) {
            System.out.println(i + " - " + prods.get(i));
        }
    }

    private Product mapIteratorChoice() {

        for (int i = 0; i < prods.size(); i++) {
            product = prods.get(i);
            if (i == choice) {
                for (int p = 0; p < photos.size(); p++) {
                    PhotoPr localProductPhoto = photos.get(p);
                    if (localProductPhoto.equals(product)) {
                        PhotoPr local = new PhotoPr();
                        local.setName(localProductPhoto.getName());
                        local.setMpix(localProductPhoto.getMpix());
                        local.setDigital(localProductPhoto.getDigital());
                        local.setPrice(localProductPhoto.getPrice());
                        localProduct = local;
                        photos.add(local);
                    }
                }
                for (int s = 0; s < shoes.size(); s++) {
                    BotPr localProductBot = shoes.get(s);
                    if (localProductBot.equals(product)) {
                        BotPr local = new BotPr();
                        local.setName(localProductBot.getName());
                        local.setSize(localProductBot.getSize());
                        local.setPrice(localProductBot.getPrice());
                        localProduct = local;
                        shoes.add(local);
                    }
                }
                prods.add(product);
            }
        }
        System.out.println("localProduct - " + localProduct);
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

            photos.add(photo);

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

            shoes.add(bot);

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
