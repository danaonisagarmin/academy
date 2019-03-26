package com.garmin.java.academy.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.garmin.java.academy.domain.Insight;
import com.garmin.java.academy.domain.Metrics;
import com.garmin.java.academy.io.ActivityRepository;
import com.garmin.java.academy.io.MetricsRepository;

public class InsightService {

	private List<InsightGenerator> insightGenerators;
	private List<Insight> insights;
	
	public InsightService(ActivityRepository activityRepository, MetricsRepository metricsRepository) {
		insightGenerators = new LinkedList<InsightGenerator>();
		insightGenerators.add(new PerformanceInsightGenerator(activityRepository, metricsRepository));
		
		insights = new LinkedList <Insight>();
		
		initializeAllInsights();
		
		System.out.println("Initialised InsightService");
	}

    private void initializeAllInsights()
    {
        insights =
        insightGenerators
            .stream()
            .map(InsightGenerator::generateInsights)
            .flatMap(i -> i.stream())
            .collect(Collectors.toList());
        
        System.out.println("InsightService generated " + insights.size() + " inisghts.");
        insights.stream().forEach(System.out::println);
    }

}
