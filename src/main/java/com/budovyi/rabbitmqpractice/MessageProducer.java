package com.budovyi.rabbitmqpractice;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;

public class MessageProducer {

    private static final String QUEUE = "vova-queue-practice";

   /* public static void main(String[] args) {
        MessageProducer.connection();
    }*/

     void connection ()  {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("185.172.129.14");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            sendMessage(channel);
            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(Channel channel) throws IOException {
        channel.queueDeclare(QUEUE, false, false, false, null);

        String message = "there is my message.";
        channel.basicPublish("", QUEUE, null, message.getBytes());
    }

}
