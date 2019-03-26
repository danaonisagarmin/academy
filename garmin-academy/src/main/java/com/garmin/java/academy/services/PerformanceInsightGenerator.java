package com.garmin.java.academy.services;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.domain.RunningMetrics;
import com.garmin.java.academy.io.ActivityRepository;
import com.garmin.java.academy.io.MetricsRepository;

public class PerformanceInsightGenerator implements InsightGenerator {

	private ActivityRepository activityRepository;
	private MetricsRepository metricsRepository;

    private static String MESSAGE_NEW_RECORD = "For your last %s activity your %s was %s. You have achieved a new %s historical record, Congratulations! ";
    private static String MESSAGE_OVER_AVERAGE = "For your last %s activity your %s was %s. This is a better %s than your historical average. It's something!";
    
	public PerformanceInsightGenerator(ActivityRepository activityRepository, MetricsRepository metricsRepository) {
		this.activityRepository = activityRepository;
		this.metricsRepository = metricsRepository;
		System.out.println("Initialised PerformanceInsightGenerator");
	}

	
	@Override
	public List<Insight> generateInsights() {
	    
        List<Insight> newInsights = new LinkedList<>();

        RunningActivity latestRunningActivity = (RunningActivity)activityRepository.getLatestActivityForType(ActivityType.RUNNING);
        
        try
        {
            newInsights.add(runnigInsightPaceSubRule(latestRunningActivity));
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }     
        
        return newInsights;
	}
	
    /**
     * Returns a new insight if the latest activity has over average pace
     * 
     * @param latestActivity
     * @return
     * @throws Exception
     */
    private Insight runnigInsightPaceSubRule(RunningActivity latestActivity) throws Exception
    {
        // check for best record
        List<Activity> allActivities = activityRepository.getActivities();
        
        Activity fastestActivity = allActivities.stream()
                                    .filter(a -> a.getType() == ActivityType.RUNNING)
                                    .map(obj -> (RunningActivity) obj)
                                    .min(Comparator.comparing(RunningActivity::getPace))
                                    .get();
        
        if(latestActivity.equals(fastestActivity))
        {                    
            return new Insight(String.format(MESSAGE_NEW_RECORD, "running", "pace", latestActivity.getPace(), "pace"));
        }
        
        // check for better than average 
        RunningMetrics runnnigMetrics = (RunningMetrics) metricsRepository.getAllMetrics().stream().filter(a -> a.getActivityType() == ActivityType.RUNNING).findFirst().get();
        
        if(latestActivity.getPace()>runnnigMetrics.getAveragePace())
        {                    
            return new Insight(String.format(MESSAGE_OVER_AVERAGE, "running", "pace", latestActivity.getPace(), "pace"));
        }
        return null;
    }

}
