package tech.kipper.emailservice.exception;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
