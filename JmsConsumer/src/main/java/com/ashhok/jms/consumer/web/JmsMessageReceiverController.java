package com.ashhok.jms.consumer.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashhok.jms.consumer.listener.JmsListenerService;
import com.ashhok.jms.models.MessageModel;

@RestController
public class JmsMessageReceiverController {

    @Autowired
    private JmsListenerService jls;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getMessages() {
        return prepareText();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Map<String, List<String>> getAllMessages() {
        Map<String, List<String>> retval = new HashMap<>();
        retval.put("string_messages",jls.getMessages());
        List<String> mmstr = new ArrayList<>();
        for (MessageModel mm : jls.getModels()) {
            mmstr.add(mm.toString());
        }
        retval.put("object_messages", mmstr);
        return retval;
    }

    private String prepareText() {
        StringBuilder sb = new StringBuilder();
        List<String> messages = jls.getMessages();
        sb.append("Total Text Messages received: " + messages.size() + "<br>");
        for (String msg : messages) {
            sb.append(msg + "<br>");
        }
        sb.append("------------------------------<br>");
        List<MessageModel> models = jls.getModels();
        sb.append("Total Message Objects received: " + models.size() + "<br>");
        for (MessageModel mm : models) {
            sb.append(mm.toString() + "<br>");
        }
        return sb.toString();
    }
}
