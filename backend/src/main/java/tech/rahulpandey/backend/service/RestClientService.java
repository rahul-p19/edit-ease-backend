package tech.rahulpandey.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;

@Service
public class RestClientService {

    private final String accessToken;

    private final RestClient restClient;

    private final JsonService jsonService;

    public RestClientService(RestClient.Builder restClientBuilder,  JsonService jsonService, @Value("${github.username}") String owner,@Value("${github.repo}") String repo,@Value("${github.access.token}") String accessToken) {
        String url = String.format("https://api.github.com/repos/%s/%s/contents/frontend/src/assets/eventData/", owner, repo);
        restClient = restClientBuilder.baseUrl(url).build();
        this.jsonService = jsonService;
        this.accessToken = accessToken;
    }

    // method to get SHA for required file
    public String getFileSha(String path) {
        try{
            String res =  restClient.get()
                    .uri(path+".json")
                    .header("Authorization", "Bearer "+accessToken)
                    .header("Accept", "application/vnd.github+json")
                    .header("X-GitHub-Api-Version", "2022-11-28")
                    .retrieve()
                    .body(String.class);
            return jsonService.extractShaFromResponse(res);
        }catch (Exception e){
            System.out.println("Error while fetching file contents: "+e.getMessage());
            return null;
        }
    }

    // method to update contents of required file
    public void updateFileContent(String path, String requestBody){
        restClient.put()
                .uri(path+".json")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .header("Authorization", "Bearer "+accessToken)
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .retrieve()
                .toBodilessEntity();
    }
}
