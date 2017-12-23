package com.example.walkzhoushan;

/**
 * Created by Mason on 2017/12/19.
 */

public class TravelNote {
    private String name;

    private int imageId;

    public TravelNote(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
