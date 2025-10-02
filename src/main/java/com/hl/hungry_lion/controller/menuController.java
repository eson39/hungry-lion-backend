package com.hl.hungry_lion.controller;

import com.hl.hungry_lion.cache.menuData;
import com.hl.hungry_lion.scraper.diningScraper;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/menu")
public class menuController {

    @GetMapping("/{meal}")
    public String getMenuByMeal(@PathVariable String meal) {
        return menuData.getJsonForMeal(meal);
    }

    @PostMapping("/refresh")
    public String refreshMenu() {
        try {
            Map<String, String> jsonByMeal = diningScraper.scrapeAllMeals();
            menuData.setLatestJson(jsonByMeal);
            return "Menu refreshed successfully!";
        } catch (Exception e) {
            return "Error refreshing: " + e.getMessage();
        }
    }
}

