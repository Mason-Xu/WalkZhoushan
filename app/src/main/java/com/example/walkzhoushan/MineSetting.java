package com.example.walkzhoushan;

/**
 *
 * Created by Mason on 2017/12/12.
 */

public class MineSetting {

    private String settingName;
    private int userImageId;

    public MineSetting(String settingName, int userImageId) {
        this.settingName = settingName;
        this.userImageId = userImageId;
    }

    public String getSettingName() {
        return settingName;
    }

    public int getUserImageId() {
        return userImageId;
    }
}
