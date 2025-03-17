package tech.kipper.apiservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "protocol_event", nullable = false, updatable = false)
    private final String protocolEvent = generateProtocol();

    @Column(name = "description")
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_event", nullable = false)
    private LocalDateTime startEvent;

    @Column(name = "end_event", nullable = false)
    private LocalDateTime endEvent;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "max_participants", nullable = false)
    private int maxParticipants;

    @Column(name = "registered_participant")
    private int registeredParticipant;

    @PrePersist
    public void prePersist() {
        setCreatedAt(LocalDateTime.now());
        setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }

    private static String generateProtocol() {
        return "BR-" + UUID.randomUUID() + "-" + LocalDateTime.now();
    }
}
