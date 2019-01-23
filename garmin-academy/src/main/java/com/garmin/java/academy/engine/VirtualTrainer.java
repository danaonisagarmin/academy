package com.garmin.java.academy.engine;

import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Insight;

public interface VirtualTrainer
{

    public List <Insight> generateAllInsights();

    /*
     * Removes outdated insights, creates new insigts based on the given activity
     */
    public void refreshInsightsBasedOnNewActivity(Activity activity);

    public List <Insight> getAllInsights();

    public List <Insight> getThreeRandomInsights();

}