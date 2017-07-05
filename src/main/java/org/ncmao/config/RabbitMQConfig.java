package org.ncmao.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class RabbitMQConfig {

    public static final String FOO_EXCHANGE   = "callback.exchange.foo";
    public static final String FOO_ROUTINGKEY = "callback.routingkey.foo";
    public static final String FOO_QUEUE      = "callback.queue.foo";


    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

    @Bean
    Queue queue(){
        return new Queue(FOO_QUEUE);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(FOO_EXCHANGE);
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with(FOO_ROUTINGKEY);
    }
}
