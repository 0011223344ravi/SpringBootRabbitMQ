package com.example.springbootrabbitmq.producer;

import com.example.springbootrabbitmq.config.RabbitMQConfig;
import com.example.springbootrabbitmq.entity.Order;
import com.example.springbootrabbitmq.entity.OrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderProducer {
    @Autowired
    private RabbitTemplate template;
     @PostMapping("/order")
    public OrderDto order(@RequestBody  Order order ) {

          OrderDto orderDto = new OrderDto(order,"Order Placed ", "Hi Comsumer is Place" +
                  "from publisher");

        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY,orderDto);
        return orderDto;

     }
}
