
package com.example.fragmentview;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClassLoad {

    @SerializedName("appreciation")
    @Expose
    private String appreciation;
    @SerializedName("delayedStatus")
    @Expose
    private String delayedStatus;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("expectedGoals")
    @Expose
    private String expectedGoals;
    @SerializedName("firstUpdatedTime")
    @Expose
    private String firstUpdatedTime;
    @SerializedName("goalTomorrow")
    @Expose
    private String goalTomorrow;
    @SerializedName("history")
    @Expose
    private List<History> history = null;
    @SerializedName("innovationOrIdea")
    @Expose
    private String innovationOrIdea;
    @SerializedName("lastUpdatedTime")
    @Expose
    private String lastUpdatedTime;
    @SerializedName("message")
    @Expose
    private List<Object> message = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pendingObstucles")
    @Expose
    private String pendingObstucles;
    @SerializedName("ratedBy")
    @Expose
    private List<Object> ratedBy = null;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("resolvedTasks")
    @Expose
    private String resolvedTasks;
    @SerializedName("resolvedTasksFromProductPulse")
    @Expose
    private ResolvedTasksFromProductPulse resolvedTasksFromProductPulse;
    @SerializedName("reviews")
    @Expose
    private String reviews;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("taskCompletion")
    @Expose
    private String taskCompletion;
    @SerializedName("taskResolved")
    @Expose
    private String taskResolved;
    @SerializedName("taskToday")
    @Expose
    private String taskToday;
    @SerializedName("weeklyGoals")
    @Expose
    private String weeklyGoals;

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getDelayedStatus() {
        return delayedStatus;
    }

    public void setDelayedStatus(String delayedStatus) {
        this.delayedStatus = delayedStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(String expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public String getFirstUpdatedTime() {
        return firstUpdatedTime;
    }

    public void setFirstUpdatedTime(String firstUpdatedTime) {
        this.firstUpdatedTime = firstUpdatedTime;
    }

    public String getGoalTomorrow() {
        return goalTomorrow;
    }

    public void setGoalTomorrow(String goalTomorrow) {
        this.goalTomorrow = goalTomorrow;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public String getInnovationOrIdea() {
        return innovationOrIdea;
    }

    public void setInnovationOrIdea(String innovationOrIdea) {
        this.innovationOrIdea = innovationOrIdea;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public List<Object> getMessage() {
        return message;
    }

    public void setMessage(List<Object> message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPendingObstucles() {
        return pendingObstucles;
    }

    public void setPendingObstucles(String pendingObstucles) {
        this.pendingObstucles = pendingObstucles;
    }

    public List<Object> getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(List<Object> ratedBy) {
        this.ratedBy = ratedBy;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getResolvedTasks() {
        return resolvedTasks;
    }

    public void setResolvedTasks(String resolvedTasks) {
        this.resolvedTasks = resolvedTasks;
    }

    public ResolvedTasksFromProductPulse getResolvedTasksFromProductPulse() {
        return resolvedTasksFromProductPulse;
    }

    public void setResolvedTasksFromProductPulse(ResolvedTasksFromProductPulse resolvedTasksFromProductPulse) {
        this.resolvedTasksFromProductPulse = resolvedTasksFromProductPulse;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTaskCompletion() {
        return taskCompletion;
    }

    public void setTaskCompletion(String taskCompletion) {
        this.taskCompletion = taskCompletion;
    }

    public String getTaskResolved() {
        return taskResolved;
    }

    public void setTaskResolved(String taskResolved) {
        this.taskResolved = taskResolved;
    }

    public String getTaskToday() {
        return taskToday;
    }

    public void setTaskToday(String taskToday) {
        this.taskToday = taskToday;
    }

    public String getWeeklyGoals() {
        return weeklyGoals;
    }

    public void setWeeklyGoals(String weeklyGoals) {
        this.weeklyGoals = weeklyGoals;
    }
    public class ResolvedTasksFromProductPulse {

        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("status")
        @Expose
        private String status;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
    public class History {

        @SerializedName("statusUpdatedTime")
        @Expose
        private String statusUpdatedTime;
        @SerializedName("taskToday")
        @Expose
        private String taskToday;

        public String getStatusUpdatedTime() {
            return statusUpdatedTime;
        }

        public void setStatusUpdatedTime(String statusUpdatedTime) {
            this.statusUpdatedTime = statusUpdatedTime;
        }

        public String getTaskToday() {
            return taskToday;
        }

        public void setTaskToday(String taskToday) {
            this.taskToday = taskToday;
        }

    }
}

