package controller;
import model.GameEngine;
import model.GameObjects.Player;
import view.ordinaryGamePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by sahar on 1/23/17.
 */
public class GameController{
    GameEngine engine;

    public void init(JPanel panel, Player player) {
        System.out.println("contoller init");
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }


            @Override
            public void keyPressed(KeyEvent e) {

                System.out.println("controller");
               // if (ordinaryGamePanel.isGameStarted()) {
                    int code = e.getKeyCode();
                    if (code == KeyEvent.VK_UP) {
                        System.out.println("current location  "+player.getActiveCar().getCurrentLocationPoint());

                        player.getActiveCar().pressGasPedal();
                    }
                    if (code == KeyEvent.VK_DOWN) {
                        player.getActiveCar().pressBrake();
                    }
                    if (code == KeyEvent.VK_LEFT) {
                        player.getActiveCar().pressLeftTurnButton();
                    }
                    if (code == KeyEvent.VK_RIGHT) {
                        player.getActiveCar().pressRightTurnButton();
                    }

              //  }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
