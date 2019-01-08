package com.garmin.java.academy.io.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.io.ActivitiesReader;

public class ActivitiesFileReader implements ActivitiesReader {

    private static final String ACTIVITY_FILE_NAME = "activities/activity.json";
    private static final String ACTIVITIES_FILE_NAME = "activities/activities.json";
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Activity readActivity() throws Exception {
        String data = readFile(ACTIVITY_FILE_NAME);
        Activity activity = mapper.readValue(data, Activity.class);
        return activity;
    }

    @Override
    public List<Activity> readActivities() throws Exception {
        String data = readFile(ACTIVITIES_FILE_NAME);
        List<Activity> activities = mapper.readValue(data, new TypeReference<List<Activity>>() {
        });
        return activities;
    }

    private static String readFile(String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(ActivitiesFileReader.class.getClassLoader().getResource(fileName).toURI());
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }


}
