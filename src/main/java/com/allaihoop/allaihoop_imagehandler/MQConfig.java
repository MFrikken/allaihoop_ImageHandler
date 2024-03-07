package com.allaihoop.allaihoop_imagehandler;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class MQConfig {

    public static final String DELETE_IMAGE_QUEUE = "deleteImage_queue";
    public static final String SAVE_IMAGE_QUEUE = "saveImage_queue";

    private static final String DELETE_IMAGE_ROUTINGKEY = "deleteImage";
    private static final String SAVE_IMAGE_ROUTINGKEY = "saveImage";

    private static final String EXCHANGE = "imageExchange";

    @Bean
    public Queue deleteQueue() {
        return new Queue(DELETE_IMAGE_QUEUE);
    }

    @Bean
    public Queue saveQueue() {
        return new Queue(SAVE_IMAGE_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding deleteBinding(Queue deleteQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(deleteQueue)
                .to(exchange)
                .with(DELETE_IMAGE_ROUTINGKEY);
    }

    @Bean
    public Binding saveBinding(Queue saveQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(saveQueue)
                .to(exchange)
                .with(SAVE_IMAGE_ROUTINGKEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
