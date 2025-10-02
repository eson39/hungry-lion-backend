package com.hl.hungry_lion.cache;

import java.util.Map;

public class menuData {
    private static Map<String, String> latestJsonByMeal;

    public static synchronized void setLatestJson(Map<String, String> newJson) {
        latestJsonByMeal = newJson;
    }

    public static synchronized String getJsonForMeal(String meal) {
        if (latestJsonByMeal == null) return "{}";
        return latestJsonByMeal.getOrDefault(meal.toLowerCase(), "{}");
    }

    public static synchronized Map<String, String> getAllMeals() {
        return latestJsonByMeal;
    }
}
