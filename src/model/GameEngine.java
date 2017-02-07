package model;

import model.GameObjects.*;

import java.util.List;

/**
 * Created by ASUS on 08/12/2016.
 */
public class GameEngine {

    public static List<Car> cars;//Active cars
    private List<Player> players;
    private List<Match> matches;//bayad yeki bashe fekr konam
    private Match match;



    public void whoIsTheWinner(){
        match.getOrderOfCars().get(0).getPlayer().getPlayerProfile().setMoney(match.getOrderOfCars().get(0).getPlayer().getPlayerProfile().getMoney() + RealMatch.getFirstPrize().getMoney());
        match.getOrderOfCars().get(0).getPlayer().getPlayerProfile().setPopularity(RealMatch.getFirstPrize().getPopularity());
        match.getOrderOfCars().get(1).getPlayer().getPlayerProfile().setMoney(match.getOrderOfCars().get(1).getPlayer().getPlayerProfile().getMoney() + RealMatch.getSecondPrize().getMoney());
        match.getOrderOfCars().get(1).getPlayer().getPlayerProfile().setPopularity(RealMatch.getSecondPrize().getPopularity());
        match.getOrderOfCars().get(2).getPlayer().getPlayerProfile().setMoney(match.getOrderOfCars().get(2).getPlayer().getPlayerProfile().getMoney() + RealMatch.getThirdPrize().getMoney());
        match.getOrderOfCars().get(2).getPlayer().getPlayerProfile().setPopularity(RealMatch.getThirdPrize().getPopularity());
    }

    public static Car isCollisionOccurred(Car car){
        //ye if bayad bezarim khodesh ro check nakone!
        //bad shayad bayad ye jaye dige bashe.
        for (int i = 0; i < cars.size(); i++){

            // Rear Left

            if ((car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                    car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                    return cars.get(i);


            if ((car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);

            if ((car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);
            if ((car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getRearLeft().getY() <= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getRearLeft().getY() >= cars.get(i).formula(car.getRearLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);

            // Rear Right

            if ((car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);


            if ((car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);

            if ((car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);
            if ((car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getRearRight().getY() <= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getRearRight().getY() >= cars.get(i).formula(car.getRearRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);


            // Front Right
            if ((car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);


            if ((car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);

            if ((car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);
            if ((car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getFrontRight().getY() <= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getFrontRight().getY() >= cars.get(i).formula(car.getFrontRight().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);


            // Front Left

            if ((car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);


            if ((car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight()) &&
                    car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight())) &&
                    (car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);

            if ((car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft()) &&
                            car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight())))
                return cars.get(i);
            if ((car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getRearLeft(), cars.get(i).getRearRight()) &&
                    car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getFrontRight())) &&
                    (car.getFrontLeft().getY() <= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontRight(), cars.get(i).getRearRight()) &&
                            car.getFrontLeft().getY() >= cars.get(i).formula(car.getFrontLeft().getX(), cars.get(i).getFrontLeft(), cars.get(i).getRearLeft())))
                return cars.get(i);

        }
        return null;
    }

    public static void collision(Car car1, Car car2){

        Vector primarySpeed1 = car1.getCurrentSpeed();
        Vector primarySpeed2 = car2.getCurrentSpeed();

        double xParameter1 = (((car1.getCarProfile().getWeight() - (1/2) * car2.getCarProfile().getWeight())
                * car1.getCurrentSpeed().getX()) + (car2.getCarProfile().getWeight() + (1/2) * car1.getCarProfile().getWeight()) * car2.getCurrentSpeed().getX()) /
        (car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight());

        car1.getCurrentSpeed().setX(xParameter1);

        double yParameter1 = (((car1.getCarProfile().getWeight() - (1/2) * car2.getCarProfile().getWeight())
                * car1.getCurrentSpeed().getY()) + (car2.getCarProfile().getWeight() + (1/2) * car1.getCarProfile().getWeight()) * car2.getCurrentSpeed().getY()) /
                (car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight());

        car1.getCurrentSpeed().setY(yParameter1);

        Vector SpeedAlignedWithCar1;
        Vector SpeedPerpendicularCar1;

        double SpeedAlignedWithCar1Mag = car1.getCurrentSpeed().getY() * Math.sin(primarySpeed1.getalpha()) + car1.getCurrentSpeed().getX() * Math.cos(primarySpeed1.getalpha());
        double SpeedPerpendicularCar1Mag = car1.getCurrentSpeed().getX() * Math.sin(primarySpeed1.getalpha()) - car1.getCurrentSpeed().getY() * Math.cos(primarySpeed1.getalpha());

        SpeedAlignedWithCar1 = new Vector(SpeedAlignedWithCar1Mag, primarySpeed1.getalpha());
        SpeedPerpendicularCar1 = new Vector(SpeedPerpendicularCar1Mag, primarySpeed1.getalpha() - 90);


        double xParameter2 = (((car2.getCarProfile().getWeight() - (1/2) * car1.getCarProfile().getWeight())
                * car2.getCurrentSpeed().getX()) + (car1.getCarProfile().getWeight() + (1/2) * car2.getCarProfile().getWeight()) * car1.getCurrentSpeed().getX()) /
                (car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight());

        car2.getCurrentSpeed().setX(xParameter2);

        double yParameter2 = (((car2.getCarProfile().getWeight() - (1/2) * car1.getCarProfile().getWeight())
                * car2.getCurrentSpeed().getY()) + (car1.getCarProfile().getWeight() + (1/2) * car2.getCarProfile().getWeight()) * car1.getCurrentSpeed().getY()) /
                (car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight());

        car2.getCurrentSpeed().setY(yParameter2);

        Vector SpeedAlignedWithCar2;
        Vector SpeedPerpendicularCar2;

        double SpeedAlignedWithCar2Mag = car2.getCurrentSpeed().getY() * Math.sin(primarySpeed2.getalpha()) + car2.getCurrentSpeed().getX() * Math.cos(primarySpeed2.getalpha());
        double SpeedPerpendicularCar2Mag = car2.getCurrentSpeed().getX() * Math.sin(primarySpeed2.getalpha()) - car2.getCurrentSpeed().getY() * Math.cos(primarySpeed2.getalpha());

        SpeedAlignedWithCar2 = new Vector(SpeedAlignedWithCar2Mag, primarySpeed2.getalpha());
        SpeedPerpendicularCar2 = new Vector(SpeedPerpendicularCar2Mag, primarySpeed2.getalpha() - 90);

        car1.setCurrentSpeed(SpeedAlignedWithCar1);
        car2.setCurrentSpeed(SpeedAlignedWithCar2);


        car1.setPerpendicularSpeed(SpeedPerpendicularCar1);
        car2.setPerpendicularSpeed(SpeedPerpendicularCar2);

        double lostEnergyX = (3/8) * (Math.pow(car1.getCurrentSpeed().getX() - car2.getCurrentSpeed().getX(), 2)) * ((car1.getCarProfile().getWeight() * car2.getCarProfile().getWeight()) / (car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight()));
        double lostEnergyY = (3/8) * (Math.pow(car1.getCurrentSpeed().getY() - car2.getCurrentSpeed().getY(), 2)) * ((car1.getCarProfile().getWeight() * car2.getCarProfile().getWeight()) / (car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight()));
        double totalLostEnergy = lostEnergyX + lostEnergyY;
        car1.getCarProfile().setBodyPower(car1.getCarProfile().getBodyPower() - (car2.getCarProfile().getWeight()/(car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight())) * totalLostEnergy);
        car2.getCarProfile().setBodyPower(car2.getCarProfile().getBodyPower() - (car1.getCarProfile().getWeight()/(car1.getCarProfile().getWeight() + car2.getCarProfile().getWeight())) * totalLostEnergy);

    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }


    /*public static void main(String[] args){
        City city = new City("Tehran");
        Intersection intersection1 = new LIntersection(2, 2, Direction.UP, Direction.RIGHT);
        Intersection intersection2 = new LIntersection(2, 4, Direction.RIGHT, Direction.DOWN);
        Intersection intersection3 = new LIntersection(4, 4, Direction.LEFT, Direction.DOWN);
        Intersection intersection4 = new LIntersection(4, 2, Direction.LEFT, Direction.UP);



    }*/
}
