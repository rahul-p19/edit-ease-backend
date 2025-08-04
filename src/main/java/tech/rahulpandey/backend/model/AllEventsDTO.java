package tech.rahulpandey.backend.model;

public class AllEventsDTO {
    String name;
    String slug;
    String description;
    EventCategory category;

    public AllEventsDTO(Event event) {
        this.name = event.getName();
        this.slug = event.getSlug();
        this.description = event.getDescription();
        this.category = event.getCategory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }
}
