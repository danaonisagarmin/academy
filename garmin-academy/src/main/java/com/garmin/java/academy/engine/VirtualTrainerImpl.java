package com.garmin.java.academy.engine;

import java.util.List;
import java.util.stream.Collectors;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.engine.manager.ActivityManager;
import com.garmin.java.academy.engine.manager.MetricsManager;

public class VirtualTrainerImpl implements VirtualTrainer

{
    private List <Insight> trainerInsights;
    private List<InsightGenerator> insightGenerators;

    private MetricsManager metricsManager;
    private ActivityManager activityManager;
    

    @Override
    public List <Insight> generateAllInsights() throws Exception
    {
        for(InsightGenerator generator:insightGenerators)
        {
            trainerInsights.addAll(generator.generateAll());
        }
        return trainerInsights;
    }

    @Override
    public void refreshInsightsBasedOnNewActivity(Activity activity) throws Exception
    {
        //remove invalid insights
        List<Insight> invalidInsights = trainerInsights.stream()
                .filter(i -> isInsightInvalidatedByNewActivity(i, activity))
                .collect(Collectors.toList());
        
        trainerInsights.removeAll(invalidInsights);
        
        //create new ones
        for(InsightGenerator generator:insightGenerators)
        {
            trainerInsights.addAll(generator.generateForNewActivity(activity));
        }
    }

    private boolean isInsightInvalidatedByNewActivity(Insight insight, Activity activity)
    {
        List <ActivityType> influencedByTypes= insight.getInfluencedByType();
        if(influencedByTypes.contains(activity.getType()))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public List <Insight> getAllInsights()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List <Insight> getThreeRandomInsights()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public List <Insight> getTrainerInsights()
    {
        return trainerInsights;
    }

    public void setTrainerInsights(List <Insight> trainerInsights)
    {
        this.trainerInsights = trainerInsights;
    }

    public MetricsManager getMetricsManager()
    {
        return metricsManager;
    }

    public void setMetricsManager(MetricsManager metricsManager)
    {
        this.metricsManager = metricsManager;
    }

    public ActivityManager getActivityManager()
    {
        return activityManager;
    }

    public void setActivityManager(ActivityManager activityManager)
    {
        this.activityManager = activityManager;
    }

}
