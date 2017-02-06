package model.GameObjects;

/**
 * Created by ASUS on 09/12/2016.
 */
public class Vector {

    private boolean IsFrontOfTheCar;//aghab ya jelo? this is the question!
    Point startPoint, endPoint;
    private double x, y; //moallefe ha
    private double magnitude;
    private double alpha;//zavieash ba mosbat e x ha.

    public Vector(double magnitude, double alpha){
        this.alpha = alpha;
        this.magnitude = magnitude;
        this.x = Math.cos(Math.toRadians(alpha)) * magnitude;
        this.y = Math.sin(Math.toRadians(alpha)) * magnitude;

    }

    public Vector(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.magnitude = Math.sqrt(Math.pow((endPoint.getY() - startPoint.getY()), 2) + Math.pow((endPoint.getX() - startPoint.getX()), 2));
        this.alpha = Math.atan(Math.toRadians((endPoint.getY() - startPoint.getY()) / (endPoint.getX() - startPoint.getX())));
    }

    public double formula(double x, Point point1, Point point2){
        double m = (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
        return m * (x - point1.getX()) + point1.getY();
    }
    public static Vector add(Vector v1, Vector v2){
        double x = v1.x + v2.x;
        double y = v1.y + v2.y;
        double magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double alpha = Math.atan(Math.toRadians(y /x));
        return new Vector(magnitude, alpha);
    }

    public void invert(){
        this.alpha = 180 + this.alpha;
    }


    public void setalpha(double alpha) {
        this.alpha = alpha;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public double getalpha() {
        return alpha;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isFrontOfTheCar() {
        return IsFrontOfTheCar;
    }

    public void setFrontOfTheCar(boolean frontOfTheCar) {
        IsFrontOfTheCar = frontOfTheCar;
    }
}
