package com.marceljm.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.marceljm.entity.Product;

@Component
@Path("/hello")
public class HelloResource {

	@Inject
	Product product;

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
		product.setId(1L);
		product.setName("Hello, XML!");
		return Response.ok(product).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloJson() {
		product.setId(2L);
		product.setName("Hello, JSON!");
		return Response.ok(product).build();
	}
}
