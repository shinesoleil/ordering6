package com.thoughtworks.ketsu.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static Map<String, Object> orderMap(int userId, int productId) {
        return new HashMap<String, Object>() {{
            put("name", "firstOrder");
            put("address", "Beijing");
            put("phone", "13099999999");
            put("order_items", orderItemsMapList(productId));
        }};
    }

    public static List<Map<String, Object>> orderItemsMapList(int productId) {
        List<Map<String, Object>> list = new ArrayList<>();

        HashMap<String, Object> item = new HashMap() {{
            put("product_id", productId);
            put("quantity", 2);
        }};

        list.add(item);
        return list;
    }
}
