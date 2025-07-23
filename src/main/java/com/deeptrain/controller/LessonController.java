package com.deeptrain.controller;

import com.deeptrain.model.NodeBlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.deeptrain.service.LessonService;
import com.deeptrain.service.NodeBlockService;

@RestController
@RequestMapping("/api/v1/lesson")
@CrossOrigin(origins = "*")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/generate")
    public ResponseEntity<List<NodeBlock>> generateLesson(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");

        if (prompt == null || prompt.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            NodeBlock lesson = lessonService.generateLessonFromPrompt(prompt);
            return ResponseEntity.ok(List.of(lesson));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(List.of());
        }
    }
}
