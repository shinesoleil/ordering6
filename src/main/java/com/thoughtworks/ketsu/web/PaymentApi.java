package com.thoughtworks.ketsu.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("users/{userId}/orders/{orderId}/payment")
public class PaymentApi {

  @POST
  public Response createPayment() {
    return Response.status(201).build();
  }
}
