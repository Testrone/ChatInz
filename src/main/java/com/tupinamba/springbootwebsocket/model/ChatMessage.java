package com.tupinamba.springbootwebsocket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name="chat")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonProperty
    private String content;
    @JsonProperty
    private String sender;
    @JsonProperty
    private MessageType type;
    public ChatMessage() {

    }
    public enum MessageType {
         LEAVE, CHAT, JOIN
    }
    public String getSender() {
        return sender;
    }
    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", type=" + type +
                '}';
    }
}
