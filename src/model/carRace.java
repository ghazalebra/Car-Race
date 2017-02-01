package model;

import javax.swing.*;
import controller.GameController;

import model.GameObjects.Player;
import model.GameObjects.PlayerProfile;
import view.WelcomeFrame;

import java.awt.*;

/**
 * Created by sahar on 1/23/17.
 */
public class carRace {
    public static void main(String[] args) {
//        JFrame jframe = new JFrame("CarRace");
//        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        GameEngine engine = new GameEngine();
//        GamePanel panel = new GamePanel();
//        GameController controller = new GameController();
//        panel.init(controller, engine);
//        controller.init(engine, panel);
//        jframe.setContentPane(panel);
//        jframe.setVisible(true);
//        jframe.pack();
//        jframe.setLocationRelativeTo((Component)null);
        Player player = new Player();
        PlayerProfile palyerProfile= new PlayerProfile("Ali", 2000,100,200);
        player.setPlayerProfile(palyerProfile);
        WelcomeFrame frame= new WelcomeFrame();
        frame.init(player);
        frame.setVisible(true);


    }
}
