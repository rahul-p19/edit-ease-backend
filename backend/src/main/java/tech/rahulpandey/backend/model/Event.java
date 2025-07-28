package tech.rahulpandey.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    private String slug;

    @Column(unique = true)
    private String name;

    private String description;

    private List<String> rules;

    private EventCategory category;

    private List<String> prizes;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date registrationDeadline;

    private String teamSize;

    private List<String> eventDates;

    @ElementCollection
    private List<Organiser> organisers;

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

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public List<String> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public List<String> getEventDates() {
        return eventDates;
    }

    public void setEventDates(List<String> eventDates) {
        this.eventDates = eventDates;
    }

    public List<Organiser> getOrganisers() {
        return organisers;
    }

    public void setOrganisers(List<Organiser> organisers) {
        this.organisers = organisers;
    }


    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", rules=" + rules +
                ", category=" + category +
                ", prizes=" + prizes +
                ", registrationDeadline=" + registrationDeadline +
                ", teamSize='" + teamSize + '\'' +
                ", eventDates=" + eventDates +
                ", organisers=" + organisers.iterator().next().toString() +
                '}';
    }
}
