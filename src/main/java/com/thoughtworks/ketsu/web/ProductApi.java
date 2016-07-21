package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.web.exception.InvalidParameterException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Path("products")
public class ProductApi {

  @Context
  ProductRepository productRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(HashMap<String, Object> info) {
    List<String> invalidParamList = new ArrayList<>();
    if (info.get("name") == null) {
      invalidParamList.add("name");
    }
    if (info.get("description") == null) {
      invalidParamList.add("description");
    }
    if (info.get("price") == null) {
      invalidParamList.add("price");
    }
    if (invalidParamList.size() > 0) {
      throw new InvalidParameterException(invalidParamList);
    }

    productRepository.create(info);
    int id = Integer.valueOf(String.valueOf(info.get("id")));
    Optional<Product> productOptional = productRepository.findById(id);

    if (productOptional.isPresent()) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Product> findProducts() {
    return productRepository.find();
  }

  @GET
  @Path("{productId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Product findById(@PathParam("productId") int productId) {
    return productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Cannot find the product by id"));
  }

}
