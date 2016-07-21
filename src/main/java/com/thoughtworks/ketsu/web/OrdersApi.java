package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Optional;

@Path("users/{userId}/orders")
public class OrdersApi {

  @Context
  UserRepository userRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createOrder(HashMap<String, Object> info,
                              @PathParam("userId") int userId) {

    User user = userRepository.findById(userId).get();
    user.placeOrder(info);
    int orderId = Integer.valueOf(String.valueOf(info.get("id")));

    Optional<Order> orderOptional = user.findOrderById(orderId);

    if (orderOptional.isPresent()) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }

  @GET
  public Response findOrders(@PathParam("userId") int userId) {
    return Response.status(200).build();

  }
}
