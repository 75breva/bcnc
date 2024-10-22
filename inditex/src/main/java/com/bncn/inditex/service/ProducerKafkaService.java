package com.bncn.inditex.service;

import com.bncn.inditex.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafkaService {


//    @Autowired
//    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final ProducerEventsService customerEventsService;

    public ProducerKafkaService(ProducerEventsService customerEventsService) {
        super();
        this.customerEventsService = customerEventsService;
    }


    public  void save(Customer customer) {
        System.out.println("Received " + customer);
        this.customerEventsService.publish(customer);
        //return customer;

    }

}
