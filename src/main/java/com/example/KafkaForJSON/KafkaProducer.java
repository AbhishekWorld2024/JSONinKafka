package com.example.KafkaForJSON;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    KafkaTemplate<String ,User> kafkaTemplate;
    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
        Message<User> message= MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"JSON_Topic").build();
        kafkaTemplate.send(message);
    }




}
