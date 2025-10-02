package com.hl.hungry_lion.cache;

import org.springframework.stereotype.Component;

@Component
public class menuData {
    private static String latestJson = "{}";

    public static void setLatestJson(String json) {
        latestJson = json;
    }

    public static String getLatestJson() {
        return latestJson;
    }
}
