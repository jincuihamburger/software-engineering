package com.example.demo.thirdParty;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        amqpTemplate.convertAndSend("Sent: ", message);
        System.out.println("Sent: " + message);
    }
}