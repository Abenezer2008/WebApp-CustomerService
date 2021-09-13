package webshop.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import webshop.dto.CustomerDTO;
import webshop.dto.CustomerOrderedEventDTO;
import webshop.service.CustomerService;

@Service
public class Receiver {
    @Autowired
    private CustomerService customerService;
    @KafkaListener(topics = {"customerOrdered"})
    public void receiveProductOrderedEvent(@Payload CustomerOrderedEventDTO eventDTO){
        System.out.println("Received Message : " + eventDTO);
        CustomerDTO customerDTO = customerService.getCustomer(eventDTO.getCustomerId());
        System.out.println("Sending Email to Customer with email address : " + customerDTO.getEmail());
    }
}
