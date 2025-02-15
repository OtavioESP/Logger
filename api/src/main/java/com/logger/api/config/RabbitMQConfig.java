package com.logger.api.config;

import com.logger.api.domain.logger.LoggerMessageDTO;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Bean
    public DirectExchange declareExchange() {
        return ExchangeBuilder.directExchange(exchangeName).durable(true).build();
    }

    @Bean
    public Queue declareQueue() {
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    public Binding declareBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();

        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);

        // Explicitly allow only the LoggerMessageDTO class
        Map<String, Class<?>> trustedTypes = new HashMap<>();
        trustedTypes.put("com.logger.api.domain.logger.LoggerMessageDTO", LoggerMessageDTO.class);

        typeMapper.setIdClassMapping(trustedTypes);
        converter.setJavaTypeMapper(typeMapper);
        return converter;
    }
}
