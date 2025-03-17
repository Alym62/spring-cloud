package tech.kipper.apiservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.kipper.apiservice.domain.Event;
import tech.kipper.apiservice.domain.Subscription;
import tech.kipper.apiservice.dtos.EmailRequestDto;
import tech.kipper.apiservice.dtos.EventIdResponseDto;
import tech.kipper.apiservice.dtos.EventRequestDto;
import tech.kipper.apiservice.dtos.EventResponseDto;
import tech.kipper.apiservice.exceptions.EventFullException;
import tech.kipper.apiservice.exceptions.EventNotFoundException;
import tech.kipper.apiservice.mapper.EventMapper;
import tech.kipper.apiservice.repositories.EventRepository;
import tech.kipper.apiservice.repositories.SubscriptionRepository;
import tech.kipper.apiservice.client.EmailService;
import tech.kipper.apiservice.service.EventService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final EmailService emailService;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public List<EventResponseDto> list() {
        return repository.findAll()
                .stream()
                .map(EventMapper::entityToDtoResponse).toList();
    }

    @Override
    public List<EventResponseDto> getUpComingEvents() {
        return repository.findUpComingEvents(LocalDateTime.now())
                .stream()
                .map(EventMapper::entityToDtoResponse).toList();
    }

    @Override
    public EventIdResponseDto create(EventRequestDto dto) {
        Event event = repository.save(EventMapper.dtoRequestToEntity(dto));
        return new EventIdResponseDto(event.getId());
    }

    @Override
    public void registerParticipant(UUID eventId, String emailParticipant) {
        Event event = repository.findById(eventId)
                .orElseThrow(EventNotFoundException::new);

        if (isEventFull(event)) throw new EventFullException();

        subscriptionRepository.save(new Subscription(event, emailParticipant));

        event.setRegisteredParticipant(event.getRegisteredParticipant() + 1);

        emailService.sendEmail(new EmailRequestDto(emailParticipant, "Confirmação de Inscrição", "Você foi inscrito no evento com sucesso!"));
    }

    private Boolean isEventFull(Event event) {
        return event.getRegisteredParticipant() >= event.getMaxParticipants();
    }
}
