package view;

import controller.GameController;
import model.GameObjects.Player;
import model.GameObjects.PlayerProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by sahar on 1/30/17.
 */
public class WelcomeFrame extends JFrame {

    public void init(Player player){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel= new JPanel();
        panel.setLayout(new FlowLayout());
        JButton exitGameButton= new JButton("Exit");
        JButton openProfileButton= new JButton(String.valueOf(player.getPlayerProfile().getMoney()));
        panel.add(openProfileButton);
        panel.add(exitGameButton);
        openProfileButton.setPreferredSize(new Dimension(200,100));
        exitGameButton.setPreferredSize(new Dimension(200,100));
        panel.setPreferredSize(new Dimension(800,640));
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

        openProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeFrame.this.dispose();
                PlayerProfileFrame frame= new PlayerProfileFrame();
                frame.init(player);
                frame.setVisible(true);
            }
        });

        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeFrame.this.dispose();
            }
        });
    }
}
