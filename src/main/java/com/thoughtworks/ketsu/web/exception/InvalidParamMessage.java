package com.thoughtworks.ketsu.web.exception;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class InvalidParamMessage implements Record {
  private String field;
  private String message;

  public InvalidParamMessage(String field) {
    this.field = field;
    this.message = field + " cannot be null";
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("field", field);
      put("message", message);
    }};
  }
}
