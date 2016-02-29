package com.company;

public class Party {
    private String name;
    private String address;
    private String[] keys;
    private String[] values;

    public String getName(){
        return name;
    }

    public void setName(String newVal){
        this.name = newVal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddr) {
        this.address = newAddr;
    }

    public  String[] getKeys() {
        return keys;
    }

    public String[] getValues() {
        return values;
    }

    public void setKeys(String[] key) {
        this.keys = key;
    }

    public void setValues(String[] value) {
        this.values = value;
    }
}
