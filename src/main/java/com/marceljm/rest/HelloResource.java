package com.marceljm.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.marceljm.entity.Message;
import com.marceljm.entity.Product;
import com.marceljm.service.GenericService;

@Component
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class HelloResource {

	@Inject
	GenericService<Product> productService;

	@GET
	public List<Product> get() {
		return productService.select(Product.class);
	}

	@POST
	public Response post(Product product) {
		productService.insert(product);
		return Response.ok(new Message("Product Inserted")).build();
	}

	// @PUT
	// public Response put() {
	// product.setName("House");
	// productService.update(product);
	// message.setMessage("Update");
	// return Response.ok(message).build();
	// }
	//
	// @DELETE
	// @Path("{id}")
	// public Response delete(@PathParam("id") Long id) {
	// productService.delete(productService.select(Product.class, id));
	// message.setMessage("Delete");
	// return Response.ok(message).build();
	// }

	// @GET
	// @Consumes(MediaType.TEXT_HTML)
	// @Produces(MediaType.TEXT_HTML + ";charset=utf-8")
	// public String helloHtml() {
	// return "<b>Hello, HTML!</b>";
	// }
	//
	// @GET
	// @Produces(MediaType.TEXT_PLAIN)
	// public String helloTextPlain() {
	// return "Hello, Text Plain!";
	// }
	//
	// @GET
	// @Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	// @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	// public Response helloXml() {
	// product.setId(1L);
	// product.setName("Hello, XML!");
	// return Response.ok(product).build();
	// }
	//
	// @GET
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response helloJson() {
	// product.setId(2L);
	// product.setName("Hello, JSON!");
	// return Response.ok(product).build();
	// }
}
