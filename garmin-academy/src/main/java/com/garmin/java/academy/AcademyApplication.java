package com.garmin.java.academy;

import com.garmin.java.academy.io.ActivityRepository;
import com.garmin.java.academy.io.ActivityRepositoryJsonImpl;
import com.garmin.java.academy.services.ActivityService;
import com.garmin.java.academy.services.InsightService;
import com.garmin.java.academy.services.MetricsService;

public class AcademyApplication {
	
	private ActivityService activityService;
	private MetricsService metricsService;
	private InsightService insightService;
	public AcademyApplication() throws Exception {
		
		ActivityRepository activityRepository = new ActivityRepositoryJsonImpl();
		
		activityService = new ActivityService(activityRepository);
		metricsService = new MetricsService(activityRepository);
		insightService = new InsightService();
		
		System.out.println("Initialised AcademyApplication");
	}
	
	

}
