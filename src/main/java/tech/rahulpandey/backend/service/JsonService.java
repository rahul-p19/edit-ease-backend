package tech.rahulpandey.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import tech.rahulpandey.backend.model.AllEventsDTO;
import tech.rahulpandey.backend.model.Event;
import tech.rahulpandey.backend.model.FileContentDTO;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class JsonService {

    private final ObjectMapper objectMapper;

    public JsonService(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public String extractShaFromResponse(String res) {
        try{
            JsonNode jsonNode = objectMapper.readTree(res);
            return jsonNode.get("sha").asText();
        }catch(JsonProcessingException e){
            System.err.println("Error while extracting sha: "+e.getMessage());
        }
        return null;
    }

    public FileContentDTO extractContentFromResponse(String res) {
        try{
            JsonNode jsonNode = objectMapper.readTree(res);
            String sha = jsonNode.get("sha").asText();
            String content = jsonNode.get("content").asText();
            return new FileContentDTO(sha,content);
        }catch(JsonProcessingException e){
            System.err.println("Error while extracting sha: "+e.getMessage());
        }
        return null;
    }

    public String buildRequestBody(String sha, Event event) throws JsonProcessingException {
        String eventJson = objectMapper.writeValueAsString(event);
        String content = Base64.getEncoder().encodeToString(eventJson.getBytes());
        return formatRequest(sha,content,"update "+event.getSlug()+" data ");
    }

    private String formatRequest(String sha, String content, String message) throws JsonProcessingException{
        Map<String,String> data = new HashMap<>();
        if(sha != null) data.put("sha",sha);
        data.put("content",content);
        data.put("message","chore: "+message);

        return objectMapper.writeValueAsString(data);
    }

    public String allEventsToString(List<Event> events) throws JsonProcessingException {
        List<AllEventsDTO> allEvents = new ArrayList<>();
        events.forEach(event -> allEvents.add(new AllEventsDTO(event)));
        return objectMapper.writeValueAsString(allEvents);
    }

    public String formatAllEventsBody(String jsonString, String sha) throws JsonProcessingException {
        String encodedContent = Base64.getEncoder().encodeToString(jsonString.getBytes());
        return formatRequest(sha, encodedContent, " update allEvents via cron");
    }

}
