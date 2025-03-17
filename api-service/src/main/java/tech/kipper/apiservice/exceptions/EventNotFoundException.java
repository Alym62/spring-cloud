package tech.kipper.apiservice.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException() {
        super("Ops! Event não encontrado.");
    }
}
