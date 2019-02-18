package com.garmin.java.academy.engine.manager;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.io.ActivityRepository;

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
    
    public List<Activity> getActivitiesOfType(ActivityType type) throws Exception{
        return this.activityRepository.getActivities().stream()
            .filter(s -> s.getType().equals(type))
            .collect(toList());
    }
    
    public Activity getLatestActivityForType(ActivityType type) throws Exception {
        return this.activityRepository.getActivities().stream()
            .filter(s -> s.getType().equals(type))
            .max(Comparator.comparing(Activity::getDate))
            .get();
    }

}
