package com.garmin.java.academy.services;

import java.util.List;
import java.util.Optional;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Metrics;
import com.garmin.java.academy.domain.RunningMetrics;
import com.garmin.java.academy.io.ActivityRepository;

public class RunningMetricsGenerator extends AbstractMetricsGenerator{

	public RunningMetricsGenerator(ActivityRepository activityRepository) {
		super(activityRepository);
		System.out.println("Initialised RunningMetricsGenerator");
	}

	@Override
	public Metrics generateMetrics(){

	    RunningMetrics runningMetrics = new RunningMetrics();
	    runningMetrics.setActivityType(ActivityType.RUNNING);
	    
	    List<Activity> allActivities = activityRepository.getActivities();
	    
        fillActivitiesCount(runningMetrics, allActivities);
        
        Double totalDistanceMeters = 
            allActivities
            .stream()
            .filter(a -> a.getType() == ActivityType.RUNNING)
            .map(a -> a.getDistance().getValue())
            .reduce(Double::sum)
            .get();
        
        Long totalTimeSec = 
            allActivities
            .stream()
            .filter(a -> a.getType() == ActivityType.RUNNING)
            .map(a -> a.getDuration())
            .reduce(Long::sum)
            .get();
        
        runningMetrics.setAverageSpeed((totalDistanceMeters/totalTimeSec) *3.6);
        runningMetrics.setAveragePace((totalTimeSec/60)/(totalDistanceMeters/1000));
	    
		return runningMetrics;
	}

    private void fillActivitiesCount(Metrics runningMetrics, List <Activity> allActivities)
    {
        int activitiesCount = 
            (int) allActivities.
                stream()
                .filter(a -> a.getType() == ActivityType.RUNNING)
                .count();

	    runningMetrics.setActivitiesCount(activitiesCount);
    }

}
