package model.GameObjects;

/**
 * Created by ASUS on 16/12/2016.
 */
public class RealMatch {
    private static Prize firstPrize;
    private static Prize secondPrize;
    private static Prize thirdPrize;


    RealMatch(Prize firstPrize, Prize secondPrize, Prize thirdPrize){
        RealMatch.firstPrize = firstPrize;
        RealMatch.secondPrize = secondPrize;
        RealMatch.thirdPrize = thirdPrize;
    }
    public static Prize getFirstPrize() {
        return firstPrize;
    }

    public static void setFirstPrize(Prize firstPrize) {
        RealMatch.firstPrize = firstPrize;
    }

    public static Prize getSecondPrize() {
        return secondPrize;
    }

    public static void setSecondPrize(Prize secondPrize) {
        RealMatch.secondPrize = secondPrize;
    }

    public static Prize getThirdPrize() {
        return thirdPrize;
    }

    public static void setThirdPrize(Prize thirdPrize) {
        RealMatch.thirdPrize = thirdPrize;
    }
}
