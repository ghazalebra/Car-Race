package model.GameObjects;

/**
 * Created by ASUS on 09/12/2016.
 */
public class CircularPath extends Path {

    //if new intersection is linked with the previous one in the path, adds it to path intersections.
    public void add(Intersection intersection){
        for(int i = 0; i < intersections.get(intersections.size() - 1).streets.size(); i++){
            if (intersections.get(intersections.size() - 1).streets.get(i).getEnd().equals(intersection) || intersections.get(intersections.size() - 1).streets.get(i).getStart().equals(intersection)){
                intersections.add(intersection);
            }
        }
    }
}
