package com.garmin.java.academy.io.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.io.ActivityRepository;

public class ActivityRepositoryDBImpl implements ActivityRepository{

	@Override
	public void add(Activity activity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Activity> getActivities() throws Exception {
		// TODO Auto-generated method stub
		loadActivities();
		return null;
	}

	//load all activities and store them 
	private List<Activity> loadActivities() throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

}
