package com.garmin.java.academy;

import com.garmin.java.academy.io.ActivityRepository;
import com.garmin.java.academy.io.ActivityRepositoryJsonImpl;
import com.garmin.java.academy.service.ActivityService;
import com.garmin.java.academy.service.MetricsService;
import com.garmin.java.academy.service.VirtualTrainerService;

public class AcademyApplication
{
    private ActivityService activityService;
    private MetricsService metricsService;
    private VirtualTrainerService virtualTrainerService;
    public AcademyApplication() throws Exception
    {
        ActivityRepository activityRepository = new ActivityRepositoryJsonImpl();
        activityRepository.loadActivities();
        
        activityService = new ActivityService(activityRepository);
        metricsService = new MetricsService();
        virtualTrainerService = new VirtualTrainerService();
    }
}
