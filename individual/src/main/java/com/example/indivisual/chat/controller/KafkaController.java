package com.example.indivisual.chat.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.indivisual.chat.dto.KafkaMessage;
@RestController
@RequiredArgsConstructor
@AllArgsConstructor
public class KafkaController {
  @Autowired
  private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

  @MessageMapping("/send")
  public void sendMessage(@RequestBody KafkaMessage message) {
    kafkaTemplate.send("kafkaTopic", message);
  }

}
