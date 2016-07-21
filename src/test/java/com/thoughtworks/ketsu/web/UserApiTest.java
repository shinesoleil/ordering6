package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class UserApiTest extends ApiSupport{

  @Test
  public void should_return_uri_location_when_post_user_with_parameters() {
    Map<String, Object> info = TestHelper.userMap();

    Response post = post("users", info);

    assertThat(post.getStatus(), is(201));
    assertThat(Pattern.matches(".*users/[0-9]+", post.getLocation().toASCIIString()), is(true));
  }
}
