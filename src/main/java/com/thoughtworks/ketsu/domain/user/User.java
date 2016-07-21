package com.thoughtworks.ketsu.domain.user;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;
import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class User implements Record {
  @Inject
  OrderMapper orderMapper;

  @Inject
  ProductMapper productMapper;

  private int id;
  private String name;

  public User() {
  }

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  private double getPriceByProductId(int productId) {
    return productMapper.findById(productId).getPrice();
  }

  public void placeOrder(Map<String, Object> info) {
    info.put("user_id", id);

    for (Map<String, Object> item: (List<Map<String, Object>>)info.get("order_items")) {
      item.put("amount", ((int) item.get("quantity")) * getPriceByProductId((int) item.get("product_id")));
    }

    orderMapper.save(info);
  }

  public Optional<Order> findOrderById(int orderId) {
    return Optional.ofNullable(orderMapper.findById(orderId));
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("id", id);
      put("uri", routes.userUrl(User.this));
      put("name", name);
    }};
  }
}
