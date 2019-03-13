    package com.garmin.java.academy.engine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Distance;
import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.domain.MeasurementUnit;
import com.garmin.java.academy.domain.MetricsCache;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.domain.RunningMetrics;
import com.garmin.java.academy.domain.StrokeType;
import com.garmin.java.academy.domain.SwimmingActivity;
import com.garmin.java.academy.domain.SwimmingMetrics;
import com.garmin.java.academy.engine.manager.ActivityManager;
import com.garmin.java.academy.io.impl.ActivityRepositoryImpl;

public class PerformanceInsightGeneratorTest
{
    
    ActivityManager activityManager;
    MetricsCache metricsCache; 
    PerformanceInsightGenerator performanceInsightGenerator; 
    
    @Test
    public void validateGenerateAll() throws Exception
    {
        activityManager =new ActivityManager(new ActivityRepositoryImpl());
        metricsCache = new MetricsCache();
        performanceInsightGenerator = new PerformanceInsightGenerator();
        performanceInsightGenerator.setActivityManager(activityManager);
        performanceInsightGenerator.setMetricsCache(metricsCache);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // create running activities
        RunningActivity running_1 = createRunning(format.parse("2019-01-01 20:00:00"),
            new Distance(1000f, MeasurementUnit.METERS), 10000l, 100, "First run", 6.01, 0.1);
        RunningActivity running_2 = createRunning(format.parse("2019-01-05 20:00:00"),
            new Distance(4000f, MeasurementUnit.METERS), 40000l, 90, "Second run", 5.81, 0.2);
        RunningActivity running_3 = createRunning(format.parse("2019-01-13 20:00:00"),
            new Distance(5000f, MeasurementUnit.METERS), 50000l, 80, "Third run", 6.41, 0.3);
        
        activityManager.add(running_1);
        activityManager.add(running_2);
        activityManager.add(running_3);
        
        List<Activity> runningActivities = new LinkedList<>();
        runningActivities.add(running_1);
        runningActivities.add(running_2);
        runningActivities.add(running_3);
        
        // create running stats
        RunningMetrics runningMetrics = new RunningMetrics();
        runningMetrics.setActivitiesNumber(3);
        runningMetrics.setAvgDistance(2300L);
        runningMetrics.setAvgPace(6.21f);
        runningMetrics.setTotalElevation(240);
        
        metricsCache.calculateMetrics(runningActivities);
        metricsCache.addMetric(ActivityType.RUNNING, runningMetrics);
        
        // create swimming activities
        SwimmingActivity swimming_1 = createSwimming(format.parse("2019-01-21 20:00:00"),
            new Distance(1000f, MeasurementUnit.METERS), 200l, 20, "First swim", StrokeType.CRAWL);
        SwimmingActivity swimming_2 = createSwimming(format.parse("2019-01-25 20:00:00"),
            new Distance(4000f, MeasurementUnit.METERS), 200l, 23, "Second swim", StrokeType.CRAWL);
        SwimmingActivity swimming_3 = createSwimming(format.parse("2019-01-28 20:00:00"),
            new Distance(5000f, MeasurementUnit.METERS), 200l, 22, "Third swim", StrokeType.CRAWL);
        
        activityManager.add(swimming_1);
        activityManager.add(swimming_2);
        activityManager.add(swimming_3);
        
        List<Activity> swimmingActivities = new LinkedList<>();
        swimmingActivities.add(swimming_1);
        swimmingActivities.add(swimming_2);
        swimmingActivities.add(swimming_3);
        
        // create swinning stats
        SwimmingMetrics swimmingMetrics = new SwimmingMetrics();
        swimmingMetrics.setActivitiesNumber(3);
        swimmingMetrics.setAvgDistance(600L);
        swimmingMetrics.setAvgSwolf(21);
        
        metricsCache.calculateMetrics(swimmingActivities);
        metricsCache.addMetric(ActivityType.SWIMMING, swimmingMetrics);
        
        List <Insight> generatedInsights = performanceInsightGenerator.generateAll();
        
        assertEquals(2, generatedInsights.size());
        for (Insight insight:generatedInsights)
        {
            System.out.println(insight.getInsightMessage());
        }
    }
    
    private RunningActivity createRunning(Date date, Distance distance, 
                                          Long duration, Integer elevation, String name, Double pace, Double slope)
    {
        RunningActivity runningActivity = new RunningActivity();
        runningActivity.setDate(date);
        runningActivity.setDistance(distance);
        runningActivity.setDuration(duration);
        runningActivity.setElevation(elevation);
        runningActivity.setName(name);
        runningActivity.setPace(pace);
        runningActivity.setSlope(slope);
        runningActivity.setType(ActivityType.RUNNING);
        
        return runningActivity;
    }
    
    private SwimmingActivity createSwimming(Date date, Distance distance, 
                                          Long duration, Integer swolf, String name, StrokeType strokeType)
    {
        SwimmingActivity swimmingActivity = new SwimmingActivity();
        swimmingActivity.setDate(date);
        swimmingActivity.setDistance(distance);
        swimmingActivity.setDuration(duration);
        swimmingActivity.setSwolf(swolf);
        swimmingActivity.setName(name);
        swimmingActivity.setStrokeType(strokeType);
        swimmingActivity.setType(ActivityType.SWIMMING);
        
        return swimmingActivity;
    }
}
