package model.GameObjects;

import java.util.List;

/**
 * Created by ASUS on 09/12/2016.
 */
public class IrregularPath extends Path {
    Intersection start;
    List<Intersection> destinations;

    public void add(Intersection intersection){
        intersections.add(intersection);
    }

}
