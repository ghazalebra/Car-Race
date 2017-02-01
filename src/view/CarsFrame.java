package view;

import model.GameObjects.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sahar on 2/1/17.
 */
public class CarsFrame extends JFrame {
    public void init(Player player){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        player.getPlayerProfile().getCars();
        JLabel[] priceLabel=new JLabel[10];
        JPanel[] panel=new JPanel[10];

        for (int i = 0; i < player.getPlayerProfile().getCars().size(); i++) {
            panel[i]= new JPanel();
            priceLabel[i]= new JLabel(String.valueOf(player.getPlayerProfile().getCars().get(i).getCarProfile().getPrice()));
            panel[i].setLayout(new FlowLayout());
            panel[i].add(priceLabel[i]);
            this.add(panel[i]);
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }
}
