package com.unir.supplies.communications.websocket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportChatMessage {

    private String clientId;
    private String message;
    private MessageType type;
    private LocalDateTime timestamp;
    private String sender;

    public SupportChatMessage(String clientId, String message, MessageType type, String sender) {
        this.clientId = clientId;
        this.message = message;
        this.type = type;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public enum MessageType {
        CLIENT_MESSAGE,
        SUPPORT_RESPONSE,
        SYSTEM_MESSAGE
    }
}
