package tech.kipper.apiservice.mapper;

import tech.kipper.apiservice.domain.Event;
import tech.kipper.apiservice.dtos.EventRequestDto;
import tech.kipper.apiservice.dtos.EventResponseDto;

public class EventMapper {
    private EventMapper() {
    }

    public static EventResponseDto entityToDtoResponse(Event entity) {
        return EventResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .startEvent(entity.getStartEvent())
                .endEvent(entity.getEndEvent())
                .maxParticipant(entity.getMaxParticipants())
                .build();
    }

    public static Event dtoRequestToEntity(EventRequestDto dto) {
        Event event = new Event();
        event.setName(dto.name());
        event.setDescription(dto.description());
        event.setStartEvent(dto.startEvent());
        event.setEndEvent(dto.endEvent());
        event.setMaxParticipants(dto.maxParticipant());

        return event;
    }
}
