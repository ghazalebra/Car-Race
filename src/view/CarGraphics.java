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

        for (int i = 0; i < player.getPlayerProfile().getCars().size() ; i++) {
            if(player.getPlayerProfile().getCars().get(i).isActive()){
                player.setActiveCar(player.getPlayerProfile().getCars().get(i));
            }
        }
        activeCar= player.getActiveCar();
    }

    public void update(){
        activeCar.update();

        //move the map
        tiledMap.setX((int) (ordinaryGamePanel.WIDTH / 2 - activeCar.getCurrentLocationPoint().getX()));
        tiledMap.setY((int) (ordinaryGamePanel.HEIGHT / 2 - activeCar.getCurrentLocationPoint().getY()));


    }

    public void draw(Graphics2D g){
        int tx = tiledMap.getX();
        int ty = tiledMap.getY();

        g.setColor(activeCar.getCarProfile().getColor());
        g.fillRect((int)(tx + activeCar.getCurrentLocationPoint().getX() - 10/2)
                    , (int) (ty + activeCar.getCurrentLocationPoint().getY() - 20/2)
                        ,10,20);


    }
}
