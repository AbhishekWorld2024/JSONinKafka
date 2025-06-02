package com.example.KafkaForJSON;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "JSON_Topic", groupId = "my-group1")
    public void consume(User user) {
        System.out.println("Consumed JSON message: " + user);
    }
}
