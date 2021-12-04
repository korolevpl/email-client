package ru.ifmo.email.emailclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import ru.ifmo.email.emailclient.EmailClient;
import ru.ifmo.email.emailclient.exception.EmailClientException;
import ru.ifmo.email.emailclient.model.Message;

import java.util.List;

public class EmailClientController {

    @FXML
    private TextField fldEmailAddress;

    @FXML
    private TextField fldMsgTitle;

    @FXML
    private TextArea txtEmailContent;

    @FXML
    private Accordion accInbox;

    private final EmailClient emailClient;

    public EmailClientController(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @FXML
    protected void onSendEmailButtonClick() {
        final Message msg = new Message(null, fldMsgTitle.getText(), txtEmailContent.getText());
        try {
            emailClient.send(msg, fldEmailAddress.getText());
            fldEmailAddress.setText("");
            txtEmailContent.setText("");
        } catch (EmailClientException e) {
            // Использовать логгер!
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRefreshButtonClick() {
        try {
            final List<Message> messages = emailClient.loadEmails();
            accInbox.getPanes().clear();
            messages.forEach(msg -> accInbox.getPanes().add(
                    new TitledPane("From %s Title: %s".formatted(msg.getSenderAddress(), msg.getTitle()),
                            new Text(msg.getContent()))));
        } catch (EmailClientException e) {
            // Добавить логгер!
            e.printStackTrace();
        }
    }
}