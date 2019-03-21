package com.garmin.java.academy.service;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.engine.MetricsCalculator;
import com.garmin.java.academy.io.ActivityRepository;

public class MetricsService {

	MetricsCalculator metricsCalculator;
	
    public MetricsService(ActivityRepository activityRepository)
    {
    	
    	metricsCalculator = new MetricsCalculator(activityRepository);
		System.out.println("Initialised MetricsService");
    }

    public void initializeAllMetrics() {
    }
    
    public void update(Activity activity){
    }
}
