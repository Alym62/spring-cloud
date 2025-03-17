package tech.kipper.apiservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kipper.apiservice.dtos.EventIdResponseDto;
import tech.kipper.apiservice.dtos.EventRequestDto;
import tech.kipper.apiservice.dtos.EventResponseDto;
import tech.kipper.apiservice.dtos.SubscriptionRequestDto;
import tech.kipper.apiservice.service.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService service;

    @GetMapping("/list")
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<EventResponseDto>> getUpcomingEvents() {
        return ResponseEntity.ok().body(service.getUpComingEvents());
    }

    @PostMapping("/create")
    public ResponseEntity<EventIdResponseDto> createEvent(@RequestBody EventRequestDto dto) {
        return ResponseEntity.ok().body(service.create(dto));
    }

    @PostMapping("/{eventId}/register")
    public ResponseEntity<String> registerParticipant(@PathVariable UUID eventId, @RequestBody SubscriptionRequestDto dto) {
        service.registerParticipant(eventId, dto.emailParticipant());
        return ResponseEntity.ok().body("Participante registrado com sucesso!");
    }
}
