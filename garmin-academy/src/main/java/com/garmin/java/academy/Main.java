package com.garmin.java.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Distance;
import com.garmin.java.academy.domain.MeasurementUnit;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.engine.manager.ActivityManager;
import com.garmin.java.academy.io.impl.ActivityRepositoryImpl;

import java.util.Date;
import java.util.List;

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
	}

}
