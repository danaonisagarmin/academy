package com.garmin.java.academy.io;

import com.garmin.java.academy.domain.Activity;

import java.util.List;

public interface ActivitiesReader {

	Activity readActivity() throws Exception;

	List<Activity> readActivities();

}
