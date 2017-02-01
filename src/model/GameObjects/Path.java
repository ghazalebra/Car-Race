package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 09/12/2016.
 */
public class Path {
    protected List<Intersection> intersections;

    public Path(){
        intersections = new ArrayList<Intersection>();
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(List<Intersection> intersections) {
        this.intersections = intersections;
    }
}
