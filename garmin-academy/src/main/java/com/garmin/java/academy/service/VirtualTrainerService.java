package com.garmin.java.academy.service;

import java.util.LinkedList;
import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.engine.InsightGenerator;

public class VirtualTrainerService
{
    private List<InsightGenerator> insightGenerators;
    
    public VirtualTrainerService()
    {
        insightGenerators = new LinkedList <InsightGenerator>();
        System.out.println("Initialised VirtualTrainerService");
        
    }

    /*
     * Creates all posible insights based on existing activities and metrics
     */
    public List <Insight> generateAllInsights() throws Exception
    {
        return null;
    }

    /*
     * Removes outdated insights, creates new insigts based on the given activity
     */
    public void refreshInsightsBasedOnNewActivity(Activity activity) throws Exception
    {}

    /*
     * Returns all existing insights
     */
    public List <Insight> getAllInsights()
    {
        return null;
    }

    /*
     * Returns 3 random insights
     */
    public List <Insight> getThreeRandomInsights()
    {
        return null;
    }

}