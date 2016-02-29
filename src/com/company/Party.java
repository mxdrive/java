package com.company;

import java.util.HashMap;
import java.util.Map;

public class Party {
    private String name;
    private String address;
    private Map<String, String> keysValues = new HashMap<>();

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

    public Map<String, String> getKeysValues() {
        return keysValues;
    }

    public void setKeysValues(Map<String, String> val)
    {
        this.keysValues = val;
    }

}
