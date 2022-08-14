package com.miu.myfirstspringjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Value(value = "${springjms.cs544Queue}")
    private String queueName;

    public void sendByConverting(String message){
        jmsTemplate.convertAndSend(queueName,message);
    }
    public void sendWithoutConverting(String message){
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };

        jmsTemplate.send(queueName,messageCreator);
    }
}
