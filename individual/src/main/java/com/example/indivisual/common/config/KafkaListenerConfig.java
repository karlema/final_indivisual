package com.example.indivisual.common.config;

import com.example.indivisual.chat.dto.KafkaMessage;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.apache.kafka.common.serialization.Deserializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import java.util.Map;
import java.util.HashMap;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration

//receive message by topic
public class KafkaListenerConfig {

  @Bean
  ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public Map<String, Object> consumerConfigurations() {
    Map<String, Object> configurations = new HashMap<>();
    configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configurations.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
    configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,  JsonDeserializer.class);
    configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

    return configurations;
  }
  @Bean
  public ConsumerFactory<String, KafkaMessage> consumerFactory() {
    JsonDeserializer<KafkaMessage> deserializer = new JsonDeserializer<>(KafkaMessage.class);
    deserializer.addTrustedPackages("*");
    deserializer.setUseTypeMapperForKey(true);

    return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), new StringDeserializer(), deserializer);
  }
}
