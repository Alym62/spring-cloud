package tech.kipper.emailservice.service;

public interface EmailService {
    void sendEmail(String toEmail, String subject, String body);
}
