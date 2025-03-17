package tech.kipper.apiservice.dtos;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorResponseDto(
        HttpStatus status,
        String message
) {
}
