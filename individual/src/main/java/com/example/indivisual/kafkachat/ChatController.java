//package com.example.indivisual.kafkachat;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//
////@MessageMapping 어노테이션을 사용하여 /chat 경로로 들어오는 메시지를 처리합니다. sendMessage() 메소드에서는 받은 메시지를 Kafka에 전송하고, @SendTo 어노테이션을 사용하여 /topic/messages 경로로 전송한 메시지를 반환합니다.
//@Controller
//public class ChatController {
//
//  @Autowired
//  private KafkaTemplate<String, ChatMessage> kafkaTemplate;
//
//  @MessageMapping("/chat")
//  @SendTo("/topic/messages")
//  public ChatMessage sendMessage(ChatMessage message) {
//    kafkaTemplate.send("chat-message-topic", message);
//    return message;
//  }
//}
