package com.hl.hungry_lion.scheduler;

import com.hl.hungry_lion.cache.menuData;
import com.hl.hungry_lion.scraper.diningScraper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class diningScraperScheduler {

    // Runs at 12 every day
    @Scheduled(cron = "0 0 0 * * *")
    public void fetchMenuJson() {
        try {
            String json = diningScraper.scrapeAllMeals();
            menuData.setLatestJson(json);
            System.out.println("Menu scraped at: " + LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
