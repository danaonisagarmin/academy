    package com.garmin.java.academy.engine;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Distance;
import com.garmin.java.academy.domain.MeasurementUnit;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.domain.old.MetricsCache;
import com.garmin.java.academy.domain.old.RunningMetrics;
import com.garmin.java.academy.io.impl.ActivityRepositoryJsonImpl;
import com.garmin.java.academy.manager.ActivityService;

public class PerformanceInsightGeneratorTest
{
    
    ActivityService activityManager;
    MetricsCache metricsCache; 
    PerformanceInsightGenerator performanceInsightGenerator; 
    
    @Test
    public void validateGenerateAll() throws Exception
    {
        activityManager =new ActivityService(new ActivityRepositoryJsonImpl());
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
        
        // create running stats
        RunningMetrics runningMetrics = new RunningMetrics();
        runningMetrics.setActivitiesNumber(3);
        runningMetrics.setAvgDistance(2300L);
        runningMetrics.setAvgPace(6.21f);
        runningMetrics.setTotalElevation(240);
        
        metricsCache.addMetric(ActivityType.RUNNING, runningMetrics);
        
        // create swimming activities
        // create swinning stats
        
        //TODO verify response
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
}
