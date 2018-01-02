package com.example.walkzhoushan;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mason on 2018/1/2.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishyAll(){
        for(Activity activity:activities){  // 遍历
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
