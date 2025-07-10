package com.deeptrain.model;

import java.util.List;

public class DeepSeekChatRequest {
    private String model;
    private List<ChatMessage> messages;

    public DeepSeekChatRequest(String model, List<ChatMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

    // Getters and setters

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List getMessages() {
        return messages;
    }

    public void setMessages(List messages) {
        this.messages = messages;
    }


}

