package com.hl.hungry_lion.scraper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hl.hungry_lion.scraper.mealsData.*;

public class diningScraper {

    private static final String BASE_URL = "https://liondine.com";
    private static final List<String> MEALS = Arrays.asList("breakfast", "lunch", "dinner", "latenight");

    public static String scrapeAllMeals() throws Exception {
        List<MealData> allMeals = new ArrayList<>();

        for (String meal : MEALS) {
            Document doc = Jsoup.connect(BASE_URL + "/" + meal)
                    .userAgent("Mozilla/5.0 (DiningScraper)")
                    .timeout(15000)
                    .get();

            List<DiningHall> halls = new ArrayList<>();
            Elements hallDivs = doc.select("div.col");

            for (Element hall : hallDivs) {
                String hallName = hall.select("a h3").text();
                if (hallName.isEmpty()) continue;

                String hours = hall.select("div.hours").text();

                List<Station> stations = new ArrayList<>();
                Element menu = hall.selectFirst("div.menu");
                if (menu != null) {
                    String currentStation = "";
                    List<String> currentItems = new ArrayList<>();

                    for (Element el : menu.children()) {
                        if (el.hasClass("food-type")) {
                            if (!currentStation.isEmpty()) {
                                stations.add(new Station(currentStation, new ArrayList<>(currentItems)));
                                currentItems.clear();
                            }
                            currentStation = el.text();
                        } else if (el.hasClass("food-name")) {
                            currentItems.add(el.text());
                        }
                    }
                    if (!currentStation.isEmpty()) {
                        stations.add(new Station(currentStation, currentItems));
                    }
                }

                halls.add(new DiningHall(hallName, hours, stations));
            }

            allMeals.add(new MealData(meal, halls));
        }

        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        return gson.toJson(allMeals);
    }
}
