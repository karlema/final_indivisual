//package com.example.indivisual.chat.controller;
//
//
//import com.fasterxml.jackson.databind.ser.std.StringSerializer;
//import java.util.Properties;
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import com.example.indivisual.chat.dto.kafkaMessage;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.stereotype.Controller;
//
//@Controller
//@RequiredArgsConstructor
//
//public class ChatController {
//
//  private final SimpMessageSendingOperations template;
//
////  sendMessage(): 클라이언트가 보낸 메시지를 받아서 /topic/public 채널에 브로드캐스팅합니다.
////  addUser(): 클라이언트가 입장하면 호출되는 메소드로, 클라이언트의 세션에 사용자 이름을 저장하고, 새로운 사용자가 입장했다는 메시지를 /topic/public 채널에 브로드캐스팅합니다.
//
//  @MessageMapping("/chat")
//  public kafkaMessage sendMessage(@Payload kafkaMessage kafkaMessage)
//  {
//    template.convertAndSend("/topic/public", kafkaMessage.getMessage());
//    return kafkaMessage;
//  }
//
////  @MessageMapping("/addUser")
////  public kafkaMessage addUser(@Payload kafkaMessage kafkaMessage, SimpMessageHeaderAccessor headerAccessor) {
////    headerAccessor.getSessionAttributes().put("username", kafkaMessage.getBroker());
////    template.convertAndSend("/topic/public", kafkaMessage.getBroker());
////    return kafkaMessage;
////  }
//
//}