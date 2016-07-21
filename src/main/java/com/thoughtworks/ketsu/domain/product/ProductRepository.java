package com.thoughtworks.ketsu.domain.product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {
  void create(Map<String, Object> info);

  Optional<Product> findById(int id);

  List<Product> find();
}
