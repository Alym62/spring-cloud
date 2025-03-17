package tech.kipper.apiservice.exceptions;

public class EventFullException extends RuntimeException {
    public EventFullException() {
        super("Ops! O evento já está cheio.");
    }
}
