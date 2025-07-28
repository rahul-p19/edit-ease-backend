package tech.rahulpandey.backend.service;

import org.springframework.stereotype.Service;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event) {
        System.out.println(event.toString());
        return eventRepository.save(event);
    }

    public Event getEventBySlug(String path) {
        return eventRepository.findEventBySlug(path);
    }
}
