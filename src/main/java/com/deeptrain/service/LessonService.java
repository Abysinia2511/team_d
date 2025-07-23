package com.deeptrain.service;

import com.deeptrain.dto.LessonMapper;
import com.deeptrain.model.ChatMessage;
import com.deeptrain.model.DeepSeekChatRequest;
import com.deeptrain.model.DeepSeekChatResponse;
import com.deeptrain.model.NodeBlock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.UUID;

@Service
public class LessonService {

    private final WebClient webClient;

    public LessonService(@Value("${deepseek.api.url}") String baseUrl,
                         @Value("${deepseek.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public NodeBlock generateLessonFromPrompt(String prompt) throws JsonProcessingException {
        DeepSeekChatRequest request = new DeepSeekChatRequest("deepseek-chat", List.of(
                new ChatMessage("user", prompt)
        ));

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(DeepSeekChatResponse.class)
                .map(response -> {
                    String content = response.getChoices().get(0).getMessage().getContent();
                    System.out.println("🧠 Lesson Response:\n" + content);

                    NodeBlock lesson = new NodeBlock();
                    lesson.setId(UUID.randomUUID().toString());
                    lesson.setType("Lesson");
                    lesson.setTitle("AI Lesson: " + prompt);
                    lesson.setLessonType("Text");
                    lesson.setLessonContent(content);
                    lesson.setEstimatedTime("10");
                    return LessonMapper.fromAIText(content, prompt).get(0);
                })
                .block();
    }
}
