package com.garmin.java.academy.engine;

import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Insight;

public interface VirtualTrainer
{

    /*
     * Creates all posible insights based on existing activities and metrics
     */
    public List <Insight> generateAllInsights();

    /*
     * Removes outdated insights, creates new insigts based on the given activity
     */
    public void refreshInsightsBasedOnNewActivity(Activity activity);

    /*
     * Returns all existing insights
     */
    public List <Insight> getAllInsights();

    /*
     * Returns 3 random insights
     */
    public List <Insight> getThreeRandomInsights();

}