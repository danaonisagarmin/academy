package com.garmin.java.academy.domain;

public class Distance {
	
	private float distance;

	private MeasurementUnit measurementUnit;
	
	public Distance(float distance, MeasurementUnit measurementUnit) {
		this.distance = distance;
		this.measurementUnit = measurementUnit;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

}
