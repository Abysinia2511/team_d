package com.deeptrain.dto;

import com.deeptrain.model.NodeBlock;

import java.util.List;
import java.util.UUID;

public class LessonMapper {

    /**
     * Converts raw AI text response into a single Lesson block.
     */
    public static List<NodeBlock> fromAIText(String rawText, String prompt) {
        NodeBlock lessonBlock = new NodeBlock();
        lessonBlock.setId("AI-" + UUID.randomUUID());
        lessonBlock.setType("Lesson");
        lessonBlock.setTitle("AI Lesson: " + prompt);
        lessonBlock.setLessonType("Text");
        lessonBlock.setLessonContent(rawText);
        lessonBlock.setEstimatedTime("10");

        return List.of(lessonBlock);
    }
}