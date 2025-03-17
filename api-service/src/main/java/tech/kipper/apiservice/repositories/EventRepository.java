package tech.kipper.apiservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.kipper.apiservice.domain.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    @Query("""
            SELECT e FROM Event e WHERE e.startEvent > :currentDate
            """)
    List<Event> findUpComingEvents(@Param("currentDate") LocalDateTime currentDate);
}
