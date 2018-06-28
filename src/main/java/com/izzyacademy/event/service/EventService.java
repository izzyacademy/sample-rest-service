package com.izzyacademy.event.service;

import java.util.Map;

import com.izzyacademy.event.models.Event;

public interface EventService {

	Event getEvent(long eventId);
	
	Map<Long, Event> getEvents();
	
	Event updateEvent(long eventId, Event event);
	
	Event deleteEvent(long eventId);
	
	Event createEvent(Event event);
}
