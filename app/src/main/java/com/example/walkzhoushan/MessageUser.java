package com.example.walkzhoushan;

/**
 * Created by Mason on 2017/12/11.
 */

public class MessageUser {

    private String name;
    private int userImageId;

    public MessageUser(String name, int userImageId) {
        this.name = name;
        this.userImageId = userImageId;
    }

    public String getName() {
        return name;
    }
    public int getUserImageId() {
        return userImageId;
    }
}
