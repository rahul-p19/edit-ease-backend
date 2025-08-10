package tech.rahulpandey.backend.model;

public class FileContentDTO {
    private String sha;
    private String content;

    public String getSha() {
        return sha;
    }

    public String getContent() {
        return content;
    }

    public FileContentDTO(String sha, String content) {
        this.sha = sha;
        this.content = content;
    }
}
