package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 08/12/2016.
 */
public class City {

    private String name;
    private List<Street> streets;
    private List<Intersection> intersections;

    public City(String name) {
        this.name = name;
        streets = new ArrayList<Street>();
        intersections = new ArrayList<Intersection>();
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public String getName() {
        return name;
    }
}
