package com.garmin.java.academy.engine;

import java.util.List;

import com.garmin.java.academy.domain.Activity;
import com.garmin.java.academy.domain.Insight;

public interface InsightGenerator
{
    public List <Insight> generateAll() throws Exception;
    
    public List <Insight> generateForNewActivity(Activity activity);
}
