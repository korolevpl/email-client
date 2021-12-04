package ru.ifmo.email.emailclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.ifmo.email.emailclient.controller.EmailClientController;
import ru.ifmo.email.emailclient.mock.EmailClientMock;

import java.io.IOException;

public class EmailApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmailClientController.class.getResource("email-client-view.fxml"));
        fxmlLoader.setControllerFactory(c -> new EmailClientController(
                // Здесь должна быть ваша реализация клиента вместо mock.
                new EmailClientMock("test@ifmo.ru"))
        );
        Scene sendScene = new Scene(fxmlLoader.load(), 520, 440);
        stage.setTitle("IFMO Email client");
        stage.setScene(sendScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}