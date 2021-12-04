module ru.ifmo.email.server {
    requires ru.ifmo.email.communication;
    requires ru.ifmo.email.model;

    exports ru.ifmo.email.server;
    opens ru.ifmo.email.server;
}