package com.deeptrain.model;

public class DeepSeekRequest {
    private String prompt;

    public DeepSeekRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
