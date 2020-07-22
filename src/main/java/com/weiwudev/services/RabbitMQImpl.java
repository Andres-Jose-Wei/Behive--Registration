package com.weiwudev.services;

import com.weiwudev.config.RabbitMQConfig;
import com.weiwudev.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQImpl implements MessageService {
    /**
     * Instance of a Rabbit Template.
     */
    private final RabbitTemplate rabbitTemplate;

    /**
     * Instance of a Message Converter.
     */
    private final MessageConverter messageConverter;

    /**
     * Initializes all services.
     *
     * @param rabbitTemplate    Rabbit Template bean.
     * @param messageConverter  Message Converter bean.
     */
    public RabbitMQImpl(RabbitTemplate rabbitTemplate, MessageConverter messageConverter) {
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = messageConverter;
    }


    @Override
    public void sendUserData(User user) {
        rabbitTemplate.setMessageConverter(messageConverter);
            rabbitTemplate.convertAndSend(RabbitMQConfig.userRegistrationExchange, RabbitMQConfig.userRegistrationRoutingKey,
                    user);

    }
}
