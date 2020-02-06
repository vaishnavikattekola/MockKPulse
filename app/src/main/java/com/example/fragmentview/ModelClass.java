package com.example.fragmentview;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClass {

    @SerializedName("status")
    @Expose
    private List<Status> status = null;
    @SerializedName("teamStatus")
    @Expose
    private String teamStatus;

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public String getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        this.teamStatus = teamStatus;
    }
    ///////////////////////////////////////// STATUS WHAT WE NEED///////////////////////////
    public class Status {

        @SerializedName("startDate")
        @Expose
        private String startDate;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("taskToday")
        @Expose
        private String taskToday;
        @SerializedName("taskResolved")
        @Expose
        private String taskResolved;
        @SerializedName("message")
        @Expose
        private List<Object> message = null;
        @SerializedName("taskCompletion")
        @Expose
        private String taskCompletion;
        @SerializedName("delayedStatus")
        @Expose
        private String delayedStatus;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("reviews")
        @Expose
        private String reviews;
        @SerializedName("ratedBy")
        @Expose
        private List<Object> ratedBy = null;
        @SerializedName("goalTomorrow")
        @Expose
        private String goalTomorrow;
        @SerializedName("innovationOrIdea")
        @Expose
        private String innovationOrIdea;
        @SerializedName("appreciation")
        @Expose
        private String appreciation;
        @SerializedName("pendingObstucles")
        @Expose
        private String pendingObstucles;
        @SerializedName("lastUpdatedTime")
        @Expose
        private String lastUpdatedTime;
        @SerializedName("history")
        @Expose
        private List<History> history = null;
        @SerializedName("firstUpdatedTime")
        @Expose
        private String firstUpdatedTime;
        @SerializedName("weeklyGoals")
        @Expose
        private String weeklyGoals;
        @SerializedName("day")
        @Expose
        private String day;
        @SerializedName("isHoliday")
        @Expose
        private Boolean isHoliday;
        @SerializedName("goalsTomorrow")
        @Expose
        private String goalsTomorrow;
        @SerializedName("comments")
        @Expose
        private String comments;

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTaskToday() {
            return taskToday;
        }

        public void setTaskToday(String taskToday) {
            this.taskToday = taskToday;
        }

        public String getTaskResolved() {
            return taskResolved;
        }

        public void setTaskResolved(String taskResolved) {
            this.taskResolved = taskResolved;
        }

        public List<Object> getMessage() {
            return message;
        }

        public void setMessage(List<Object> message) {
            this.message = message;
        }

        public String getTaskCompletion() {
            return taskCompletion;
        }

        public void setTaskCompletion(String taskCompletion) {
            this.taskCompletion = taskCompletion;
        }

        public String getDelayedStatus() {
            return delayedStatus;
        }

        public void setDelayedStatus(String delayedStatus) {
            this.delayedStatus = delayedStatus;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getReviews() {
            return reviews;
        }

        public void setReviews(String reviews) {
            this.reviews = reviews;
        }

        public List<Object> getRatedBy() {
            return ratedBy;
        }

        public void setRatedBy(List<Object> ratedBy) {
            this.ratedBy = ratedBy;
        }

        public String getGoalTomorrow() {
            return goalTomorrow;
        }

        public void setGoalTomorrow(String goalTomorrow) {
            this.goalTomorrow = goalTomorrow;
        }

        public String getInnovationOrIdea() {
            return innovationOrIdea;
        }

        public void setInnovationOrIdea(String innovationOrIdea) {
            this.innovationOrIdea = innovationOrIdea;
        }

        public String getAppreciation() {
            return appreciation;
        }

        public void setAppreciation(String appreciation) {
            this.appreciation = appreciation;
        }

        public String getPendingObstucles() {
            return pendingObstucles;
        }

        public void setPendingObstucles(String pendingObstucles) {
            this.pendingObstucles = pendingObstucles;
        }

        public String getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        public void setLastUpdatedTime(String lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
        }

        public List<History> getHistory() {
            return history;
        }

        public void setHistory(List<History> history) {
            this.history = history;
        }

        public String getFirstUpdatedTime() {
            return firstUpdatedTime;
        }

        public void setFirstUpdatedTime(String firstUpdatedTime) {
            this.firstUpdatedTime = firstUpdatedTime;
        }

        public String getWeeklyGoals() {
            return weeklyGoals;
        }

        public void setWeeklyGoals(String weeklyGoals) {
            this.weeklyGoals = weeklyGoals;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public Boolean getIsHoliday() {
            return isHoliday;
        }

        public void setIsHoliday(Boolean isHoliday) {
            this.isHoliday = isHoliday;
        }

        public String getGoalsTomorrow() {
            return goalsTomorrow;
        }

        public void setGoalsTomorrow(String goalsTomorrow) {
            this.goalsTomorrow = goalsTomorrow;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

    }
    //////////////////////////////////HISTORY OF EDIT/////////////////////
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


