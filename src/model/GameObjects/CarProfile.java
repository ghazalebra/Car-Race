package model.GameObjects;

/**
 * Created by ASUS on 09/12/2016.
 */
public class CarProfile {
    private double length;
    private double width;
    private double weight;
    private Engine engine;
    private double verticalFriction;
    private double steeringWheelPower;
    private double breakAcceleration;
    private double bodyPower;
    private double repairCostPerUnit;
    private double price;
    private double initialBodyPower;

    public CarProfile(double length, double width, double weight, Engine engine, double verticalFriction, double steeringWheelPower, double brakeAcceleration, double bodyPower, double repairCostPerUnit, double price) {
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.engine = engine;
        this.verticalFriction = verticalFriction;
        this.steeringWheelPower = steeringWheelPower;
        this.breakAcceleration = brakeAcceleration;
        this.bodyPower = bodyPower;
        this.repairCostPerUnit = repairCostPerUnit;
        this.price = price;
        this.initialBodyPower = bodyPower;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setVerticalFriction(double verticalFriction) {
        this.verticalFriction = verticalFriction;
    }

    public void setSteeringWheelPower(double steeringWheelPower) {
        steeringWheelPower = steeringWheelPower;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }

    public Engine getEngine() {
        return engine;
    }

    public double getSteeringWheelPower() {
        return steeringWheelPower;
    }

    public double getVerticalFriction() {
        return verticalFriction;
    }
    public double getBrakeAcceleration() {
        return breakAcceleration;
    }

    public void setBrakeAcceleration(double brakeAcceleration) {
        this.breakAcceleration = brakeAcceleration;
    }
    public double getBodyPower() {
        return bodyPower;
    }

    public void setBodyPower(double bodyPower) {
        this.bodyPower = bodyPower;
    }

    public double getRepairCostPerUnit() {
        return repairCostPerUnit;
    }

    public void setRepairCostPerUnit(double repairCostPerUnit) {
        this.repairCostPerUnit = repairCostPerUnit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInitialBodyPower() {
        return initialBodyPower;
    }
}
