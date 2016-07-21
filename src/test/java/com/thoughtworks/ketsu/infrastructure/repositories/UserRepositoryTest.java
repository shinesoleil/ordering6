package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class UserRepositoryTest {

  @Inject
  UserRepository userRepository;

  @Test
  public void should_create_user_and_find_user_by_id() {
    Map<String, Object> info = TestHelper.userMap();
    userRepository.create(info);
    int id = Integer.valueOf(String.valueOf(info.get("id")));

    Optional<User> userOptional = userRepository.findById(id);

    assertThat(userOptional.get().getId(), is(id));
  }

}
