package com.garmin.java.academy.util;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Distance;

public class MetricsUtil {

    private static final long METERS_PER_KM = 1000;
    private static final float KM_PER_MILE = 1.6f;

    public static float computePace(Activity activity) {
        return activity.getDuration() / distanceAsKilometers(activity.getDistance());
    }

    private static float distanceAsKilometers(Distance distance) {
        switch (distance.getMeasurementUnit()) {
            case KILOMETERS:
                return distance.getValue();
            case METERS:
                return distance.getValue() / METERS_PER_KM;
            case MILES:
                return distance.getValue() * KM_PER_MILE;
            default:
        }
        return 0;
    }

    private static long msToMinutes(long duration){
        return duration/60000;
    }

}
