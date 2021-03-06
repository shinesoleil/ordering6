package com.thoughtworks.ketsu.domain.order;

import com.thoughtworks.ketsu.domain.payment.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PaymentMapper;
import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import javax.inject.Inject;
import java.util.*;

public class Order implements Record {

  @Inject
  PaymentMapper paymentMapper;

  private int id;
  private String name;
  private String address;
  private String phone;
  private Date time;
  private int userId;
  private List<OrderItem> orderItemList;

  public Order(int id, String name, String address, String phone, Date time, int userId, List<OrderItem> orderItemList) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.time = time;
    this.userId = userId;
    this.orderItemList = orderItemList;
  }

  public Order() {
  }

  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public Date getTime() {
    return time;
  }

  public int getUserId() {
    return userId;
  }

  public void pay(Map<String, Object> info) {
    info.put("order_id", id);
    paymentMapper.save(info);
  }

  public Optional<Payment> findPaymentByOrderId(int orderId) {
    return Optional.ofNullable(paymentMapper.findByOrderId(orderId));
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (OrderItem orderItem: orderItemList) {
      totalPrice += orderItem.getAmount();
    }
    return totalPrice;
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("id", id);
      put("uri", routes.orderUrl(Order.this, getUserId()));
      put("name", name);
      put("address", address);
      put("phone", phone);
      put("total_price", getTotalPrice());
      put("created_at", time);
      put("order_items", orderItemList);
    }};
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("uri", routes.orderUrl(Order.this, getUserId()));
      put("name", name);
      put("address", address);
      put("phone", phone);
      put("total_price", getTotalPrice());
      put("created_at", time);
      put("order_items", orderItemList);
    }};
  }
}
