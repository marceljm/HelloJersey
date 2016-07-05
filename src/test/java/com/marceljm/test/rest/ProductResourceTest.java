package com.marceljm.test.rest;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import com.marceljm.entity.Product;
import com.marceljm.rest.ProductResource;

public class ProductResourceTest extends JerseyTest {

	Product product = new Product();

	Entity<Product> entity = Entity.entity(product, MediaType.APPLICATION_JSON);

	@Override
	protected Application configure() {
		return new ResourceConfig(ProductResource.class);
	}

	private void post() {
		Response response = target("/products").request().post(entity);
		Assert.assertEquals(response.getStatus(), 200);
	}

	private void get(Long id) {
		Response response = target("/products/" + id).request(MediaType.APPLICATION_JSON).get();
		Assert.assertEquals(200, response.getStatus());
		Assert.assertEquals(product.getName(), response.readEntity(Product.class).getName());
	}

	private void getAll() {
		Response response = target("/products").request(MediaType.APPLICATION_JSON).get();
		Assert.assertEquals(200, response.getStatus());
		List<Product> list = response.readEntity(new GenericType<List<Product>>() {
		});
		Assert.assertEquals(2, list.size());
	}

	private void getFail(Long id) {
		Response response = target("/products/" + id).request(MediaType.APPLICATION_JSON).get();
		Assert.assertNotEquals(200, response.getStatus());
	}

	private void put() {
		Response response = target("/products").request().put(entity);
		Assert.assertEquals(response.getStatus(), 200);
	}

	private void delete(Long id) {
		Response response = target("/products/" + id).request().delete();
		Assert.assertEquals(response.getStatus(), 200);
	}

	@Test
	public void postTest() {
		product.setId(1L);
		product.setName("TV");
		post();
		get(1L);
	}

	@Test
	public void putTest() {
		postTest();
		product.setName("Home Theater");
		put();
		get(1L);
	}

	@Test
	public void deleteTest() {
		postTest();
		delete(1L);
		getFail(1L);
	}

	@Test
	public void getTest() {
		product.setId(1L);
		product.setName("TV");
		post();
		product.setId(2L);
		product.setName("Home Theater");
		post();
		getAll();
	}

}
