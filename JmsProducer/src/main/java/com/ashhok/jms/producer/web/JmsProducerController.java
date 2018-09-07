package com.ashhok.jms.producer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashhok.jms.models.MessageModel;
import com.ashhok.jms.producer.jms.MessageSender;

@RestController
public class JmsProducerController {
    @Autowired
    MessageSender ms;

    @RequestMapping(method = RequestMethod.GET, value = "/{msg}")
    public String sendTextMessage(@PathVariable String msg) {
        ms.sendTextMessage(msg);
        return "Text Message sent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String sendTextMessage(@RequestBody MessageModel mm) {
        ms.sendModelObject(mm);
        return "Message Object sent";
    }
}
