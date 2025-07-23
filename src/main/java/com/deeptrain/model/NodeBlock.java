package com.deeptrain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

import com.deeptrain.util.MapToJsonConverter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "node_blocks")
public class NodeBlock {

    @Id
    private String id;

    private float offsetX;
    private float offsetY;
    private String title;
    private String type;
    private String description;

    private String welcomeMessage;
    private String lessonType;
    private String lessonContent;
    private String estimatedTime;
    private String quizTitle;
    private String passingScore;
    private String timeLimit;
    private String conditionExpression;
    private String truePathLabel;
    private String falsePathLabel;
    private String checkpointTitle;
    private String checkpointNote;

    @Convert(converter = MapToJsonConverter.class)
    @ElementCollection
    private List<Map<String, String>> questions;


    public String getTruePathLabel() {
        return truePathLabel;
    }

    public void setTruePathLabel(String truePathLabel) {
        this.truePathLabel = truePathLabel;
    }

    public String getFalsePathLabel() {
        return falsePathLabel;
    }

    public void setFalsePathLabel(String falsePathLabel) {
        this.falsePathLabel = falsePathLabel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(String passingScore) {
        this.passingScore = passingScore;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public String getCheckpointTitle() {
        return checkpointTitle;
    }

    public void setCheckpointTitle(String checkpointTitle) {
        this.checkpointTitle = checkpointTitle;
    }

    public String getCheckpointNote() {
        return checkpointNote;
    }

    public void setCheckpointNote(String checkpointNote) {
        this.checkpointNote = checkpointNote;
    }

    public List<Map<String, String>> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Map<String, String>> questions) {
        this.questions = questions;
    }


}