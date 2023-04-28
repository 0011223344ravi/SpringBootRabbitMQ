package com.example.springbootrabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public static final String QUEUE = "q3";
    public static final String EXCHANGE = "e3";
    public static final String ROUTING_KEY = "rk3";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }

     @Bean
    public Binding binding(Queue queue,DirectExchange directExchange){
      return BindingBuilder.bind(queue).to(directExchange).with(ROUTING_KEY);
     }

     @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
     }

     @Bean
    public AmqpTemplate  getTemplate(ConnectionFactory connectionFactory){
         RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
           rabbitTemplate.setMessageConverter(messageConverter());
           return rabbitTemplate;
     }
}
