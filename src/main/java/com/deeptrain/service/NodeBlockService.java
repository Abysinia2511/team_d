package com.deeptrain.service;

import com.deeptrain.model.NodeBlock;
import com.deeptrain.repository.NodeBlockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import com.deeptrain.dto.NodeBlockMapper;
import com.deeptrain.model.ChatMessage;
import com.deeptrain.model.DeepSeekChatRequest;
import com.deeptrain.model.DeepSeekChatResponse;
import com.deeptrain.model.DeepSeekRequest;
import com.deeptrain.model.DeepSeekResponse;
import com.fasterxml.jackson.core.JsonProcessingException;




@Service
public class NodeBlockService {

    private final WebClient webClient;

    @Autowired
    private NodeBlockRepository repository;

    public List<NodeBlock> saveAll(List<NodeBlock> blocks) {
        return repository.saveAll(blocks);
    }

    public List<NodeBlock> getAll() {
        return repository.findAll();
    }

    public NodeBlockService(@Value("${deepseek.api.url}") String baseUrl,
                     @Value("${deepseek.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public List<NodeBlock> generateScenarioFromPrompt(String prompt) throws JsonProcessingException {
        DeepSeekChatRequest request = new DeepSeekChatRequest("deepseek-chat", List.of(
        new ChatMessage("user", prompt)
         ));
       System.out.println("request ---> " + request);
       return webClient.post()
            .uri("/chat/completions")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(DeepSeekChatResponse.class)
            .map(response -> {
                String content = response.getChoices().get(0).getMessage().getContent();
                // Optional: log or debug
                System.out.println("🔍 DeepSeek Response:\n" + content);

                // ✅ Convert this content string into your app's NodeBlocks
                return NodeBlockMapper.fromAIText(content);
            })
            .block();
    }


}