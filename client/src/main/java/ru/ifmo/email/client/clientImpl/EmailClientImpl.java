package ru.ifmo.email.client.clientImpl;

import ru.ifmo.email.client.EmailClient;
import ru.ifmo.email.client.exception.EmailClientException;
import ru.ifmo.email.communication.Request;
import ru.ifmo.email.communication.Response;
import ru.ifmo.email.model.Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EmailClientImpl implements EmailClient {
    private final List<Message> messages = new ArrayList<Message>();

    @Override
    public void registerMyEmail(String email) throws EmailClientException {

    }

    @Override
    public void send(Message message, String recipient) throws EmailClientException {

    }

    @Override
    public List<Message> loadEmails() throws EmailClientException {
        return new ArrayList<>(messages);
    }

    private Response sendRequest (Request r) throws EmailClientException {
       try {
           Socket socket = new Socket("127.0.0.1", 5000);
           ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
           ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
           out.writeObject(r);
           return (Response) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new EmailClientException("Email not found", e);
        }

    }
}
