package com.example.indivisual.kafkachat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ChatConsumer {

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @KafkaListener(topics = "chat-message-topic", groupId = "group-id")
  public void consume(ChatMessage message) {
    messagingTemplate.convertAndSend("/topic/messages", message);
  }
}
