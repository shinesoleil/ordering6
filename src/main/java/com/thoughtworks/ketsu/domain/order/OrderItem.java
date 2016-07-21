package com.thoughtworks.ketsu.domain.order;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Map;

public class OrderItem implements Record {
  private int orderId;
  private int productId;
  private int quantity;
  private double amount;

  public OrderItem() {
  }

  public OrderItem(int orderId, int productId, int quantity, double amount) {
    this.orderId = orderId;
    this.productId = productId;
    this.quantity = quantity;
    this.amount = amount;
  }

  public int getOrderId() {
    return orderId;
  }

  public int getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return toRefJson(routes);
  }
}
