package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Street {

    private String name;
    private List<Line> lines;
    private Intersection start;
    private Intersection end;
    private double width;
    double m = (start.getCentralPoint().getY() - end.getCentralPoint().getY()) / (start.getCentralPoint().getX() - end.getCentralPoint().getX());

    public double middleLineFormula(double x){
        return m * (x - start.getCentralPoint().getX()) + start.getCentralPoint().getY();
    }

    public double streetUpperBound(double x){
        return middleLineFormula(x) + (width/2) / Math.cos(Math.atan(m));
    }

    public double streetLowerBound(double x){
        return middleLineFormula(x) - (width/2) / Math.cos(Math.atan(m));
    }

    public Street(String name, List<Line> lines, Intersection start, Intersection end) {
        this.name = name;
        this.start = start;
        this.end = end;
        lines = new ArrayList<Line>();
    }

    public String getName() {
        return name;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Intersection getStart() {
        return start;
    }

    public Intersection getEnd() {
        return end;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth() {
        for (int i = 0; i < lines.size(); i++){
            width += Line.getWidth();
        }
    }
}
