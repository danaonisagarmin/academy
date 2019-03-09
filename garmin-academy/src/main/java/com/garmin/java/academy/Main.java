package com.garmin.java.academy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Distance;
import com.garmin.java.academy.domain.MeasurementUnit;
import com.garmin.java.academy.domain.RunningActivity;

public class Main {

	public static void main(String[] args) throws Exception {
		/*ActivityManager manager = new ActivityManager(new ActivityRepositoryImpl());
		List<Activity> activities = manager.getActivities();*/
		generateJson();

	}

	private static void generateJson() throws Exception {
		Activity a = new RunningActivity();
		a.setDate(new Date());
		a.setDistance(new Distance(123f, MeasurementUnit.METERS));
		a.setDuration(2000L);
		a.setName("Monday Run");
		a.setType(ActivityType.RUNNING);

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(new ObjectMapper().writeValueAsString(a));
		
		List<Activity> activities = new ArrayList<>();
		activities.add(a);
		activities.add(a);
		System.out.println(activities);
	}

}
