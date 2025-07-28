package tech.rahulpandey.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.service.EventService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final EventService eventService;

    @Autowired
    public AdminController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<Iterable<Event>> getAllEvents() {
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }

}
