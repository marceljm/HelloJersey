package com.marceljm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.marceljm.entity.MyMediaType;

@Path("/hello")
public class HelloResource {

	MyMediaType myMediaType = new MyMediaType();

	@GET
	public String get() {
		return "HTTP GET";
	}

	@POST
	public String post() {
		return "HTTP POST";
	}

	@PUT
	public String put() {
		return "HTTP PUT";
	}

	@DELETE
	public String delete() {
		return "HTTP DELETE";
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML + ";charset=utf-8")
	public String helloHtml() {
		return "<b>Hello, HTML!</b>";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloTextPlain() {
		return "Hello, Text Plain!";
	}

	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	public Response helloXml() {
		myMediaType.setType("XML");
		myMediaType.setMessage("Hello, XML!");
		return Response.ok(myMediaType).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloJson() {
		myMediaType.setType("JSON");
		myMediaType.setMessage("Hello, JSON!");
		return Response.ok(myMediaType).build();
	}
}
