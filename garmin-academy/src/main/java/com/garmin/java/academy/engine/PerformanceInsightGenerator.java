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
import com.garmin.java.academy.engine.manager.ActivityManager;

/**
 * Insights generated for performances 
 * Generated when the lastest activity has over the average performance
 * 
 * @author sticea
 *
 */
public class PerformanceInsightGenerator implements InsightGenerator
{
    ActivityManager activityManager;
    MetricsCache metricsCache;
    
    private static InsightType TYPE = InsightType.PERFORMANCE;
    private static String MESSAGE_OVER_AVERAGE = "Your latest {%s} activity has a better {%s} than your historical average. ";
    private static String MESSAGE_NEW_RECORD = "Your have recorded a new {%s} historical record with your last {%s} activity, Congratulations! ";
    
    @Override
    public List <Insight> generateAll() throws Exception 
    {
        List<Insight> newInsights = new LinkedList<>();

        newInsights.add(runnigInsightsSubRule((RunningActivity)activityManager.getLatestActivityForType(ActivityType.RUNNING)));
        newInsights.add(swimmingInsightsSubRule());
        return newInsights;
    }

    private Insight runnigInsightsSubRule(RunningActivity latestActivity) throws Exception
    {
        List<Activity> allRunningActivities = activityManager.getActivitiesOfType(ActivityType.RUNNING);
        
        Activity fastestActivity = allRunningActivities.stream()
                                    .map(obj -> (RunningActivity) obj)
                                    .max(Comparator.comparing(RunningActivity::getPace))
                                    .get();
        
        if(latestActivity.equals(fastestActivity))
        {                    
            return new Insight(String.format(MESSAGE_NEW_RECORD, "pace", "running"));
        }
        //TODO OVER_AVERAGE logic
        return null;
    }

    private Insight swimmingInsightsSubRule()
    {
        return null;
    }



    @Override
    public List <Insight> generateForNewActivity(Activity activity)
    {
        
        return null;
    }

}
