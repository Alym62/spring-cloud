package tech.kipper.apiservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_subscription")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Event event;

    @Column(name = "email_participant", updatable = false)
    private String emailParticipant;

    public Subscription(Event event, String emailParticipant) {
        this.event = event;
        this.emailParticipant = emailParticipant;
    }
}
