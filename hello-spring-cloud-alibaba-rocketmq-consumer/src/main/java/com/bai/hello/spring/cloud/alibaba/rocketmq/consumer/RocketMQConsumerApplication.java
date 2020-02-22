package com.bai.hello.spring.cloud.alibaba.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@EnableBinding({Sink.class})
public class RocketMQConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class, args);
    }

    @StreamListener("input")
    public void receiveInput(String message) {
        System.out.println("receive:" + message);
    }

    /*@StreamListener("input")
    public void receiveInput(@Payload Foo foo) {
        System.out.println("receive:" + foo.getBar() + "\t" + foo.getId());
    }*/
}
