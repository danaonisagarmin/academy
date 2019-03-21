package com.garmin.java.academy.domain;

public class RunningMetrics extends Metrics {
    private int totalElevation;

    public int getTotalElevation() {
        return totalElevation;
    }

    public void setTotalElevation(int totalElevation) {
        this.totalElevation = totalElevation;
    }

	@Override
	public String toString() {
		return "RunningMetrics [totalElevation=" + totalElevation + ", avgPace=" + avgPace + ", activitiesNumber="
				+ activitiesNumber + ", avgDistance=" + avgDistance + "]";
	}
}
