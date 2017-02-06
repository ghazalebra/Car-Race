package Test;

import model.GameObjects.*;

import model.GameObjects.Point;

import java.awt.*;

import java.util.Timer;

/**
 * Created by ASUS on 05/02/2017.
 */
public class LogicalTest {
    public static void main(String[] args){


        Engine engine = new Engine(2, 8);

        CarProfile carProfile = new CarProfile(4, 2, 5, engine, 2, 5, 1, 50, 1, 100, Color.GREEN);
        Point startPoint = new Point(0, 0);
        Vector primarySpeed = new Vector(2, 30);
        Timer timer = new Timer();
        Car car = new Car(carProfile, startPoint, primarySpeed);
        //timer.schedule(car, 0, 1000);
        //car.pressGasPedal();
        car.pressRightTurnButton();
        timer.schedule(car, 0, 1000);
    }
}
