package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport{

  @Test
  public void should_return_201_when_post_payment() {
    Response post = post("users/1/orders/1/payment", new HashMap());

    assertThat(post.getStatus(), is(201));
  }
}
