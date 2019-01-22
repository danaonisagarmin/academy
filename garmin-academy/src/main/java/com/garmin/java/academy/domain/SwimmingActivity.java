package com.garmin.java.academy.domain;

public class SwimmingActivity extends Activity {

    private StrokeType strokeType;
    private int swolf;

    public StrokeType getStrokeType() {
        return strokeType;
    }

    public void setStrokeType(StrokeType strokeType) {
        this.strokeType = strokeType;
    }

    public int getSwolf() {
        return swolf;
    }

    public void setSwolf(int swolf) {
        this.swolf = swolf;
    }
}
