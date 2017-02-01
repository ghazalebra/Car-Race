package model.GameObjects;

/**
 * Created by ASUS on 09/12/2016.
 */
public class Point {
    private double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
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
}
