package com.stackroute.service;

import com.stackroute.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RabbitMqService implements RabbitListenerConfigurer {

    @Autowired
    TriggerClass triggerClass;
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);

    /*
    Specify RabbitListener annotation providing queue name
     */
    @RabbitListener(queues="${spring.rabbitmq.queue}")
    public void recievedMessage(Employee employee) {
        // Call getEmployeeId(employee);
        // Call getEmployeeName(employee);
    	//System.out.println(triggerClass.getEmployeeName(employee));
    	triggerClass.getEmployeeId(employee);
    	triggerClass.getEmployeeName(employee);
    }

    public String getEmployeeId(Employee employee) {
    	//System.out.println(triggerClass.getEmployeeName(employee));
        return "Id received from RabbitMQ:"+triggerClass.getEmployeeId(employee);
    }

    public String getEmployeeName(Employee employee) {
        return "Name received from RabbitMQ:"+triggerClass.getEmployeeName(employee);
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
