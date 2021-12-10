package ru.ifmo.email.client.clientImpl;

import ru.ifmo.email.client.EmailClient;
import ru.ifmo.email.client.exception.EmailClientException;
import ru.ifmo.email.model.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/*Добавила класс ObjectOutputStream, который хочу использовать для отправки сообщения - поток для вывода
также для метода send добавила переменную сокет, конструктор для класса

 */

public class EmailClientImpl implements EmailClient {
    private Socket socket;
    private final ObjectOutputStream out;

    public EmailClientImpl(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void registerMyEmail(String email) throws EmailClientException {

    }

    @Override
    public void send(Message message, String recipient) throws EmailClientException {
        synchronized (out) {
            //out.writeObject(message);
        }

    }

    @Override
    public List<Message> loadEmails() throws EmailClientException {
        return null;
    }


}
