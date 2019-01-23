package com.garmin.java.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Distance;
import com.garmin.java.academy.domain.MeasurementUnit;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.io.ActivitiesReader;
import com.garmin.java.academy.io.impl.ActivitiesFileReader;

import java.util.Date;

public class Main {

	public static void main(String[] args) throws Exception {
		ActivitiesReader activitiesReader = new ActivitiesFileReader();
		System.out.println(activitiesReader.readActivity());
	}

	private void generateJson() throws Exception {
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
