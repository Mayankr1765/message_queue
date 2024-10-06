package com.project.messege_queue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    MessageQueue messageQueue;

    public void consumeMessage(String topic){
        new Thread(() -> {
            try {
                System.out.println(messageQueue.consume(topic));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }


}
