package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
  @Inject
  UserMapper userMapper;

  @Override
  public void create(Map<String, Object> info) {
    userMapper.save(info);
  }

  @Override
  public Optional<User> findById(int id) {
    return Optional.ofNullable(userMapper.findById(id));
  }
}
