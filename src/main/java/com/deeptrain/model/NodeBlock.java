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


}