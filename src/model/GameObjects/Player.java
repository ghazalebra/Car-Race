package model.GameObjects;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Player {

    private PlayerProfile playerProfile;

    //constructor

    public void buy(Car car){
        playerProfile.setMoney(playerProfile.getMoney() - car.getCarProfile().getPrice());
        playerProfile.getCars().add(car);
        car.setPlayer(this);
    }

    public boolean canCompeteInRace(Match match){
        if (playerProfile.getPopularity() >= match.getRequiredPopularity())
            return true;
        return false;
    }

    //It will be called when he/she wants to play a race with one of his/her cars.
    public void play(Match match, Car car){
        if (canCompeteInRace(match)) {
            match.getPlayers().add(this);
            match.getCars().add(car);
            car.setActive(true);
            car.setMatch(match);
            car.start();
        }
    }

    public void repair(Car car){
        playerProfile.setMoney(playerProfile.getMoney() - (car.getCarProfile().getInitialBodyPower() - car.getCarProfile().getBodyPower()) * car.getCarProfile().getRepairCostPerUnit());
        car.getCarProfile().setBodyPower(car.getCarProfile().getInitialBodyPower());
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }
}
