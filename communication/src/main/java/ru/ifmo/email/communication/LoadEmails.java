package ru.ifmo.email.communication;

import ru.ifmo.email.model.Message;

import java.util.ArrayList;
import java.util.List;

public class LoadEmails implements Command {
    List<String> emails = new ArrayList<>();

    LoadEmails (List<Message> messages) {
        for (Message message : messages) {
            emails.add(message.getSenderAddress());
        }
    }

    public List<String> getMessages() {
        return emails;
    }
}
