package com.bncn.inditex.service;

import com.bncn.inditex.entity.Customer;
import com.bncn.inditex.events.CustomerCreatedEvent;
import com.bncn.inditex.events.Event;
import com.bncn.inditex.events.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@Slf4j
@Component
public class ProducerEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> kafkaTemplate;
	
//	@Value("${topic.customer.name:customers}")
//	private String topicCustomer;

	public void publish(Customer customer) {

		CustomerCreatedEvent created = new CustomerCreatedEvent();
		created.setData(customer);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		//this.kafkaTemplate.send("mi-topico", created);
		this.kafkaTemplate.send("mi-topico", created);
	}
	
	

}
