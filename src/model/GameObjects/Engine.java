package model.GameObjects;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Engine {
    private double EngineAcceleration;
    private double EngineMaxSpeed;
    private Vector positiveMaxSpeed;
    private Vector negativeMaxSpeed;

    public Engine(double engineAcceleration, double engineMaxSpeed){
        this.EngineAcceleration = engineAcceleration;
        this.EngineMaxSpeed = engineMaxSpeed;
        negativeMaxSpeed = new Vector(EngineMaxSpeed, 0);
    }


    public double getEngineAcceleration() {
        return EngineAcceleration;
    }

    public double getEngineMaxSpeed() {
        return EngineMaxSpeed;
    }
}
