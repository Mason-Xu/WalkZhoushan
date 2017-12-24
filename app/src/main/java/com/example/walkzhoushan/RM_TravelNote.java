package com.example.walkzhoushan;

/**
 * Created by Mason on 2017/12/19.
 */

public class RM_TravelNote {
    private String name;

    private int imageId;

    public RM_TravelNote(String name, int imageId) {
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
