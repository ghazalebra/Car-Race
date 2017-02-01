package model.GameObjects;

/**
 * Created by ASUS on 09/12/2016.
 */
public class Prize {
    private double money;
    private double popularity;

    Prize(double money, double popularity){
        this.money = money;
        this.popularity = popularity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
