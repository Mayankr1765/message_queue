package com.project.messege_queue.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class MessageQueue {

    private Map<String, BlockingQueue<String>> topics = new ConcurrentHashMap<>();
    public void createTopics(String topic){
        topics.put(topic,new LinkedBlockingDeque<>());
    }


    public void publish(String topic,String message) throws InterruptedException {
        BlockingQueue<String> individualTopic = topics.get(topic);
//        if (individualTopic!=null){
            System.out.println("Publishing into topic" + individualTopic);
            individualTopic.put(message);
//        }
//        else {
//            throw new RuntimeException("Topic does not exist");
//        }
    }

    public String consume(String topic) throws InterruptedException {
        BlockingQueue<String> individualTopic = topics.get(topic);
        if (individualTopic!=null){
            return individualTopic.take();
        }
        else {
            throw new RuntimeException("Topic does not exist");
        }
    }

}
