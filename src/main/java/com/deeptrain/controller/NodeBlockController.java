package com.deeptrain.controller;

import com.deeptrain.dto.NodeBlockDTO;
import com.deeptrain.model.NodeBlock;
import com.deeptrain.service.NodeBlockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/scenario")
@CrossOrigin(origins = "http://localhost:60826")
public class NodeBlockController {

    @Autowired
    private NodeBlockService service;

    @PostMapping("/save")
    public List<NodeBlock> saveScenario(@RequestBody List<NodeBlock> blocks) {
        return service.saveAll(blocks);
    }

    @GetMapping("/all")
    public List<NodeBlock> getAll() {
        return service.getAll();
    }

   @PostMapping("/generate")
    public ResponseEntity<List<NodeBlock>>  generateScenario(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        System.out.println("Prompt ---> " + prompt);
        //return service.generateScenarioFromPrompt(prompt);
        try {
            List<NodeBlock> nodes = service.generateScenarioFromPrompt(prompt);
            return ResponseEntity.ok(nodes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(List.of());
        }
    }  

  


}