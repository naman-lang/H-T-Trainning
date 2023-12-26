package com.stackroute;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerServiceApplication {

    /*
     * to host, username, password from application.yml
     */
	@Value("${spring.rabbitmq.host}")
	String myhost;
	
	@Value("${spring.rabbitmq.username}")
	String username;
	
	@Value("${spring.rabbitmq.password}")
	String password;


    public static void main(String[] args) {
        SpringApplication.run(ProducerServiceApplication.class, args);
    }

    /*
    * Create a connection factory bean
    */
    @Bean
    ConnectionFactory connectionFactory() {
    	CachingConnectionFactory cachfactory=new CachingConnectionFactory(myhost);
		cachfactory.setUsername(username);
		cachfactory.setPassword(password);
		return cachfactory;

    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /*
    * Define rabbitTemplate and setMessageConverter
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    	RabbitTemplate rtemp=new RabbitTemplate(connectionFactory);
		rtemp.setMessageConverter(jsonMessageConverter());
		return rtemp;

    }
}
