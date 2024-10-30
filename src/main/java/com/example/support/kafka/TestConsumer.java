package com.example.support.kafka;

import com.example.support.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestConsumer {

    private final ObjectMapper objectMapper;

    public TestConsumer(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "test_topic", groupId = "test-consumer-group")
    public void listen(String message) throws JsonProcessingException {
        JsonNode jsonString = objectMapper.readTree(message);
        System.out.println("Received message: " + jsonString);
    }

}
