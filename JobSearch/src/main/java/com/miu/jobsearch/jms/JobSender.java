package com.miu.jobsearch.jms;

import com.miu.jobsearch.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobSender {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Value("${springjms.queueName}")
    private String queueName;
    public Object send(Client client){
         jmsTemplate.convertAndSend(queueName, client);
         return client;
    }
}
