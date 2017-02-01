package model.GameObjects;

/**
 * Created by ASUS on 10/12/2016.
 */
public class CircularRealMatch extends Match {

    private double requiredMoney;
    private double requiredPopularity;
    private Prize prize;
    private int roundNumber;

    public CircularRealMatch(String path) {
        super(path);
        matchType = "CircularRealMatch";
    }
}
