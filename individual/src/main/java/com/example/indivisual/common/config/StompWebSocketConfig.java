package com.example.indivisual.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@EnableWebSocketMessageBroker
@Configuration
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat")
        .setAllowedOrigins("http://localhost:8080")
        .setAllowedOriginPatterns("*")
        .withSockJS();

    registry.addEndpoint("/chat")
        .setAllowedOriginPatterns("*")
        .withSockJS();

    registry.addEndpoint("/chat")
        .setAllowedOriginPatterns("http://localhost:9092")
        .withSockJS();

    registry
        .addEndpoint("/stomp")
        .setAllowedOrigins("*")
        .withSockJS()
        .setStreamBytesLimit(512 * 1024)
        .setHttpMessageCacheSize(1000)
        .setDisconnectDelay(30 * 1000);
  }

  /*어플리케이션 내부에서 사용할 path를 지정할 수 있음*/
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/kafkaTopic"); // broker 역할 수행시 사용할 prefix
    registry.enableSimpleBroker("/subscribe", "/kafkaTopic");
    registry.setApplicationDestinationPrefixes("/app"); // 메세지 수신 용 prefix

  }

  @Override
  public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
    registration.setMessageSizeLimit(10 * 1024 * 1024);
    registration.setSendBufferSizeLimit(10 * 1024 * 1024);
    registration.setSendTimeLimit(20 * 10000);
  }

}