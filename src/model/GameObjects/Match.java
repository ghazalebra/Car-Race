package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Match {
    private Path path;
    private List<Player> players;
    private List<Car> cars;
    //private int popularity;//in chi gharare bashe?
    private double requiredPopularity;
    //private int requiredMoney;
    private int roundNumber;
    protected String matchType;
    private List<Car> orderOfCars;

    public Match(Path path){
        players = new ArrayList<Player>();
        cars = new ArrayList<Car>();
        this.path = path;
        orderOfCars = new ArrayList<Car>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Path getPath() {
        return path;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public double getRequiredPopularity() {
        return requiredPopularity;
    }

    public void setRequiredPopularity(double requiredPopularity) {
        this.requiredPopularity = requiredPopularity;
    }

    public List<Car> getOrderOfCars() {
        return orderOfCars;
    }

    public void setOrderOfCars(List<Car> orderOfCars) {
        this.orderOfCars = orderOfCars;
    }
}
