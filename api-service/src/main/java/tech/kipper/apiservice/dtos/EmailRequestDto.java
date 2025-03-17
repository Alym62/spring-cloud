package tech.kipper.apiservice.dtos;

import lombok.Builder;

@Builder
public record EmailRequestDto(
        String to,
        String subject,
        String body
) {
}
