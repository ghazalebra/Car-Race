package view;

import controller.GameController;
import model.GameEngine;
import model.GameObjects.Car;
import model.GameObjects.Player;

import javax.swing.*;

/**
 * Created by sahar on 1/30/17.
 */
public class GameFrame extends JFrame {
    GameEngine engine = new GameEngine();
    ordinaryGamePanel panel = new ordinaryGamePanel();
    Car activeCar=null;
    public void init(Player player){


        GameController controller = new GameController();
       // System.out.println(activeCar.getCarProfile().getPrice());
        panel.init(controller,engine,player);
        controller.init(engine);
        GameFrame.this.setContentPane(panel);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
