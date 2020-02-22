package com.bai.hello.spring.cloud.alibaba.rocketmq.provider.service;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProviderService {

    @Autowired
    private MessageChannel output;

    public void send(String message) {
        output.send(MessageBuilder.withPayload(message).build());
    }


    public void sendTag(Object msg, String tag) {
        MessageHeaders headers = new MessageHeaders(Stream.of(tag).collect(Collectors.toMap(str -> MessageConst.PROPERTY_TAGS, String::toString)));
        Message message = MessageBuilder.createMessage(msg, headers);
        output.send(message);
    }
    public void sendObject(Object msg, String tag) {
        Message message = MessageBuilder.withPayload(msg).setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build();
        output.send(message);
    }


}
