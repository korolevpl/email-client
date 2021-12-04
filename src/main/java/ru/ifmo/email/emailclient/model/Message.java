package ru.ifmo.email.emailclient.model;

public class Message {
    private String senderAddress;
    private String title;
    private String content;

    public Message(String senderAddress, String title, String content) {
        this.senderAddress = senderAddress;
        this.title = title;
        this.content = content;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
