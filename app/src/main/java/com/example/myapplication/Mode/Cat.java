package com.example.myapplication.Mode;

import java.io.Serializable;
import java.util.List;

public class Cat implements Serializable {
    private String id;
    private String url;
    private int width;
    private int height;
    private List<DetaiCat> breeds;

    public Cat() {
    }

    public Cat(String id, String url, int width, int height, List<DetaiCat> breed) {
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
        breeds = breed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<DetaiCat> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<DetaiCat> breeds) {
        this.breeds = breeds;
    }
}
