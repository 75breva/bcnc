package com.bncn.inditex.service;

import com.bncn.inditex.events.CustomerCreatedEvent;
import com.bncn.inditex.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service // Se puede poner @Component si por ejemplo indicas que esta clase no va a a realizar nada como, analizar ,guardar , enviar datos. Poner que es un @Service estas indicando algo mas especifico y por lo tanto que gestionara los datos(guardar en bbdd etc), pero se puede poner las dos.
public class ConsumeKafkaService {

    @KafkaListener(topics = "mi-topico",containerFactory = "kafkaListenerContainerFactory",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Event<?> event) {
        if (event.getClass().isAssignableFrom(CustomerCreatedEvent.class)) {
            CustomerCreatedEvent customerCreatedEvent = (CustomerCreatedEvent) event;
            log.info("Received Customer created event .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }
        //System.out.println("Mensaje recibido: " + event);
    }

}
