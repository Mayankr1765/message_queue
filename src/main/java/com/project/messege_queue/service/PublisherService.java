package com.project.messege_queue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Service
public class PublisherService {

    @Autowired
    private MessageQueue messageQueue;

    public void createTopics(String topic){
        messageQueue.createTopics(topic);
    }

    public void sendMessage(String topic,String message) throws InterruptedException {
        messageQueue.publish(topic, message);
    }


}
