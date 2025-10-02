package com.hl.hungry_lion.scheduler;

import com.hl.hungry_lion.cache.menuData;
import com.hl.hungry_lion.scraper.diningScraper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class diningScraperScheduler {

    // Runs at midnight everyday
    @Scheduled(cron = "0 0 0 * * *")
    public void fetchMenuJson() {
        try {
            Map<String, String> jsonByMeal = diningScraper.scrapeAllMeals();
            menuData.setLatestJson(jsonByMeal);
            System.out.println("Menu scraped at: " + LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
