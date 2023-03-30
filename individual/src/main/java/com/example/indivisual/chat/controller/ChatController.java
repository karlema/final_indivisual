package com.example.indivisual.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import com.example.indivisual.chat.dto.ChatMessage;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

  private final SimpMessageSendingOperations template;

//  sendMessage(): 클라이언트가 보낸 메시지를 받아서 /topic/public 채널에 브로드캐스팅합니다.
//  addUser(): 클라이언트가 입장하면 호출되는 메소드로, 클라이언트의 세션에 사용자 이름을 저장하고, 새로운 사용자가 입장했다는 메시지를 /topic/public 채널에 브로드캐스팅합니다.

  @MessageMapping("/chat.sendMessage")
  public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
  {
    template.convertAndSend("/topic/public",chatMessage);
    return chatMessage;
  }

  @MessageMapping("/chat.addUser")
  public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    template.convertAndSend("/topic/public",chatMessage.getSender());
    return chatMessage;
  }

}