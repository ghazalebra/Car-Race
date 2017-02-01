package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 16/12/2016.
 */
public class StraightRealMatch extends Match{

    private double requiredMoney;
    private double requiredPopularity;
    private Prize prize;
    private List<Car> orderOfCars;

    public StraightRealMatch(String path) {
        super(path);
        matchType = "StraightRealMatch";
        orderOfCars = new ArrayList<Car>();
    }

    public List<Car> getOrderOfCars() {
        return orderOfCars;
    }

    public void setOrderOfCars(List<Car> orderOfCars) {
        this.orderOfCars = orderOfCars;
    }
}
