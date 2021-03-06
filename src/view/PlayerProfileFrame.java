package view;

import model.GameObjects.Player;
import model.GameObjects.PlayerProfile;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sahar on 1/30/17.
 */
public class PlayerProfileFrame extends JFrame {

    Player player;

    public void init(Player player){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel= new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel Label1= new JLabel("Popularity");
        JLabel Label2= new JLabel("Money");
        JLabel popularityLabel= new JLabel(String.valueOf(player.getPlayerProfile().getPopularity()));
        JLabel moneyLabel= new JLabel(String.valueOf(player.getPlayerProfile().getMoney()));

        JButton carsButton= new JButton("Cars");

        JButton startPracticeGameButton= new JButton("Start Practice Game");
        //JButton startGameButton= new JButton("Start Practice Game");
        JButton startRealRaceButton= new JButton("Start Real Race");

        JPanel topPanel= new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(Label1);
        topPanel.add(popularityLabel);

        JPanel centerPanel= new JPanel();
        centerPanel.setLayout(new BorderLayout());
        JPanel centralPanelsTop= new JPanel();
        centralPanelsTop.setLayout(new FlowLayout());
        centralPanelsTop.add(Label2);
        centralPanelsTop.add(moneyLabel);
        centerPanel.add(centralPanelsTop,BorderLayout.NORTH);

        JButton repairButton= new JButton("Repair");
        repairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                player.getActiveCar().getCarProfile().setBodyPower(player.getActiveCar().getCarProfile().getBodyPower()+1);
                player.getPlayerProfile().setMoney(player.getPlayerProfile().getMoney()- player.getActiveCar().getCarProfile().getRepairCostPerUnit());
                moneyLabel.setText(player.getPlayerProfile().getMoney()+"");

            }
        });

        JPanel centerCentralPanle= new JPanel();
        centerCentralPanle.setLayout(new BoxLayout(centerCentralPanle,BoxLayout.Y_AXIS));
        centerCentralPanle.add(carsButton);
        centerCentralPanle.add(repairButton);

        centerPanel.add(centerCentralPanle, BorderLayout.CENTER);


        JPanel bottomPanel= new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(startPracticeGameButton);
        bottomPanel.add(startRealRaceButton);

        panel.add(bottomPanel,BorderLayout.SOUTH);
        panel.add(centerPanel,BorderLayout.CENTER);
        panel.add(topPanel,BorderLayout.NORTH);
        //startGameButton.setPreferredSize(new Dimension(200,100));
        //panel.setPreferredSize(new Dimension(800,640));
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        startPracticeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerProfileFrame.this.dispose();
                ChoosePracticeGamePath frame= new ChoosePracticeGamePath();
                frame.init(player);
                frame.setVisible(true);
            }
        });

        carsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerProfileFrame.this.dispose();
                CarsFrame frame= new CarsFrame();
                frame.init(player);
                frame.setVisible(true);
            }
        });
    }
}
