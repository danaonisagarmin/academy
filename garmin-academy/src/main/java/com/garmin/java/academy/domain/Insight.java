package com.garmin.java.academy.domain;

import java.util.List;

public class Insight
{
    private String insightMessage;

    /*
     * used to determine if an inisght must be removed/refreshed
     * when a new activity is uploaded
     */
    private List <ActivityType> influencedByType;

    private InsightType insightType;

    public Insight(String message)
    {
        insightMessage = message;
    }

    public String getInsightMessage()
    {
        return insightMessage;
    }

    public void setInsightMessage(String insightMessage)
    {
        this.insightMessage = insightMessage;
    }

    public List <ActivityType> getInfluencedByType()
    {
        return influencedByType;
    }

    public void setInfluencedByType(List <ActivityType> influencedByType)
    {
        this.influencedByType = influencedByType;
    }

    public InsightType getInsightType()
    {
        return insightType;
    }

    public void setInsightType(InsightType insightType)
    {
        this.insightType = insightType;
    }

    @Override
    public String toString()
    {
        return "Inisght [insightMessage=" + insightMessage + ", influencedByType=" + influencedByType +
               ", insightType=" + insightType + "]";
    }
}
