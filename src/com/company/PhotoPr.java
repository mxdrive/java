package com.company;

public class PhotoPr extends Product {

    private double mpix;
    private boolean digital;
    private static final int DIG_DISCOUNT = 20;

    public double getMpix() {
        return mpix;
    }

    public void setMpix (double nMpix) {
        this.mpix = nMpix;
    }

    public boolean getDigital() {
        return digital;
    }

    public void setDigital (boolean nDig) {
        this.digital = nDig;
    }

    protected int calcDiscount() {
        int def = super.calcDiscount();

        if (!digital) {
            def += DIG_DISCOUNT;
        }
        return def;
    }
}
