package com.RabbitMQ;

import com.rabbitmq.client.*;

import javax.security.auth.callback.Callback;
import java.io.IOException;

public class Receiver {

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory(); // need default

        // need to keep connection open to keep receiving messages
       Connection connection = factory.newConnection();

          Channel channel = connection.createChannel();
          channel.queueDeclare("hello-world",false,false,false,null);

         channel.basicConsume("hello-world", true, (consumerTag, message) -> {
             String m = new String(message.getBody(), "UTF-8");
             System.out.println("Received the message = " + m);

         }, consumerTag -> {

         });





    }

}
