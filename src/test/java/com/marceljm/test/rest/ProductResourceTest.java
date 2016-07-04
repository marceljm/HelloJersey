package com.marceljm.test.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.marceljm.entity.Product;
import com.marceljm.rest.ProductResource;

public class ProductResourceTest extends JerseyTest {

	Product product = new Product();;

	@Override
	protected Application configure() {
		return new ResourceConfig(ProductResource.class);
	}

	@Before
	public void init() {
		product.setId(1L);
		product.setName("TV");
	}

	// https://jersey.java.net/documentation/latest/test-framework.html
	// http://memorynotfound.com/test-jersey-rest-service-with-junit/
	@Test
	public void get() {
		post();
		Response response = target("/products/1").request(MediaType.APPLICATION_JSON).get();
		Assert.assertEquals(200, response.getStatus());
		Assert.assertEquals("TV", response.readEntity(Product.class).getName());
	}

	@Test
	public void post() {
		Entity<Product> entity = Entity.entity(product, MediaType.APPLICATION_JSON);
		Response response = target("/products").request().post(entity);
		Assert.assertEquals(response.getStatus(), 200);
	}

	// @Test
	// public void test() {
	// client = JerseyClientBuilder.newBuilder().build();
	//
	// target = client.target(Main.BASE_URI);
	// }

	// @Test
	// public void shouldPostProduct() {
	// Product product = new Product();
	// product.setId(1L);
	// product.setName("TV");
	//
	// ClientConfig config = new ClientConfig();n
	//
	// Client client = ClientBuilder.newClient(config);
	// client.register(new JacksonJaxbJsonProvider());
	//
	// WebTarget target = client.target(BASE_URI).path("/rest/products");
	// Entity<Product> entity = Entity.entity(product,
	// MediaType.APPLICATION_JSON);
	//
	// Response response =
	// target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
	//
	// System.out.println(response.toString());
	// //Assert.assertEquals(200, response.getStatus());
	// // Message msg = response.readEntity(Message.class);
	// }

}
