package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class OrderManipulationTest {

  @Inject
  UserRepository userRepository;

  @Test
  public void should_create_order_without_items_and_find_order_by_id() {
    Map<String, Object> userInfo = TestHelper.userMap();
    userRepository.create(userInfo);
    int userId = Integer.valueOf(String.valueOf(userInfo.get("id")));
    Map<String, Object> orderInfo = TestHelper.orderMap(userId);

    User user = userRepository.findById(userId).get();
    user.placeOrder(orderInfo);
    int orderId = Integer.valueOf(String.valueOf(orderInfo.get("id")));
    Optional<Order> orderOptional = user.findOrderById(orderId);

    assertThat(orderOptional.get().getId(), is(orderId));
    assertThat(orderOptional.get().getUserId(), is(userId));
  }
}
