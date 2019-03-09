package com.garmin.java.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.manager.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService activityManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public Activity getMostRecentActivity() throws Exception {
		return activityManager.getLatestActivity();
	}
	
	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<Activity> loadAll() throws Exception{
		return activityManager.getActivities();
	}

}
