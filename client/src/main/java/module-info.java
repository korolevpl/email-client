module ru.ifmo.email.emailclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    requires ru.ifmo.email.model;
    requires ru.ifmo.email.communication;

    opens ru.ifmo.email.client to javafx.fxml;
    exports ru.ifmo.email.client;
    exports ru.ifmo.email.client.exception;
    opens ru.ifmo.email.client.exception to javafx.fxml;
    exports ru.ifmo.email.client.controller;
    opens ru.ifmo.email.client.controller to javafx.fxml;
    exports ru.ifmo.email.client.client;
    opens ru.ifmo.email.client.client to javafx.fxml;
}