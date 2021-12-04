module ru.ifmo.email.emailclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens ru.ifmo.email.emailclient to javafx.fxml;
    exports ru.ifmo.email.emailclient;
    exports ru.ifmo.email.emailclient.exception;
    opens ru.ifmo.email.emailclient.exception to javafx.fxml;
    exports ru.ifmo.email.emailclient.model;
    opens ru.ifmo.email.emailclient.model to javafx.fxml;
    exports ru.ifmo.email.emailclient.controller;
    opens ru.ifmo.email.emailclient.controller to javafx.fxml;
    exports ru.ifmo.email.emailclient.mock;
    opens ru.ifmo.email.emailclient.mock to javafx.fxml;
}