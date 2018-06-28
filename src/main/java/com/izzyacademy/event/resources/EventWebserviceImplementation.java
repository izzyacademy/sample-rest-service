package com.izzyacademy.event.resources;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izzyacademy.event.exceptions.ErrorModel;
import com.izzyacademy.event.models.Event;
import com.izzyacademy.event.service.EventService;

@Service
public class EventWebserviceImplementation implements EventWebservice {

	@Autowired
	EventService service;
	
	public EventWebserviceImplementation()
	{
		
	}
	
	@Override
	public Response createEvent(Event event) {
		
		Event originalEvent = service.getEvent(event.getId());
		
		if (originalEvent != null) {
			
			return Response.status(Status.CONFLICT).entity(new ErrorModel("Event Id " + event.getId() + " already exists")).build();
		}

		Object response = service.createEvent(event);
		
		return Response.ok(response).build();
	}

	@Override
	public Response getEvents() {

		Object response = service.getEvents();
		
		if (false)
		{
			throw new RuntimeException("");
		}
		
		return Response.ok(response).build();
	}

	@Override
	public Response getEvent(long eventId) {

		Object response = service.getEvent(eventId);
		
		if (response == null) {
			
			//return Response.status(Status.NOT_FOUND).build();
			throw new WebApplicationException(Response.status(404).entity(new Event()).build());
		}
		
		return Response.ok(response).build();
	}

	@Override
	public Response updateEvent(long eventId, Event event) {
		
		Object response = service.updateEvent(eventId, event);
		
		return Response.ok(response).build();
	}

	@Override
	public Response deleteEvent(long eventId) {
		
		Event response = service.deleteEvent(eventId);
		
		if (response == null) {
		
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.noContent().build();
	}

}
