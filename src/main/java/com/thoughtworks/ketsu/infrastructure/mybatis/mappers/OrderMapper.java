package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderMapper {
  void save(@Param("order") Map<String, Object> info);

  Order findById(@Param("id") int id);
}
