package com.garmin.java.academy.engine;

import java.util.List;

import com.garmin.java.academy.domain.Activity;

//TODO remove this
public abstract class VirtualTrainerInsights {

    public abstract float getInsight(List<Activity> activities);

}