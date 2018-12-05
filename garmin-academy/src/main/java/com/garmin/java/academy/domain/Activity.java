package com.garmin.java.academy.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Activity {
	
	private String name;
	
	private ActivityType type;
	
	private LocalDateTime date;
	
	private Duration duration;
	
	private Distance distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	
	//TODO: getter vs setter ?
	//private float avgSpeed;
	
}
