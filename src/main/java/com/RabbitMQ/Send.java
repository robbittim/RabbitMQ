package com.RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.time.LocalDateTime;

public class Send {

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();


      try( Connection connection = factory.newConnection()){

          Channel channel = connection.createChannel();
          channel.queueDeclare("hello-world",false,false,false,null);

          String message = "Hello World!" + LocalDateTime.now();

          channel.basicPublish("","hello-world",false,null,message.getBytes());
          System.out.println(" [x] Message sent...");


      }


    }

}
