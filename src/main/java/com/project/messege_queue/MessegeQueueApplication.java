package com.project.messege_queue;

import com.project.messege_queue.service.ConsumerService;
import com.project.messege_queue.service.MessageQueue;
import com.project.messege_queue.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MessegeQueueApplication {



	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = SpringApplication.run(MessegeQueueApplication.class, args);

		PublisherService publisherService = context.getBean(PublisherService.class);
		ConsumerService consumerService = context.getBean(ConsumerService.class);

		publisherService.createTopics("cricket");
		publisherService.createTopics("tennis");

		publisherService.sendMessage("cricket","cricket message");
		publisherService.sendMessage("tennis","tennis message");

		consumerService.consumeMessage("cricket");
		consumerService.consumeMessage("tennis");



		SpringApplication.run(MessegeQueueApplication.class, args);
	}

}
