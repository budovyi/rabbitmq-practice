package com.budovyi.rabbitmqpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Deprecated
public class Initialization {

  /*  @Bean
    @Primary

    MessageProducer messageProducer () {
        MessageProducer messageProducer = new MessageProducer();
        messageProducer.connection();
        return messageProducer;
    }

    @Bean
    MessageConsumer messageConsumer() throws Exception {
        MessageConsumer messageConsumer = new MessageConsumer();
        messageConsumer.connection();
        return messageConsumer;
    }*/
}
