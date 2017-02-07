package Test;

import controller.GameController;
import model.GameObjects.*;
import model.GameObjects.Point;
import view.WelcomeFrame;

import java.awt.*;

/**
 * Created by sahar on 2/1/17.
 */
public class carsTest {

    public static void main(String[] args) {
        Player player = new Player();
        PlayerProfile playerProfile= new PlayerProfile("Ali", 2000,100,200);
        player.setPlayerProfile(playerProfile);


        Engine engine1 = new Engine(1,3);
        Point startPoint= new Point(0,0);
        Vector startingSpeed= new Vector(1,90);
        CarProfile carProfile1= new CarProfile(4, 2, 5, engine1, 2, 5, 1, 2000, 1, 100, Color.blue);
        Car car1= new Car(carProfile1,startPoint,startingSpeed);
        player.buy(car1);

        Engine engine2 = new Engine(16,180);
        CarProfile carProfile2= new CarProfile(3,1.8,800,engine2,120000,140000,100,22500000,2,150,Color.YELLOW);
        Car car2= new Car(carProfile2,startPoint,startingSpeed);
        player.buy(car2);




        WelcomeFrame frame= new WelcomeFrame();
        frame.init(player);
        frame.setVisible(true);


    }
}
