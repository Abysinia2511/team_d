package com.deeptrain.dto;
public class LearnerKpiDto {
    private Long userId;
    private int totalSessions;
    private double averageSessionDuration;
    private double quizAccuracy;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public int getTotalSessions() {
        return totalSessions;
    }
    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }
    public double getAverageSessionDuration() {
        return averageSessionDuration;
    }
    public void setAverageSessionDuration(double averageSessionDuration) {
        this.averageSessionDuration = averageSessionDuration;
    }
    public double getQuizAccuracy() {
        return quizAccuracy;
    }
    public void setQuizAccuracy(double quizAccuracy) {
        this.quizAccuracy = quizAccuracy;
    }
    public double getDecisionCorrectness() {
        return decisionCorrectness;
    }
    public void setDecisionCorrectness(double decisionCorrectness) {
        this.decisionCorrectness = decisionCorrectness;
    }
    private double decisionCorrectness;
}
