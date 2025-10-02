package scraper.mealsData;
import java.util.List;

public class Station {
    String name;
    List<String> items;

    public Station(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}
