package ru.ifmo.email.client.exception;

public class EmailClientException extends Exception {
    public EmailClientException(String message) {
        super(message);
    }

    public EmailClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
