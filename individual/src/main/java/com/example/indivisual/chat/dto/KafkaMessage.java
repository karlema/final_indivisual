package com.example.indivisual.chat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KafkaMessage {
  private String broker;
  private String message;

  public KafkaMessage(String broker, String message) {
    this.broker = broker;
    this.message = message;
  }


//  private MessageType type;
//
//  public enum MessageType {
//    CHAT, JOIN, LEAVE
//  }

  // Getter, Setter, Constructor
}