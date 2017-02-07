package view;

import model.GameObjects.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahar on 2/1/17.
 */
public class ChoosePracticeGamePath extends JFrame {
    public void init(Player player){
        Car car=null;
        JPanel panel= new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JButton circularPathButton= new JButton("Circular Path");
        JButton straightPathButton= new JButton("Straight Path");
        JButton irregularPathButton= new JButton("Irregular Path");

        panel.add(circularPathButton);
        panel.add(straightPathButton);
        panel.add(irregularPathButton);

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

        for (int i = 0; i < player.getPlayerProfile().getCars().size() ; i++) {
            if(player.getPlayerProfile().getCars().get(i).isActive()){
                car=player.getPlayerProfile().getCars().get(i);
               // System.out.println(car.getCarProfile().getPrice());
            }
        }

        Car finalCar= car;

        circularPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChoosePracticeGamePath.this.dispose();
                CircularTimeMatch match= new CircularTimeMatch("circularPath",1);
                player.play(match,finalCar);
                GameFrame frame= new GameFrame();
                frame.init(player);
                frame.setVisible(true);

            }
        });

        straightPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChoosePracticeGamePath.this.dispose();
                StraightTimeMatch match= new StraightTimeMatch("straightPath");
                player.play(match,finalCar);
                GameFrame frame= new GameFrame();
                frame.init(player);
                frame.setVisible(true);
            }
        });

        irregularPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChoosePracticeGamePath.this.dispose();
                GameFrame frame= new GameFrame();
                frame.init(player);
                frame.setVisible(true);
            }
        });

    }
}
