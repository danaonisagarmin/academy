package com.garmin.java.academy.engine;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.domain.InsightType;
import com.garmin.java.academy.domain.MetricsCache;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.domain.RunningMetrics;
import com.garmin.java.academy.domain.SwimmingActivity;
import com.garmin.java.academy.domain.SwimmingMetrics;
import com.garmin.java.academy.engine.manager.ActivityManager;

/**
 * Insights generated for performances 
 * Generated when the lastest activity of has over the average performance
 * 
 * @author sticea
 *
 */
public class PerformanceInsightGenerator implements InsightGenerator
{
    ActivityManager activityManager;
    MetricsCache metricsCache;
    
    private static InsightType TYPE = InsightType.PERFORMANCE;
    private static String MESSAGE_NEW_RECORD = "Your have recorded a new {%s} historical record with your last {%s} activity, Congratulations! ";
    private static String MESSAGE_OVER_AVERAGE = "Your latest {%s} activity has a better {%s} than your historical average. It's something";
    
    /**
     * Generates all possible insights based on the recorded activities 
     * To be used at startup
     */
    @Override
    public List <Insight> generateAll() throws Exception 
    {
        List<Insight> newInsights = new LinkedList<>();

        RunningActivity latestRunningActivity = (RunningActivity)activityManager.getLatestActivityForType(ActivityType.RUNNING);
        SwimmingActivity latestSwimmingActivity = (SwimmingActivity)activityManager.getLatestActivityForType(ActivityType.RUNNING);
        
        newInsights.add(runnigInsightPaceSubRule(latestRunningActivity));        
        newInsights.add(swimmingInsightsSwolfSubRule(latestSwimmingActivity));
        return newInsights;
    }
    
    /**
     * Generates all possible new insights based on the latest activity
     * To be used when a new activity is uploaded by the user
     */
    @Override
    public List <Insight> generateForNewActivity(Activity activity) throws Exception
    {
    	List<Insight> newInsightsForActivity = new LinkedList<>();
        switch (activity.getType()) {
		case RUNNING:
			newInsightsForActivity.add(runnigInsightPaceSubRule((RunningActivity)activity));
			break;
		case SWIMMING:
			newInsightsForActivity.add(swimmingInsightsSwolfSubRule((SwimmingActivity)activity));
			break;
		default:
			break;
		}
        return newInsightsForActivity;
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
        List<Activity> allRunningActivities = activityManager.getActivitiesOfType(ActivityType.RUNNING);
        
        Activity fastestActivity = allRunningActivities.stream()
                                    .map(obj -> (RunningActivity) obj)
                                    .max(Comparator.comparing(RunningActivity::getPace))
                                    .get();
        
        if(latestActivity.equals(fastestActivity))
        {                    
            return new Insight(String.format(MESSAGE_NEW_RECORD, "pace", "running"));
        }
        
        // check for better than average 
        RunningMetrics runnnigMetrics = (RunningMetrics) metricsCache.getMetricsForActivityType(ActivityType.RUNNING);
        
        if(latestActivity.getPace()>runnnigMetrics.getAvgPace())
        {                    
            return new Insight(String.format(MESSAGE_OVER_AVERAGE, "pace", "running"));
        }
        return null;
    }

    /**
     * 
     * Returns a new insight if the latest swimming activity has over average swolf
     *
     * @param latestActivity
     * @return
     * @throws Exception
     */
    private Insight swimmingInsightsSwolfSubRule(SwimmingActivity latestActivity) throws Exception
    {
    	// check for best record
        List<Activity> allSwimmingActivities = activityManager.getActivitiesOfType(ActivityType.RUNNING);
        
        Activity fastestActivity = allSwimmingActivities.stream()
                                    .map(obj -> (SwimmingActivity) obj)
                                    .max(Comparator.comparing(SwimmingActivity::getSwolf))
                                    .get();
        
        if(latestActivity.equals(fastestActivity))
        {                    
            return new Insight(String.format(MESSAGE_NEW_RECORD, "pace", "running"));
        }
        
        // check for better than average 
        SwimmingMetrics swimmingMetrics = (SwimmingMetrics) metricsCache.getMetricsForActivityType(ActivityType.SWIMMING);
        
        if(latestActivity.getSwolf()>swimmingMetrics.getAvgSwolf())
        {                    
            return new Insight(String.format(MESSAGE_OVER_AVERAGE, "pace", "running"));
        }
        
        return null;
    }
}
