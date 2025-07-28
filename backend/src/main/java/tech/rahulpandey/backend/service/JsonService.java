package tech.rahulpandey.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import tech.rahulpandey.backend.model.Event;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

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
            System.out.println("Error while extracting sha: "+e.getMessage());
        }
        return null;
    }

    public String buildRequestBody(String sha, Event event) throws JsonProcessingException {
        String eventJson = objectMapper.writeValueAsString(event);
        System.out.println(eventJson);
        String content = Base64.getEncoder().encodeToString(eventJson.getBytes());

        Map<String,String> data = new HashMap<>();
        if(sha != null) data.put("sha",sha);
        data.put("content",content);
        data.put("message","chore: update "+event.getName()+" content");

        return objectMapper.writeValueAsString(data);
    }

}
