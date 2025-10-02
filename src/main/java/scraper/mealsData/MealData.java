package scraper.mealsData;

import java.util.List;

public class MealData {
    String mealType;
    List<DiningHall> diningHalls;

    public MealData(String mealType, List<DiningHall> diningHalls) {
        this.mealType = mealType;
        this.diningHalls = diningHalls;
    }
}

