package model.GameObjects;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Engine {
    private double EngineAcceleration;
    private int EngineMaxSpeed;
    private Vector positiveMaxSpeed;
    private Vector negativeMaxSpeed;

    public Engine(int engineAcceleration, int engineMaxSpeed){
        this.EngineAcceleration = engineAcceleration;
        this.EngineMaxSpeed = engineMaxSpeed;
        negativeMaxSpeed = new Vector(EngineMaxSpeed, 0);
    }


    public double getEngineAcceleration() {
        return EngineAcceleration;
    }

    public int getEngineMaxSpeed() {
        return EngineMaxSpeed;
    }
}
