package tech.rahulpandey.backend.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.service.EventService;
import tech.rahulpandey.backend.service.JsonService;
import tech.rahulpandey.backend.service.RestClientService;

import java.util.List;

@Component
public class EventScheduler {

    private final EventService eventService;

    private final JsonService jsonService;

    private final RestClientService restClientService;

    @Autowired
    public EventScheduler(EventService eventService, JsonService jsonService, RestClientService restClientService) {
        this.eventService = eventService;
        this.jsonService = jsonService;
        this.restClientService = restClientService;
    }

    @Scheduled(cron = "0 40 0 * * *")
    public boolean updateAllEventsData() {
        try {
            List<Event> allEvents = (List<Event>) eventService.getAllEvents();
            String sha = restClientService.getFileSha("allEvents");
            String requestBody = jsonService.formatAllEventsBody(allEvents,sha);
            restClientService.updateFileContent(sha, requestBody);
            return true;
        } catch (Exception e) {
            System.err.println("Error occurred while updating allEvents: " + e.getMessage());
            return false;
        }
    }

}
