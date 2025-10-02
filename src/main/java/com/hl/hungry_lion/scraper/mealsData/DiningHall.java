package com.hl.hungry_lion.scraper.mealsData;
import java.util.List;

public class DiningHall {
    String name;
    String hours;
    List<com.hl.hungry_lion.scraper.mealsData.Station> stations;

    public DiningHall(String name, String hours, List<com.hl.hungry_lion.scraper.mealsData.Station> stations) {
        this.name = name;
        this.hours = hours;
        this.stations = stations;
    }
}
