package tech.kipper.apiservice.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventRequestDto(
        String description,
        String name,
        LocalDateTime startEvent,
        LocalDateTime endEvent,
        int maxParticipant
) {
}
