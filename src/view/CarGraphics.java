package view;

import model.GameObjects.Car;
import model.GameObjects.Player;

import java.awt.*;

/**
 * Created by sahar on 2/2/17.
 */
public class CarGraphics {

    TiledMap tiledMap;
    Car activeCar;
    Player player;


    public CarGraphics(Player player, TiledMap tiledMap){
        this.player=player;
        this.tiledMap=tiledMap;

        for (int i = 0; i < 2 ; i++) {
            if(player.getPlayerProfile().getCars().get(i).isActive()){
                activeCar= player.getPlayerProfile().getCars().get(i);
            }
        }
    }

    public void update(){
        activeCar.update();


    }

    public void draw(Graphics2D g){
        int tx = tiledMap.getX();
        int ty = tiledMap.getY();

        g.setColor(Color.cyan);
        g.fillRect((int)(tx + activeCar.getCurrentLocationPoint().getX() - activeCar.getCarProfile().getWidth()/2)
                    , (int) (ty + activeCar.getCurrentLocationPoint().getY() - activeCar.getCarProfile().getLength()/2)
                        ,(int)activeCar.getCarProfile().getWidth(), (int)activeCar.getCarProfile().getLength());


    }
}
