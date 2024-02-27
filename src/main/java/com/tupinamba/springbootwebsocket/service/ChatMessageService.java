package com.tupinamba.springbootwebsocket.service;

import com.tupinamba.springbootwebsocket.model.ChatMessage;
import com.tupinamba.springbootwebsocket.model.ChatMessage.MessageType;
import com.tupinamba.springbootwebsocket.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tupinamba.springbootwebsocket.model.ChatMessage;
import java.util.List;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public void saveMessage(ChatMessage chatMessage) {
        System.out.println(chatMessage);
        chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    public List<ChatMessage> getChatHistory() {
        return chatMessageRepository.findAllByType(MessageType.CHAT);
    }
    }

