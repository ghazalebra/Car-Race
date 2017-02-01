package view;

import controller.GameController;
import model.GameEngine;

import javax.swing.*;

/**
 * Created by sahar on 1/30/17.
 */
public class GameFrame extends JFrame {
    GameEngine engine = new GameEngine();
    ordinaryGamePanel panel = new ordinaryGamePanel();
    public void init(){
        GameController controller = new GameController();
        panel.init(controller, engine);
        controller.init(engine);
        GameFrame.this.setContentPane(panel);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
