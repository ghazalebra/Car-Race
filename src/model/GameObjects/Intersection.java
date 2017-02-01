package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Intersection {

    /*point1        point2

         centralPoint

     point3         point4*/
    private Point centralPoint;
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private Side side1To2;
    private Side side1To3;
    private Side side3To4;
    private Side side2To4;
    List<Street> streets;

    public double side1T02Formula(double x){
        double m = (point2.getY() - point1.getY())/(point2.getX() - point1.getX());
        return m*(x - point1.getX()) + point1.getY();
    }

    public double side1T03Formula(double x){
        double m = (point3.getY() - point1.getY())/(point3.getX() - point1.getX());
        return m*(x - point1.getX()) + point1.getY();
    }

    public double side3T04Formula(double x){
        double m = (point4.getY() - point3.getY())/(point4.getX() - point3.getX());
        return m*(x - point3.getX()) + point3.getY();
    }

    public double side2T04Formula(double x){
        double m = (point2.getY() - point4.getY())/(point2.getX() - point4.getX());
        return m*(x - point2.getX()) + point2.getY();
    }

    public Intersection(Point centralPoint){
        this.centralPoint = centralPoint;
        streets = new ArrayList<Street>();
    }


    public Point getCentralPoint() {
        return centralPoint;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1() {


        point1.setX(centralPoint.getX() - side1To2.getLength()/2);
        point1.setY(centralPoint.getY() + side1To3.getLength()/2);
        side1To2.setStartPoint(point1);
        side1To3.setStartPoint(point1);
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2() {

        point2.setX(centralPoint.getX() + side1To2.getLength()/2);
        point2.setY(centralPoint.getY() + side2To4.getLength()/2);
        side1To2.setEndPoint(point2);
        side2To4.setStartPoint(point2);
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3() {

        point3.setX(centralPoint.getX() - side3To4.getLength()/2);
        point3.setY(centralPoint.getY() - side1To3.getLength()/2);
        side1To3.setEndPoint(point3);
        side3To4.setStartPoint(point3);
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4() {

        point4.setY(centralPoint.getX() + side3To4.getLength()/2 );
        point4.setY(centralPoint.getY() - side2To4.getLength()/2);
        side3To4.setEndPoint(point4);
        side2To4.setEndPoint(point4);
    }

    public Side getSide1To2() {
        return side1To2;
    }

    public void setSide1To2(Side side1To2) {
        this.side1To2 = side1To2;
    }

    public Side getSide1To3() {
        return side1To3;
    }

    public void setSide1To3(Side side1To3) {
        this.side1To3 = side1To3;
    }

    public Side getSide3To4() {
        return side3To4;
    }

    public void setSide3To4(Side side3To4) {
        this.side3To4 = side3To4;
    }

    public Side getSide2To4() {
        return side2To4;
    }

    public void setSide2To4(Side side2To4) {
        this.side2To4 = side2To4;
    }
}
