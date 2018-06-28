package com.izzyacademy.event.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.izzyacademy.event.models.Event;

@Service
public class EventServiceImplementation implements EventService {

	private final Map<Long, Event> events = new HashMap<Long, Event>();
	
	EventServiceImplementation()
	{
		
	}
	
	@PostConstruct
	public void init()
	{
		events.put(100L, new Event(100, "Israel Ekpo Birthday"));
		events.put(200L, new Event(200, "Joshua Ekpo Birthday"));
		events.put(300L, new Event(300, "Angel Ekpo Birthday"));
		events.put(400L, new Event(400, "June Ekpo Birthday"));
	}
	
	@Override
	public Event createEvent(Event event) {
		
		events.put(event.getId(), event);
		
		return events.get(event.getId());
	}
	
	@Override
	public Event getEvent(long eventId) {
		return events.get(eventId);
	}

	@Override
	public Map<Long, Event> getEvents() {
		return events;
	}

	@Override
	public Event updateEvent(long eventId, Event event) {

		events.put(eventId, event);
		
		return events.get(eventId);
	}

	@Override
	public Event deleteEvent(long eventId) {
		
		Event event = events.get(eventId);
		
		if (null == event) {
			
			return null;
		}
		
		events.remove(eventId);
		
		return event;
	}

}
