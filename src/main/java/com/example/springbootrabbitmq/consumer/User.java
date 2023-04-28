package com.example.springbootrabbitmq.consumer;

import com.example.springbootrabbitmq.config.RabbitMQConfig;
import com.example.springbootrabbitmq.entity.OrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeMessageFromQueue(OrderDto orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }

}
