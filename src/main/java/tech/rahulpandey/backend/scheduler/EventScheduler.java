package tech.rahulpandey.backend.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.model.FileContentDTO;
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

    @Scheduled(cron = "0 40 1 * * *", zone = "Asia/Kolkata")
    public boolean updateAllEventsData() {
        try {
            // get all events from db
            List<Event> allEvents = (List<Event>) eventService.getAllEvents();

            // get file content from GitHub api
            FileContentDTO fileContent = restClientService.getFileContent("allEvents");
            String sha = fileContent.getSha();
            String githubFile = fileContent.getContent();
            String databaseFile  = jsonService.allEventsToString(allEvents);

            // exit if there is no change
            if(githubFile.equals(databaseFile)) return false;

            String requestBody = jsonService.formatAllEventsBody(databaseFile,sha);
            restClientService.updateFileContent("allEvents", requestBody);
            return true;
        } catch (Exception e) {
            System.err.println("Error occurred while updating allEvents: " + e.getMessage());
            return false;
        }
    }

}
