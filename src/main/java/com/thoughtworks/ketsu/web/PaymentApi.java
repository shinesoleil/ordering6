package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.payment.Payment;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Optional;

@Path("users/{userId}/orders/{orderId}/payment")
public class PaymentApi {

  @Context
  UserRepository userRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createPayment(HashMap<String, Object> info,
                                @PathParam("userId") int userId,
                                @PathParam("orderId") int orderId) {
    User user = userRepository.findById(userId).get();
    Order order = user.findOrderById(orderId).get();
    order.pay(info);
    Optional<Payment> paymentOptional = order.findPaymentByOrderId(orderId);

    if (paymentOptional.isPresent()) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }
}
