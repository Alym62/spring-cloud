package tech.kipper.emailservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kipper.emailservice.dto.EmailRequestDto;
import tech.kipper.emailservice.service.EmailService;

@RestController
@RequestMapping("api/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService service;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDto emailRequest) {
        service.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
        return ResponseEntity.ok("Email sent successfully!");
    }
}
