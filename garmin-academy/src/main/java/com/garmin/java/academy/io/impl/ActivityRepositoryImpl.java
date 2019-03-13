package com.garmin.java.academy.io.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.io.ActivityRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO
public class ActivityRepositoryImpl implements ActivityRepository {

    private static final String ACTIVITY_FILE_NAME = "activities/activity.json";
    private static final String ACTIVITIES_FILE_NAME = "activities/activities.json";
    ObjectMapper mapper = new ObjectMapper();

    private List<Activity> activities;

    public ActivityRepositoryImpl()
    {
        activities = new LinkedList <Activity>();
    }

    @Override
    public void add(Activity activity) throws Exception {
        activities.add(activity);
    }

    @Override
    public List<Activity> getActivities() throws Exception {
        return activities;
    }

    @Override
    public List<Activity> loadActivities() throws IOException, URISyntaxException {
        String data = readFile(ACTIVITIES_FILE_NAME);
        List<Activity> activities = mapper.readValue(data, new TypeReference<List<Activity>>() {
        });

        this.activities=activities;
        return this.activities;
    }

    private static String readFile(String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(ActivitiesFileReader.class.getClassLoader().getResource(fileName).toURI());
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }


}
