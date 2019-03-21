package com.garmin.java.academy.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Metrics;
import com.garmin.java.academy.io.ActivityRepository;

public class MetricsCalculator {

	Map<ActivityType, Metrics> activityMetrics;

	public MetricsCalculator(ActivityRepository activityRepository) {
		activityMetrics = new HashMap<ActivityType, Metrics>();
		System.out.println("initialized MetricsCalculator");
	}

	public void refreshMetrics(List<Activity> activities) {
		activities.stream().forEach(activity -> initializeMetrics(activity));
		// TODO save this to a file
	}

	public Map<ActivityType, Metrics> getActivityMetrics() {
		return activityMetrics;
	}

	public Metrics getMetricsForActivityType(ActivityType activityType) {
		return activityMetrics.get(activityType);
	}

	private void initializeMetrics(Activity activity) {
		Metrics metrics;
		if (activityMetrics == null) {
			activityMetrics = new HashMap<>();
		}
		if (!activityMetrics.containsKey(activity.getType())) {
//            metrics = new Metrics();
//            activityMetrics.put(activity.getType(), metrics);
		} else {
			metrics = activityMetrics.get(activity.getType());
		}
//        createMetric(activity, metrics);
	}

	private Metrics createMetric(Activity activity, Metrics existingMetrix) {
		// TODO calculate indiviudal metric
		return null;
	}

	// temporary for unit testing
	public void addMetric(ActivityType type, Metrics metric) {
		activityMetrics.put(type, metric);
	}

}