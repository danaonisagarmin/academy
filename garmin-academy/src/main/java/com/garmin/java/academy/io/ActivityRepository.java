package com.garmin.java.academy.io;

import java.util.List;

import com.garmin.java.academy.domain.Activity;

public interface ActivityRepository {

	void add(Activity activity) throws Exception;

	List<Activity> getActivities() throws Exception;
	
}
