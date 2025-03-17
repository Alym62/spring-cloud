package tech.kipper.apiservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.kipper.apiservice.dtos.EmailRequestDto;

@FeignClient(value = "email-service")
public interface EmailService {
    @PostMapping("/api/email/send")
    void sendEmail(@RequestBody EmailRequestDto dto);
}
