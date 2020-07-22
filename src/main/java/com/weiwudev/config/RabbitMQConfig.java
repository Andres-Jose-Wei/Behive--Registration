package com.weiwudev.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.client.AMQP.Exchange;

/**
 * RabbitMQ main configurations used throughout the application.
 * @author Wei Wu,
 */
@Configuration
public class RabbitMQConfig {

    /**
     * This {@link String}
     */
    public final static String userRegistrationQueue = "user_registration_queue";

    /**
     * This {@link String}
     */
    public final static String userRegistrationRoutingKey = "user_registration_queue_key";

    /**
     * This {@link String}
     */
    public final static String userRegistrationExchange = "user_registration_queue_exchange";


    /**
     * Creates a {@link Queue}
     * @return a {@link Queue} e
     */
    @Bean
    public Queue userRegQueue() {
        return new Queue(userRegistrationQueue, true);
    }


    /**
     * Creates an {@link DirectExchange}
     * @return a {@link DirectExchange}
     */
    @Bean
    public DirectExchange userRegExchange() {
        return new DirectExchange(userRegistrationExchange);
    }


    /**
     * Binds a {@link Queue} to an {@link DirectExchange} with the routing key.
     * @param queueForms represents a {@link Queue} element which will be bound to an exchange.
     * @param exchangeForms represents the {@link Exchange} a queue will be bound to.
     * @return a {@link Binding} between a {@link Queue} and an {@link DirectExchange}
     */
    @Bean
    public Binding userRegBinding(Queue userRegQueue, DirectExchange userRegExchange) {
        return BindingBuilder.bind(userRegQueue).to(userRegExchange).with(userRegistrationRoutingKey);
    }


    /**
     * Creates a {@link MessageConverter} for converting JSON data.
     * @return a {@link MessageConverter} used to convert object before passing them to a {@link DirectExchange}
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
