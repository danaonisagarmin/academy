package com.garmin.java.academy.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Metrics;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.domain.RunningMetrics;
import com.garmin.java.academy.io.ActivityRepository;

public class MetricsCalculator {

	Map<ActivityType, Metrics> activityMetrics;
	ActivityRepository activityRepository;

	public MetricsCalculator(ActivityRepository activityRepository) throws Exception {
		activityMetrics = new HashMap<ActivityType, Metrics>();
		this.activityRepository = activityRepository;
		refreshAllMetrics();

		System.out.println("initialized MetricsCalculator");
	}

	public void refreshAllMetrics() throws Exception {
		activityMetrics.clear();

		List<Activity> activities = activityRepository.getActivities();

		List<RunningActivity> runningActivities = activities.stream()
					.filter(a -> a.getType().equals(ActivityType.RUNNING))
					.map(obj -> (RunningActivity) obj)
					.collect(Collectors.toList());
		
		activityMetrics.put(ActivityType.RUNNING, generateRunningMetrics(runningActivities));
		
		System.out.println("MetricsCalculator refreshed All Metrics. Metrics count: " + activityMetrics.size());
		activityMetrics.forEach((k,v)->System.out.println("Type : " + k + " Metrics : " + v));
	}

	private Metrics generateRunningMetrics(List<RunningActivity> runningActivities) {
		Metrics runMetrics = new RunningMetrics();
		
		int activitiesCount = (int) runningActivities.stream()
							.count();
		
		runMetrics.setActivitiesNumber(activitiesCount);
		
		return runMetrics;
	}

	public Map<ActivityType, Metrics> getActivityMetrics() {
		return activityMetrics;
	}

	public Metrics getMetricsForActivityType(ActivityType activityType) {
		return activityMetrics.get(activityType);
	}

	private void initializeMetrics(Activity activity) {
	}
}