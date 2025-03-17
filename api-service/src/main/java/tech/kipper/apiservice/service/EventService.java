package tech.kipper.apiservice.service;

import tech.kipper.apiservice.dtos.EventIdResponseDto;
import tech.kipper.apiservice.dtos.EventRequestDto;
import tech.kipper.apiservice.dtos.EventResponseDto;

import java.util.List;
import java.util.UUID;

public interface EventService {
    List<EventResponseDto> list();
    List<EventResponseDto> getUpComingEvents();
    EventIdResponseDto create(EventRequestDto dto);
    void registerParticipant(UUID eventId, String emailParticipant);
}
