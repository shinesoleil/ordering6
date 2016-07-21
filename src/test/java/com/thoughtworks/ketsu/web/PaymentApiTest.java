package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport{
  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;

  @Test
  public void should_return_201_when_post_payment_with_parameters() {
    Map<String, Object> productInfo = TestHelper.productMap();
    productRepository.create(productInfo);
    int productId = Integer.valueOf(String.valueOf(productInfo.get("id")));

    Map<String, Object> userInfo = TestHelper.userMap();
    userRepository.create(userInfo);
    int userId = Integer.valueOf(String.valueOf(userInfo.get("id")));
    Map<String, Object> orderInfo = TestHelper.orderMap(userId, productId);

    User user = userRepository.findById(userId).get();
    user.placeOrder(orderInfo);
    int orderId = Integer.valueOf(String.valueOf(orderInfo.get("id")));

    Response post = post("users/" + userId + "/orders/" + orderId + "/payment", TestHelper.paymentMap());

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void should_return_400_when_post_payment_with_invalid_parameters() {
    Map<String, Object> productInfo = TestHelper.productMap();
    productRepository.create(productInfo);
    int productId = Integer.valueOf(String.valueOf(productInfo.get("id")));

    Map<String, Object> userInfo = TestHelper.userMap();
    userRepository.create(userInfo);
    int userId = Integer.valueOf(String.valueOf(userInfo.get("id")));
    Map<String, Object> orderInfo = TestHelper.orderMap(userId, productId);

    User user = userRepository.findById(userId).get();
    user.placeOrder(orderInfo);
    int orderId = Integer.valueOf(String.valueOf(orderInfo.get("id")));

    Map<String, Object> map = TestHelper.paymentMap();
    map.replace("pay_type", null);

    Response post = post("users/" + userId + "/orders/" + orderId + "/payment", map);

    assertThat(post.getStatus(), is(400));

  }

  @Test
  public void should_return_payment_json_when_get_payment_by_order_id() {
    Map<String, Object> productInfo = TestHelper.productMap();
    productRepository.create(productInfo);
    int productId = Integer.valueOf(String.valueOf(productInfo.get("id")));

    Map<String, Object> userInfo = TestHelper.userMap();
    userRepository.create(userInfo);
    int userId = Integer.valueOf(String.valueOf(userInfo.get("id")));
    Map<String, Object> orderInfo = TestHelper.orderMap(userId, productId);

    User user = userRepository.findById(userId).get();
    user.placeOrder(orderInfo);
    int orderId = Integer.valueOf(String.valueOf(orderInfo.get("id")));

    Order order = user.findOrderById(orderId).get();
    Map<String, Object> paymentInfo = TestHelper.paymentMap();

    order.pay(paymentInfo);

    Response get = get("users/" + userId + "/orders/" + orderId + "/payment");
    Map<String, Object> map = get.readEntity(Map.class);

    assertThat(map.get("pay_type"), is("CASH"));
  }

}
