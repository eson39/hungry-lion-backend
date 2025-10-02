package com.hl.hungry_lion.controller;

import com.hl.hungry_lion.cache.menuData;
import com.hl.hungry_lion.scraper.diningScraper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class menuController {

    @GetMapping
    public String getMenuJson() {
        return menuData.getLatestJson();
    }

    // Manual refresh endpoint (useful for testing)
    @PostMapping("/refresh")
    public String refreshMenu() {
        try {
            String json = diningScraper.scrapeAllMeals();
            menuData.setLatestJson(json);
            return "Menu refreshed successfully!";
        } catch (Exception e) {
            return "Error refreshing: " + e.getMessage();
        }
    }
}
