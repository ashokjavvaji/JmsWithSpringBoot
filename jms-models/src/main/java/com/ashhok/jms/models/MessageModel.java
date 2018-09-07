package com.ashhok.jms.models;

public class MessageModel {
    int number;
    String text;

    public MessageModel() {
    }

    public MessageModel(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessageModel [number=" + number + ", text=" + text + "]";
    }
}
