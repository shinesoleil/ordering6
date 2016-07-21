package com.thoughtworks.ketsu.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("users/{userId}/orders")
public class OrdersApi {

  @POST
  public Response createOrder() {
    return Response.status(201).build();
  }
}
