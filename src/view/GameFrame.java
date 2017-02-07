package view;


import controller.GameController;
import model.GameEngine;
import model.GameObjects.Car;
import model.GameObjects.Player;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by sahar on 1/30/17.
 */


public class GameFrame extends JFrame {
    GameEngine engine = new GameEngine();
    ordinaryGamePanel panel;


    public void init(Player player){
        panel = new ordinaryGamePanel(player);
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JButton startTimerButton= new JButton("Start");
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(startTimerButton, BorderLayout.PAGE_START);
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        mainPanel.addKeyListener(panel);

//        startTimerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startTimerButton.setText(ordinaryGamePanel.time+"");
//            }
//        });

//        startTimerButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panel.setGameStarted(true);
//                timer.start();
//            }
//        });
//
//        timer = new Timer(100, new ActionListener() {
//            int counter=0;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startTimerButton.setText(counter/10+"."+counter%10);
//                counter++;
//            }
//        });

        GameController controller = new GameController();
        panel.init(controller,engine,player);
        controller.init(panel,player);
        GameFrame.this.setContentPane(mainPanel);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
