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
public class PlayerProfileFrame extends Frame {

    Player player;

    public void init(Player player){
        JPanel panel= new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel Label1= new JLabel("popularity");
        JLabel Label2= new JLabel("money");
        JLabel popularityLabel= new JLabel(String.valueOf(player.getPlayerProfile().getPopularity()));
        JLabel moneyLabel= new JLabel(String.valueOf(player.getPlayerProfile().getMoney()));

        JButton startPracticeGameButton= new JButton("Start Practice Game");
        //JButton startGameButton= new JButton("Start Practice Game");
        JButton startRealRaceButton= new JButton("Start Real Race");

        JPanel topPanel= new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(Label1);
        topPanel.add(popularityLabel);

        JPanel centerPanel= new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(Label2);
        centerPanel.add(moneyLabel);


        JPanel buttomPanel= new JPanel();
        buttomPanel.setLayout(new FlowLayout());
        buttomPanel.add(startPracticeGameButton);
        buttomPanel.add(startRealRaceButton);

        panel.add(buttomPanel,BorderLayout.SOUTH);
        panel.add(centerPanel,BorderLayout.CENTER);
        panel.add(topPanel,BorderLayout.NORTH);
        //startGameButton.setPreferredSize(new Dimension(200,100));
        panel.setPreferredSize(new Dimension(800,640));
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        startPracticeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerProfileFrame.this.dispose();
                GameFrame frame= new GameFrame();
                frame.init();
                frame.setVisible(true);
            }
        });
    }
}
