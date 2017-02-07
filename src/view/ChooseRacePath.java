package view;

import model.GameObjects.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahar on 2/1/17.
 */
public class ChooseRacePath extends JFrame {
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
                ChooseRacePath.this.dispose();
                CircularRealMatch match= new CircularRealMatch("CircularPath");
                if(match.getRequiredPopularity()<player.getPlayerProfile().getPopularity()) {

                    if(finalCar.getCarProfile().getBodyPower()< (0.3)* finalCar.getCarProfile().getInitialBodyPower()){
                        player.play(match, finalCar);
                        GameFrame frame = new GameFrame();
                        frame.init(player);
                        frame.setVisible(true);
                    }

                    else{
                        JOptionPane.showMessageDialog(null, " you must repair your car first! ");
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "Not popular enough!");
                }

            }
        });

        straightPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseRacePath.this.dispose();
                StraightRealMatch match= new StraightRealMatch("StraightPath");
                if(match.getRequiredPopularity()<player.getPlayerProfile().getPopularity()) {

                    if(finalCar.getCarProfile().getBodyPower()< (0.3)* finalCar.getCarProfile().getInitialBodyPower()) {

                        player.play(match, finalCar);
                        GameFrame frame = new GameFrame();
                        frame.init(player);
                        frame.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, " you must repair your car first! ");
                    }


                }
                else{
                    JOptionPane.showMessageDialog(null, "Not popular enough!");
                }
            }
        });

        irregularPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseRacePath.this.dispose();
                GameFrame frame= new GameFrame();
                frame.init(player);
                frame.setVisible(true);
            }
        });



    }
}
