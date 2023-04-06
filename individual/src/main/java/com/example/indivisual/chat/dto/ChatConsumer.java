package com.example.indivisual.chat.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatConsumer {
  private final ObjectMapper mapper = new ObjectMapper();
  private final SimpMessagingTemplate messagingTemplate;

  @Autowired
  public ChatConsumer(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  @KafkaListener(topics = "kafkaTopic", groupId = "my-group")
  public void listen(ConsumerRecord<String, KafkaMessage> record) throws IOException {
    KafkaMessage kafkaMessage = record.value();
    ObjectMapper mapper = new ObjectMapper();
    String jsonMessage = mapper.writeValueAsString(kafkaMessage);

    System.out.println("message : " +kafkaMessage.getMessage() + "broker : " + kafkaMessage.getBroker());
    messagingTemplate.convertAndSend("/topic/send", jsonMessage);
  }
}

