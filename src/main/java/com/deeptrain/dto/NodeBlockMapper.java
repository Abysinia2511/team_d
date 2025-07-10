package com.deeptrain.dto;

import java.util.ArrayList;
import java.util.List;

import com.deeptrain.model.NodeBlock;

public class NodeBlockMapper {
    public static List<NodeBlock> fromAIText(String rawText) {
        // Simple example: split by `---` and assign random types
        String[] lines = rawText.split("\n");
        List<NodeBlock> blocks = new ArrayList<>();
        int index = 1;

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                NodeBlock block = new NodeBlock();
                block.setId("AI-" + index++);
                block.setTitle(line.trim());
                block.setType("Lesson"); // Or "Decision", "Quiz", etc. based on parsing
                blocks.add(block);
            }
        }
        return blocks;
    }
}

