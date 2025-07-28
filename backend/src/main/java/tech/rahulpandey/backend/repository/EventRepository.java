package tech.rahulpandey.backend.repository;

import org.springframework.data.repository.CrudRepository;
import tech.rahulpandey.backend.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findEventBySlug(String slug);
}
