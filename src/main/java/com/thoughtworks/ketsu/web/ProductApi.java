package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Optional;

@Path("products")
public class ProductApi {

  @Context
  ProductRepository productRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(HashMap<String, Object> info) {
    productRepository.create(info);
    int id = Integer.valueOf(String.valueOf(info.get("id")));
    Optional<Product> productOptional = productRepository.findById(id);

    if (productOptional.isPresent()) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

  }
}
