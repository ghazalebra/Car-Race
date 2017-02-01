package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Side {

    private List<Street> streets;
    private List<Street> inputStreets;
    private List<Street> outputStreets;
    private List<Line> lines;
    private List<Line> inputLines;
    private List<Line> outputLines;
    private int length;
    private Point startPoint;
    private Point endPoint;

    public Side() {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.streets = new ArrayList<Street>();
        this.inputStreets = new ArrayList<Street>();
        this.outputStreets = new ArrayList<Street>();
        this.lines = new ArrayList<Line>();
        this.inputLines = new ArrayList<Line>();
        this.outputLines = new ArrayList<Line>();
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public double sideFormula(double x){
        double m = (endPoint.getY() - startPoint.getY())/(endPoint.getX() - startPoint.getX());
        return m*(x - endPoint.getX()) + endPoint.getY();
    }

    public List<Street> getStreets() {
        return streets;
    }

    public List<Street> getInputStreets() {
        return inputStreets;
    }

    public List<Street> getOutputStreets() {
        return outputStreets;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Line> getInputLines() {
        return inputLines;
    }

    public List<Line> getOutputLines() {
        return outputLines;
    }

    public void setLength(){
        this.length = this.getLines().size() * Line.getWidth();
    }

    public int getLength() {
        return length;
    }

    public void addStreet(Street street){
    }

    public  void addLine(Line line){
        lines.add(line);
    }
    public void addInputLine(Line line){ inputLines.add(line); }
    public void addOutputLine(Line line){ outputLines.add(line); }
}
