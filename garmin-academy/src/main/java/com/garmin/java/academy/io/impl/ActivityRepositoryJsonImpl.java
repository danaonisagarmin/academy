package com.garmin.java.academy.io.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.RunningActivity;
import com.garmin.java.academy.domain.SwimmingActivity;
import com.garmin.java.academy.io.ActivityRepository;

//TODO
@Repository
public class ActivityRepositoryJsonImpl implements ActivityRepository {

    //private static final String ACTIVITY_FILE_NAME = "activities/activity.json";
    private static final String RUNNING_ACTIVITIES_FILE_NAME = "activities/runningActivities.json";
    private static final String SWIMMING_ACTIVITIES_FILE_NAME = "activities/swimmingActivities.json";

    static ObjectMapper mapper = new ObjectMapper();

    private List<Activity> activities;
        
    static {
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void add(Activity activity) throws Exception {

    }
    
    @Override
    public List<Activity> getActivities() throws Exception {
        return loadActivities();
    }

    //load all activities
    private List<Activity> loadActivities() throws IOException, URISyntaxException {
        String runningActivities = readFile(RUNNING_ACTIVITIES_FILE_NAME);
        String swimmingActivities = readFile(SWIMMING_ACTIVITIES_FILE_NAME);

        activities = mapper.readValue(runningActivities, new TypeReference<List<RunningActivity>>() {
        });
        
        activities.addAll(mapper.readValue(swimmingActivities, new TypeReference<List<SwimmingActivity>>() {
        }));
        
        return activities;
    }
    
    private static String readFile(String fileName) throws URISyntaxException, IOException {
    	Path path = Paths.get(ActivityRepositoryJsonImpl.class.getClassLoader().getResource(fileName).toURI());
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }

}
