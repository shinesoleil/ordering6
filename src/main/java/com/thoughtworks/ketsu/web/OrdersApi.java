package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
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
  @Produces(MediaType.APPLICATION_JSON)
  public List<Order> findOrders(@PathParam("userId") int userId) {
    User user = userRepository.findById(userId).get();
    return user.findOrders();
  }

  @GET
  @Path("{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Order findOrderById(@PathParam("userId") int userId,
                             @PathParam("orderId") int orderId) {
    User user = userRepository.findById(userId).get();
    return user.findOrderById(orderId).orElseThrow(() -> new NotFoundException("Cannot find the order by id"));
  }
}
