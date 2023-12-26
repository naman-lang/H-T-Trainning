package com.stackroute.service;

import com.stackroute.domain.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
	String exchange;
	
	
	@Value("${spring.rabbitmq.routingkey}")
	String routekey;

    
    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /*
     * to exchange and routingkey property values
     */

    public void send(Employee employee) {
        /*
        Convert the employee details and send to RabbitMQ
         */
    	rabbitTemplate.convertAndSend(exchange,routekey,employee);
    }
}
