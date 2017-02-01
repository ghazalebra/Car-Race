package Test;

import model.GameObjects.*;
import view.WelcomeFrame;

/**
 * Created by sahar on 2/1/17.
 */
public class carsTest {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerProfile palyerProfile= new PlayerProfile("Ali", 2000,100,200);
        player.setPlayerProfile(palyerProfile);


        Engine engine1 = new Engine(8,100);
        Point startPoint= new Point(0,0);
        Vector startingSpeed= new Vector(startPoint,startPoint);
        CarProfile carProfile1= new CarProfile(2.5,1.5,1000,engine1,100000,100000,80,1440000,1,50000000);
        Car car1= new Car(carProfile1,startPoint,startingSpeed);
        player.buy(car1);

        Engine engine2 = new Engine(16,180);
        CarProfile carProfile2= new CarProfile(3,1.8,800,engine2,120000,140000,100,22500000,2,150000000);
        Car car2= new Car(carProfile2,startPoint,startingSpeed);
        player.buy(car2);




        WelcomeFrame frame= new WelcomeFrame();
        frame.init(player);
        frame.setVisible(true);


    }
}
