package com.izzyacademy.event.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.izzyacademy.event.models.Event;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="Events API", produces="application/json", consumes="application/json")
@Component
public interface EventWebservice {

	public static final String SERVICE_BASE_PATH = "/event-service";
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/events")
	@ApiOperation("Create Event")
	Response createEvent(Event event);
	
	@GET
	@Path("/events")
	@ApiOperation("List Events")
	Response getEvents();
	
	@GET
	@Path("/events/{eventId}")
	@ApiOperation("Get Event")
	@ApiImplicitParam(name="eventId", paramType="path", dataType="long", example="100", defaultValue="100")
	public Response getEvent(@PathParam("eventId") long eventId);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/events/{eventId}")
	@ApiOperation("Update Event")
	@ApiImplicitParam(name="eventId", paramType="path", dataType="long", example="100", defaultValue="100")
	Response updateEvent(@PathParam("eventId") long eventId, Event event);
	
	@DELETE
	@Path("/events/{eventId}")
	@ApiOperation("Remove Event")
	@ApiImplicitParam(name="eventId", paramType="path", dataType="long", example="100", defaultValue="100")
	Response deleteEvent(@PathParam("eventId") long eventId);
}
