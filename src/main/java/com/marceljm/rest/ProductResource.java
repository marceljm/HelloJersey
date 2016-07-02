package com.marceljm.rest;

import java.util.List;

import javax.inject.Inject;
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

import com.marceljm.entity.Message;
import com.marceljm.entity.Product;
import com.marceljm.service.GenericService;

@Component
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProductResource {

	@Inject
	GenericService<Product> productService;

	@GET
	public List<Product> get() {
		return productService.select(Product.class);
	}

	@GET
	@Path("{id}")
	public Product get(@PathParam("id") Long id) {
		return productService.select(Product.class, id);
	}

	@POST
	public Response post(Product product) {
		productService.insert(product);
		return Response.ok(new Message("Product Inserted")).build();
	}

	@PUT
	public Response put(Product product) {
		productService.update(product);
		return Response.ok(new Message("Product Updated")).build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		Product product = productService.select(Product.class, id);
		productService.delete(product);
		return Response.ok(new Message("Product Deleted")).build();
	}
}
