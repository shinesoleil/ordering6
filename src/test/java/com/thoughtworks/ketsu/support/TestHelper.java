package com.thoughtworks.ketsu.support;

import java.util.HashMap;
import java.util.Map;

public class TestHelper {
    private static int auto_increment_key = 1;
    public static Map<String, Object> deployment(String appName, String releaseId) {
        return new HashMap<String, Object>() {{
            put("app", String.format("http://service-api.tw.com/apps/%s", appName));
            put("release", String.format("http://service-api.tw.com/apps/%s/releases/%s", appName, releaseId));
        }};
    }

    public static Map<String, Object> stackMap(String id, String name) {
        Map<String, Object> stackMap = new HashMap<String, Object>() {{
            put("id", id);
            put("name", name);
        }};
        return stackMap;
    }

    public static Map<String, Object> productMap() {
        return new HashMap<String, Object>() {{
            put("name", "desk");
            put("description", "white");
            put("price", 630);
        }};
    }

    public static Map<String, Object> userMap() {
        return new HashMap<String, Object>() {{
            put("name", "firstUser");
        }};
    }

    public static Map<String, Object> orderMap(int userId) {
        return new HashMap<String, Object>() {{
            put("name", "firstOrder");
            put("address", "Beijing");
            put("phone", "13099999999");
            put("user_id", userId);
        }};
    }
}
