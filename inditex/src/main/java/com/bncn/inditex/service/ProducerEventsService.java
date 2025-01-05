package com.bncn.inditex.service;


import com.bncn.inditex.avro.Customer;
import com.bncn.inditex.events.CustomerCreatedEvent;
import com.bncn.inditex.events.Event;
import com.bncn.inditex.events.EventType;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class ProducerEventsService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
//	@Value("${topic.customer.name:customers}")
//	private String topicCustomer;

	public void publish(Customer customer) {

//		CustomerCreatedEvent created = new CustomerCreatedEvent();
//		created.setData(customer);
//		created.setId(UUID.randomUUID().toString());
//		created.setType(EventType.CREATED);
//		created.setDate(new Date());

		//this.kafkaTemplate.send("mi-topico", created);


		CompletableFuture<SendResult<String, Customer>> future = kafkaTemplate.send("mi-topico", UUID.randomUUID().toString(),customer);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("Sent message=[" + customer +
						"] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" +
						customer + "] due to : " + ex.getMessage());
			}
		});
	}
	
	

}
