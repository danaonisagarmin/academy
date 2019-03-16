package com.garmin.java.academy.service;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.io.ActivityRepository;

public class ActivityService {

    private ActivityRepository activityRepository;
	
    public ActivityService(ActivityRepository activityRepository) {
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
    
    public Activity getLatestActivity() throws Exception {
        return this.activityRepository.getActivities().stream()
            .max(Comparator.comparing(Activity::getDate))
            .get();
    }

}
