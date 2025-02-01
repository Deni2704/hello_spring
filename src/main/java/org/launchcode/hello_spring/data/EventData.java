package org.launchcode.hello_spring.data;

import org.launchcode.hello_spring.models.Event;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    private static final Map<Integer, Event> events = new HashMap<>();
    public static Collection<Event> getAll(){
        return events.values();
    }
    public static Event getById(int id){
        return events.get(id);
    }
    public static void add(Event event){
        events.put(event.getId(), event);
    }
    public static void remove(int id){
        events.remove(id);
    }

}
