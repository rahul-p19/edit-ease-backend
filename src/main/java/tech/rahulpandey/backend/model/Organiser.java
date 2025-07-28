package tech.rahulpandey.backend.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Organiser {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Organiser{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
