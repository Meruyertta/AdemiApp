package com.example.musicapp.recycleviews.shoppingCart;

public class ModelCartFragment {
    int image;
    String name, price;

    public ModelCartFragment(int image, String name, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
