package tech.rahulpandey.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.service.EventService;
import tech.rahulpandey.backend.service.RestClientService;
import tech.rahulpandey.backend.service.JsonService;

import java.io.IOException;

@RestController
@RequestMapping("/api/events")
public class EventDataController {

    private final RestClientService restClientService;
    private final JsonService jsonService;
    private final EventService eventService;

    public EventDataController(RestClientService restClientService, JsonService jsonService, EventService eventService) {
        this.restClientService = restClientService;
        this.jsonService = jsonService;
        this.eventService = eventService;
    }

    @PutMapping("/{path}")
    public ResponseEntity<Event> updateEventData(@PathVariable String path, @RequestBody Event event) throws IOException {
            String sha = restClientService.getFileSha(path);
            String githubReqBody = jsonService.buildRequestBody(sha,event);
            System.out.println( githubReqBody);
            restClientService.updateFileContent(path, githubReqBody);

        Event updatedEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    // add a get mapping method to fetch event data from a database
    @GetMapping("/{path}")
    public ResponseEntity<Event> getEventData(@PathVariable String path) throws IOException {
        Event event = eventService.getEventBySlug(path);
        return ResponseEntity.ok(event);
    }
}
