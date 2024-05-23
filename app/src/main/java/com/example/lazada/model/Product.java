package com.example.lazada.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    public int id;
    public String title;
    public String description;
    public int price;
    public String thumbnail;
    public ArrayList<String> images;

    public Product(int id, String title, String description, int price, String thumbnail, ArrayList<String> images){
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
        this.images = images;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public ArrayList<String> getImages() {
        return images;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}

