package com.thoughtworks.ketsu.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersApi {

  @POST
  public Response createUser() {
    return Response.status(201).build();
  }
}
