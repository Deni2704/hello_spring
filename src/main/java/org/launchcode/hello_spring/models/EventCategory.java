package org.launchcode.hello_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @OneToMany(mappedBy = "eventCategory")
    private List<Event> events = new ArrayList<>();
    public EventCategory(@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name) {
        this.name = name;
    }
    public EventCategory(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return name;
    }
}
