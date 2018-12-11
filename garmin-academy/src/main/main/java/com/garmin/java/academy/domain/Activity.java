package com.garmin.java.academy.domain;

import java.util.Date;

public class Activity {

	private String name;

	private ActivityType type;

	private Date date;

	private Long duration;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Activity{" +
				"name='" + name + '\'' +
				", type=" + type +
				", date=" + date +
				", duration=" + duration +
				", distance=" + distance +
				'}';
	}
}
