package com.example.fragmentview;

import android.widget.RatingBar;

public class ModelOverview {
    public ModelOverview(String weeklyOverview, RatingBar ratingBar, String everydayOverview) {
        this.weeklyOverview = weeklyOverview;
        this.ratingBar = ratingBar;
        this.everydayOverview = everydayOverview;
    }

    private String weeklyOverview;
    RatingBar ratingBar;
    private String everydayOverview;

    public String getWeeklyOverview() {
        return weeklyOverview;
    }

    public RatingBar getRatingBar() {
        return ratingBar;
    }

    public String getEverydayOverview() {
        return everydayOverview;
    }
}




