package com.ashhok.jms.consumer.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashhok.jms.models.MessageModel;

@Service
public class JmsListenerService {
    List<String> messages = new ArrayList<>();
    List<MessageModel> models = new ArrayList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addModel(MessageModel mm) {
        models.add(mm);
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<MessageModel> getModels() {
        return models;
    }
}
