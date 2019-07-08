package com.tiantianchat.model;

import lombok.Data;

@Data
public class ChatMessage {
    private MessageType type;
    private String content;
    private User sender;
}
