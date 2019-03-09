package com.garmin.java.academy.engine.manager;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.io.ActivityRepository;

@Component
public class ActivityManager {

	@Autowired
    private ActivityRepository activityRepositoryImpl;

    public ActivityManager(ActivityRepository activityRepository) {
        this.activityRepositoryImpl = activityRepository;
    }

    public void add(Activity activity) throws Exception {
        activityRepositoryImpl.add(activity);
    }
    
    public List<Activity> getActivities() throws Exception {
        return this.activityRepositoryImpl.getActivities();
    }
    
    public List<Activity> getActivitiesOfType(ActivityType type) throws Exception{
        return this.activityRepositoryImpl.getActivities().stream()
            .filter(s -> s.getType().equals(type))
            .collect(toList());
    }
    
    public Activity getLatestActivityForType(ActivityType type) throws Exception {
        return this.activityRepositoryImpl.getActivities().stream()
            .filter(s -> s.getType().equals(type))
            .max(Comparator.comparing(Activity::getDate))
            .get();
    }
    
    public Activity getLatestActivity() throws Exception {
        return this.activityRepositoryImpl.getActivities().stream()
            .max(Comparator.comparing(Activity::getDate))
            .get();
    }

}
