package com.deeptrain.service;

import com.deeptrain.dto.ScenarioDTO;
import com.deeptrain.model.NodeBlock;
import com.deeptrain.model.Scenario;
import com.deeptrain.repository.ScenarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class ScenarioService {

    @Autowired
    private ScenarioRepository scenarioRepository;

    public Scenario saveScenario(ScenarioDTO dto) {
        System.out.println("Saving Scenario -> Title: " + dto.title + ", Domain: " + dto.domain);
        Scenario s = new Scenario();
        s.setDomain(dto.domain);
        s.setTitle(dto.title);
        s.setSerializedBlocks(dto.serializedBlocks);
        return scenarioRepository.save(s);
    }

    public List<Scenario> getAllScenarios() {
        return scenarioRepository.findAll();
    }

    public Optional<Scenario> getScenarioById(Long id) {
        return scenarioRepository.findById(id);
    }

    public Optional<Scenario> updateScenario(Long id, ScenarioDTO dto) {
        
        return scenarioRepository.findById(id).map(existing -> {
            existing.setDomain(dto.domain);
            existing.setTitle(dto.title);
            existing.setSerializedBlocks(dto.serializedBlocks);
            return scenarioRepository.save(existing);
        });
    }

    public void deleteScenario(Long id) {
        scenarioRepository.deleteById(id);
    }
    //bethy add
    private final WebClient webClient;

    public ScenarioService(@Value("${deepseek.api.url}") String baseUrl,
                           @Value("${deepseek.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public List<NodeBlock> generateScenarioFromPrompt(String prompt) {
        String rawJson = webClient.post()
            .uri("/completions")
            .bodyValue(Map.of(
                "model", "deepseek-chat",
                "prompt", prompt,
                "max_tokens", 500
            ))
            .retrieve()
            .bodyToMono(String.class)
            .block();

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(rawJson, new TypeReference<List<NodeBlock>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse NodeBlocks: " + e.getMessage());
        }
    }
    //bethy end
}
