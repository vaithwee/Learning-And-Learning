package com.example.vaith.listviewtest;

/**
 * Created by Vaith on 16/8/3.
 */
public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name, int imageId)
    {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName()
    {
        return this.name;
    }

    public int getImageId()
    {
        return this.imageId;
    }


}
