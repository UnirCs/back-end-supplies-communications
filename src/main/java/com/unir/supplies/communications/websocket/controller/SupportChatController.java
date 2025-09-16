package com.unir.supplies.communications.websocket.controller;

import com.unir.supplies.communications.websocket.model.SupportChatMessage;
import com.unir.supplies.communications.websocket.service.SupportResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Controller
@RequiredArgsConstructor
public class SupportChatController {

    private final SupportResponseService supportResponseService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/support/message")
    public void handleSupportMessage(SupportChatMessage message) {
        // Configurar el mensaje del cliente
        message.setType(SupportChatMessage.MessageType.CLIENT_MESSAGE);
        message.setSender("CLIENT");

        // Simular delay de respuesta del agente (1-3 segundos)
        CompletableFuture.delayedExecutor(
            1 + (long)(Math.random() * 2),
            TimeUnit.SECONDS
        ).execute(() -> {
            // Generar respuesta automática
            String responseText = supportResponseService.generateResponse(message.getMessage());

            SupportChatMessage supportResponse = new SupportChatMessage(
                message.getClientId(),
                responseText,
                SupportChatMessage.MessageType.SUPPORT_RESPONSE,
                "SUPPORT_AGENT"
            );

            // Enviar respuesta al cliente específico
            messagingTemplate.convertAndSend("/topic/support/123456", supportResponse);
        });
    }
}
