package com.thoughtworks.ketsu.domain.order;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order implements Record {
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

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return null;
  }
}
