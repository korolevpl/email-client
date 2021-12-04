package ru.ifmo.email.client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ru.ifmo.email.client.EmailClient;
import ru.ifmo.email.client.exception.EmailClientException;
import ru.ifmo.email.model.Message;

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
            fldEmailAddress.clear();
            txtEmailContent.clear();
            fldMsgTitle.clear();
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
            messages.forEach(msg -> {
                final Text txtContent = new Text(msg.getContent());
                txtContent.setTextAlignment(TextAlignment.LEFT);

                final TitledPane titledPane = new TitledPane("From %s Title: %s".formatted(msg.getSenderAddress(), msg.getTitle()), txtContent);
                titledPane.setTextAlignment(TextAlignment.LEFT);

                accInbox.getPanes().add(titledPane);
            });
        } catch (EmailClientException e) {
            // Добавить логгер!
            e.printStackTrace();
        }
    }

    @FXML
    protected void onClearButtonClick() {
        // todo сделать очистку на сервере
        accInbox.getPanes().clear();

        // todo а потом перезагрузить письма
//        onRefreshButtonClick();
    }
}