package ru.ifmo.email.emailclient;

import ru.ifmo.email.emailclient.exception.EmailClientException;
import ru.ifmo.email.emailclient.model.Message;

import java.util.List;

public interface EmailClient {
    void send(Message message, String recipient) throws EmailClientException;

    List<Message> loadEmails() throws EmailClientException;
}
