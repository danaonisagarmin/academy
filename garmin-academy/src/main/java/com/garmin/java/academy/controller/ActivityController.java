package com.garmin.java.academy.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.engine.manager.ActivityManager;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityManager activityManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public Activity getActivity() throws URISyntaxException, IOException {
		return activityManager.getActivity();
	}
	
	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<Activity> loadAll() throws Exception{
		return activityManager.getActivities();
	}

}
