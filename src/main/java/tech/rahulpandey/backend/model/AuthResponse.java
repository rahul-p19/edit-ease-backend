package tech.rahulpandey.backend.model;

public class AuthResponse {
    private String token;
    private String role;
    private String slug;
    private boolean ok;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public AuthResponse(Boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }

    public AuthResponse(String token, String role, String slug, Boolean ok) {
        this.token = token;
        this.role = role;
        this.slug = slug;
        this.ok = ok;
    }
}
