package tech.kipper.apiservice.dtos;

import lombok.Builder;

@Builder
public record SubscriptionRequestDto(
        String emailParticipant
) {
}
