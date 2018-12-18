package com.garmin.java.academy.util;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Distance;

public class MetricsUtil {

	private static final long METERS_PER_KM = 1000;
	private static final float KM_PER_MILE = 1.6f;

	public static float averagePace(Activity activity) {
		return activity.getDuration() / activity.getDistance().getDistance();
	}

	public static float distanceAsKilometers(Distance distance) {
		switch (distance.getMeasurementUnit()) {
		case KILOMETERS:
			return distance.getDistance();
		case METERS:
			return distance.getDistance() / METERS_PER_KM;
		case MILES:
			return distance.getDistance() * KM_PER_MILE;
		default:
		}
		return 0;
	}

}
