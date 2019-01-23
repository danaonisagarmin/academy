package com.garmin.java.academy.io;

import com.garmin.java.academy.domain.Activity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface ActivityRepository {

	void add(Activity activity) throws Exception;

	List<Activity> getActivities() throws Exception;

	// loads activities from json file and stores the objects in memory
	List<Activity> loadActivities() throws IOException, URISyntaxException;

}
