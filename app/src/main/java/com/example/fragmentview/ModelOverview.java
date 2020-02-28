package com.example.fragmentview;

import android.widget.RatingBar;

public class ModelOverview {
    private String weeklygoalstext,dailygoalssubText;
    private boolean isExpandable;

    public ModelOverview(String weeklygoalstext, String dailygoalssubText, boolean isExpandable) {
        this.weeklygoalstext = weeklygoalstext;
        this.dailygoalssubText = dailygoalssubText;
        this.isExpandable = isExpandable;
    }

    public String getWeeklygoalstext() {
        return weeklygoalstext;
    }

    public String getDailygoalssubText() {
        return dailygoalssubText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }
}





