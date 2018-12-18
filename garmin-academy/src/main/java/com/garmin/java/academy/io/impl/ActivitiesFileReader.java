package com.garmin.java.academy.io.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.io.ActivitiesReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActivitiesFileReader implements ActivitiesReader {

	private static final String ACTIVITIES_FILE_NAME = "activities/activity.json";

	@Override
	public Activity readActivity() throws Exception {
		Path path = Paths.get(ActivitiesFileReader.class.getClassLoader().getResource(ACTIVITIES_FILE_NAME).toURI());
		Stream<String> lines = Files.lines(path);
		String data = lines.collect(Collectors.joining("\n"));
		lines.close();
		ObjectMapper mapper = new ObjectMapper();
		Activity activity = mapper.readValue(data, Activity.class);
		return activity;
	}

	@Override
	public List<Activity> readActivities() {
		return null;
	}
}
