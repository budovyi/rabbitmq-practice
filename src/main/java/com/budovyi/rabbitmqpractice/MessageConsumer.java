package com.budovyi.rabbitmqpractice;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class MessageConsumer {

    private static final String QUEUE_NAME = "vova-queue2-practice";

    /*public static void main(String[] args) throws Exception {
        new MessageConsumer().connection();
    }*/
    @PostConstruct
    void  connection () throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("185.172.129.14");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // in producer need to bind exchange witch queue

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(
                    String consumerTag,
                    Envelope envelope,
                    AMQP.BasicProperties properties,
                    byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println(message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
