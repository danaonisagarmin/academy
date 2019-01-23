package com.garmin.java.academy.engine.manager;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.io.ActivityRepository;

import java.util.List;

public class ActivityManager {

    private ActivityRepository activityRepository;

    public ActivityManager(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void add(Activity activity) throws Exception {
        activityRepository.add(activity);
    }

    public List<Activity> getActivities() throws Exception {
        return this.activityRepository.getActivities();
    }

}
