package com.thoughtworks.ketsu.domain.user;

import java.util.Map;
import java.util.Optional;

public interface UserRepository {
  void create(Map<String, Object> info);

  Optional<User> findById(int id);
}
