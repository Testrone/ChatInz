package com.tupinamba.springbootwebsocket.controller;

import com.tupinamba.springbootwebsocket.model.ChatMessage;
import com.tupinamba.springbootwebsocket.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class ChatController {
    private final ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public ChatController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSender());
        System.out.println("Payload: " + chatMessage);
        List<ChatMessage> previousMessages = chatMessageService.getChatHistory();
        if (previousMessages == null) {
            previousMessages = new ArrayList<>();
        } else {
            for (ChatMessage message : previousMessages) {
                messagingTemplate.convertAndSend("/topic/public", message);
            }
        }
        System.out.println("Sending previous messages: " + previousMessages);
        if (!previousMessages.isEmpty()) {
            messagingTemplate.convertAndSendToUser(Objects.requireNonNull(headerAccessor.getSessionId()), "/queue/history", previousMessages);
            System.out.println("Sent previous messages successfully.");
        }
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessageService.saveMessage(chatMessage);
        return chatMessage;
    }
    @MessageMapping("/chat.getHistory")
    public void getChatHistory(SimpMessageHeaderAccessor headerAccessor) {
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            List<ChatMessage> history = chatMessageService.getAllMessages();
            messagingTemplate.convertAndSendToUser(username, "/topic/public", history);
        }
    }
}
