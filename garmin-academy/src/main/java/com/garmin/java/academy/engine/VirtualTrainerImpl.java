package com.garmin.java.academy.engine;

import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.engine.manager.ActivityManager;
import com.garmin.java.academy.engine.manager.MetricsManager;

public class VirtualTrainerImpl implements VirtualTrainer

{

    private List <Insight> trainerInsights;
    private MetricsManager metricsManager;
    private ActivityManager activityManager;

    @Override
    public List <Insight> generateAllInsights()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refreshInsightsBasedOnNewActivity(Activity activity)
    {
        // TODO Auto-generated method stub

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
