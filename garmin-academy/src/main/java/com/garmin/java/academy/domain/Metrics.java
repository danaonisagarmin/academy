package com.garmin.java.academy.domain;

public abstract class Metrics {

    float avgPace;
    int activitiesNumber;
    float avgDistance;

    public float getAvgPace() {
        return avgPace;
    }

    public void setAvgPace(float avgPace) {
        this.avgPace = avgPace;
    }

    public int getActivitiesNumber() {
        return activitiesNumber;
    }

    public void setActivitiesNumber(int activitiesNumber) {
        this.activitiesNumber = activitiesNumber;
    }

    public float getAvgDistance() {
        return avgDistance;
    }

    public void setAvgDistance(float avgDistance) {
        this.avgDistance = avgDistance;
    }

	@Override
	public String toString() {
		return "Metrics [avgPace=" + avgPace + ", activitiesNumber=" + activitiesNumber + ", avgDistance=" + avgDistance
				+ "]";
	}
    
    
}