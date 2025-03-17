package tech.kipper.emailservice.dto;

import lombok.Builder;

@Builder
public record EmailRequestDto(
        String to,
        String subject,
        String body
) {
}
