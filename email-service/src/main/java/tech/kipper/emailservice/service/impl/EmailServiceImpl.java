package tech.kipper.emailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tech.kipper.emailservice.exception.EmailServiceException;
import tech.kipper.emailservice.service.EmailService;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender sender;

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = sendEmailMailTrap(toEmail, subject, body);
        sender.send(message);
    }

    private static SimpleMailMessage sendEmailMailTrap(String toEmail, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);

            return message;
        } catch (MailException exception) {
            throw new EmailServiceException("Ops! Ocorreu um erro ao tentar enviar o email.", exception);
        }
    }
}
