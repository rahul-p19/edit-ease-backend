package tech.rahulpandey.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.service.EventService;
import tech.rahulpandey.backend.service.RestClientService;
import tech.rahulpandey.backend.service.JsonService;

import java.io.IOException;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Event APIs", description = "View and Edit Event Data")
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
        String sha = restClientService.getFileContent(path).getSha();
        String githubReqBody = jsonService.buildRequestBody(sha, event);
        restClientService.updateFileContent(path, githubReqBody);

        Event updatedEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @GetMapping("/{path}")
    public ResponseEntity<Event> getEventData(@PathVariable String path) {
        Event event = eventService.getEventBySlug(path);
        return ResponseEntity.ok(event);
    }
}
