package ru.ifmo.email.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.ifmo.email.client.controller.EmailClientController;
import ru.ifmo.email.client.exception.EmailClientException;
import ru.ifmo.email.client.mock.EmailClientMock;

import java.io.IOException;

public class EmailApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, EmailClientException {
        final String email = getParameters().getNamed().get("email");
        validateEmail(email);

        // Здесь должна быть ваша реализация клиента, вместо mock.
        final EmailClient emailClient = new EmailClientMock(email);
        emailClient.registerMyEmail(email);


        // Всякая всячина для отрисовки пользовательского интерфейса.
        FXMLLoader fxmlLoader = new FXMLLoader(EmailClientController.class.getResource("email-client-view.fxml"));
        fxmlLoader.setControllerFactory(c -> new EmailClientController(emailClient));
        Scene sendScene = new Scene(fxmlLoader.load(), 520, 440);
        stage.setTitle("IFMO Email client: " + email);
        stage.setScene(sendScene);
        stage.show();
    }

    private void validateEmail(String email) {
        if (email == null) {
            System.err.println("Необходимо запустить программу, указав обязательный параметр --email=email@server.host");
            System.err.println("где 'email' - ваш почтовый логин на сервере, а server.host - имя хоста, либо");
            System.err.println("IP адрес сервера.");
            System.exit(1);
        }

        if (!email.contains("@")) {
            System.err.println("Указанный имейл должен быть в формате: email@server.host");
            System.err.println("где 'email' - ваш почтовый логин на сервере, а server.host - имя хоста, либо");
            System.err.println("IP адрес сервера.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        // Запускать приложение необходимо с параметром --email=<email>, где вместо <email> подставить свой email.
        launch(args);
    }
}