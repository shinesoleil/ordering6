package com.thoughtworks.ketsu.domain.payment;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Payment implements Record{
  private int orderId;
  private String payType;
  private Date payTime;
  private double amount;

  public Payment() {
  }

  public Payment(int orderId, String payType, Date payTime, double amount) {
    this.orderId = orderId;
    this.payType = payType;
    this.payTime = payTime;
    this.amount = amount;
  }

  public int getOrderId() {
    return orderId;
  }

  public String getPayType() {
    return payType;
  }

  public Date getPayTime() {
    return payTime;
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
    return new HashMap<String, Object>() {{
      put("orderUri", routes.paymentUrl(Payment.this, getOrderId()));
      put("uri", routes.paymentUrl(Payment.this, getOrderId()));
      put("pay_type", payType);
      put("amount", amount);
      put("created_at", payTime);
    }};
  }
}
