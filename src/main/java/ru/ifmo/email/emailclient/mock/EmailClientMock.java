package ru.ifmo.email.emailclient.mock;

import ru.ifmo.email.emailclient.EmailClient;
import ru.ifmo.email.emailclient.exception.EmailClientException;
import ru.ifmo.email.emailclient.model.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailClientMock implements EmailClient {
    private final List<Message> inbox = new ArrayList<>();
    private final String senderEmail;


    public EmailClientMock(String senderEmail) {
        this.senderEmail = senderEmail;
        // Заполняем тестовыми данными
        inbox.addAll(
                List.of(
                        new Message(
                                "principal@ifmo.ru",
                                "Quarantine",
                                """
                                        Hello!
                                        
                                        Stay home!
                                        """
                        ),

                        new Message(
                                "accountant@ifmo.ru",
                                "Salary",
                                """
                                        Hello!
                                        
                                        No salary this time, enjoy :-P
                                        """
                        ),

                        new Message(
                                "prepod@ifmo.ru",
                                "That's it!",
                                """
                                        Hi!
                                        
                                        I can't stand it anymore!
                                        Goodbye!
                                        """
                        )
                )
        );
    }

    @Override
    public void send(Message message, String recipient) throws EmailClientException {
        // Т.к. это тестовый класс, то шлём письмо самому себе
        message.setSenderAddress(senderEmail);
        inbox.add(message);
    }

    @Override
    public List<Message> loadEmails() throws EmailClientException {
        return Collections.unmodifiableList(inbox);

    }
}
