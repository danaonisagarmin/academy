package com.garmin.java.academy.io;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.garmin.java.academy.domain.Activity;

@Repository
public interface ActivityRepository {

	void add(Activity activity) throws Exception;

	List<Activity> getActivities() throws Exception;
	
}
