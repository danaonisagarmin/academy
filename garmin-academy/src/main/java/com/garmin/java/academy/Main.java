package com.garmin.java.academy;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.ActivityType;
import com.garmin.java.academy.domain.Distance;
import com.garmin.java.academy.domain.MeasurementUnit;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * Path path =
		 * Paths.get(Main.class.getClassLoader().getResource("fileTest.txt").toURI());
		 * 
		 * Stream<String> lines = Files.lines(path); String data =
		 * lines.collect(Collectors.joining("\n")); lines.close();
		 */

		Activity a = new Activity();
		a.setDate(LocalDateTime.now());
		a.setDistance(new Distance(123f, MeasurementUnit.METERS));
		a.setDuration(Duration.ofHours(2));
		a.setName("Monday Run");
		a.setType(ActivityType.RUNNING);

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JSR310Module());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		System.out.println(new ObjectMapper().writeValueAsString(a));

	}

}
