package view;

import model.GameObjects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahar on 2/1/17.
 */
public class CarsFrame extends JFrame {
    public void init(Player player){
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton[] carIndex= new JButton[10];
        JLabel[] nextline= new JLabel[10];

        JLabel[] widthLabel=new JLabel[10];
        JLabel[] lengthLabel=new JLabel[10];
        JLabel[] weightLabel=new JLabel[10];
        JLabel[] initialBodyPowerLabel=new JLabel[10];
        JLabel[] maximumSpeedLabel=new JLabel[10];
        JLabel[] accelerationLabel=new JLabel[10];
        JLabel[] steeringWheelPowerLabel=new JLabel[10];
        JLabel[] breakAccelerationLabel=new JLabel[10];
        JLabel[] repairCostPerUnitLabel=new JLabel[10];
        JLabel[] priceLabel=new JLabel[10];
        JLabel[] verticalFrictionLabel=new JLabel[10];

        JPanel[] panel=new JPanel[10];

        JScrollPane scrollFrame = new JScrollPane(mainPanel);
        mainPanel.setAutoscrolls(true);

        for (int i = 0; i < player.getPlayerProfile().getCars().size(); i++) {

            panel[i]= new JPanel();

            carIndex[i]= new JButton("Car "+i);
            nextline[i]= new JLabel(" ");

            lengthLabel[i]= new JLabel("Length : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getLength()));
            widthLabel[i]= new JLabel("Width : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getWidth()));
            weightLabel[i]= new JLabel("Weight : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getWeight()));
            initialBodyPowerLabel[i]= new JLabel("Initial BodyPower : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getInitialBodyPower()));
            maximumSpeedLabel[i]= new JLabel("Maximum Speed : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getEngine().getEngineMaxSpeed()));
            accelerationLabel[i]= new JLabel("Acceleration : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getEngine().getEngineAcceleration()));
            steeringWheelPowerLabel[i]= new JLabel("SteeringWheel Power : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getSteeringWheelPower()));
            breakAccelerationLabel[i]= new JLabel("Break Acceleration : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getBrakeAcceleration()));
            repairCostPerUnitLabel[i]= new JLabel("RepairCost PerUnit : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getRepairCostPerUnit()));
            priceLabel[i]= new JLabel("Price : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getPrice()));
            verticalFrictionLabel[i]= new JLabel("Vertical Friction : "+String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getVerticalFriction()));

            panel[i].setLayout(new BoxLayout(panel[i],BoxLayout.Y_AXIS));

            panel[i].add(carIndex[i]);
            panel[i].add(nextline[i]);
            panel[i].add(lengthLabel[i]);
            panel[i].add(widthLabel[i]);
            panel[i].add(weightLabel[i]);
            panel[i].add(initialBodyPowerLabel[i]);
            panel[i].add(maximumSpeedLabel[i]);
            panel[i].add(accelerationLabel[i]);
            panel[i].add(steeringWheelPowerLabel[i]);
            panel[i].add(breakAccelerationLabel[i]);
            panel[i].add(repairCostPerUnitLabel[i]);
            panel[i].add(priceLabel[i]);
            panel[i].add(verticalFrictionLabel[i]);
            panel[i].add(nextline[i]);

            mainPanel.add(panel[i]);

        }

        JButton backButton= new JButton("Back");
        panel[player.getPlayerProfile().getCars().size()-1].add(backButton);

        //this.setContentPane(mainPanel);
        for (int i = 0; i < player.getPlayerProfile().getCars().size(); i++) {
            int finalI=i;
            carIndex[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.getPlayerProfile().getCars().get(finalI).setActive(true);
                    System.out.println(carIndex+" "+player.getPlayerProfile().getCars().get(finalI).isActive()+" "+player.getPlayerProfile().getCars().get(finalI).getCarProfile().getWeight());
                    // /System.out.println(player.getPlayerProfile().getCars().get(finalI).getCarProfile().getPrice());
                }
            });
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsFrame.this.dispose();
                PlayerProfileFrame frame= new PlayerProfileFrame();
                frame.init(player);
                frame.setVisible(true);
            }
        });

        this.add(scrollFrame);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
