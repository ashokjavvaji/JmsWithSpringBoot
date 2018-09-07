package com.ashhok.jms.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.ashhok.jms.models.MessageModel;

@Component
public class JmsListenerComp {

    @Autowired
    JmsTemplate jms;

    @Autowired
    JmsListenerService jls;

    @JmsListener(destination = "queue.text", containerFactory = "myFactory")
    public void receiveTextMessage(String message) {
        // String message = (String) jms.receiveAndConvert("queue.text");
        System.out.println("---------------------------------");
        System.out.println("MSG: " + message);
        System.out.println("---------------------------------");
        jls.addMessage(message);
    }

    @JmsListener(destination = "queue.model", containerFactory = "myFactory")
    public void receiveModelMessage(MessageModel mm) {
        // MessageModel mm = (MessageModel) jms.receiveAndConvert("queue.model");
        System.out.println("---------------------------------");
        System.out.println("MessageModel: " + mm.toString());
        System.out.println("---------------------------------");
        jls.addModel(mm);
    }
}
