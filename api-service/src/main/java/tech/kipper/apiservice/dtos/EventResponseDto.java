package tech.kipper.apiservice.dtos;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record EventResponseDto(
        UUID id,
        String description,
        String name,
        LocalDateTime startEvent,
        LocalDateTime endEvent,
        int maxParticipant,
        int registeredParticipant
) {
}
