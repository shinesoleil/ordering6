package com.thoughtworks.ketsu.domain.payment;

import java.util.Date;

public class Payment {
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
}
