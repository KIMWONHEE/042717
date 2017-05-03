package com.example.kim_wonhee.a170427;

/**
 * Created by kim_wonhee on 2017. 4. 27..
 */

public class Fruit {

    static int[] imagelist = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry,
            R.drawable.grape, R.drawable.kiwi, R.drawable.orange, R.drawable.watermelon};

    static int[] pricelist = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000};

    private String name = "";
    private String price = "";
    private int image = 0;

    public Fruit(String name, String price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public static int[] getImagelist() {
        return imagelist;
    }

    public static void setImagelist(int[] imagelist) {
        Fruit.imagelist = imagelist;
    }

    public static int[] gerPricelist() {
        return pricelist;
    }

    public static void setPricelist(int[] pricelist) {
        Fruit.pricelist = pricelist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
