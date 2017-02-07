package view;

import model.GameEngine;
import model.GameObjects.*;
import model.GameObjects.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sahar on 2/2/17.
 */
public class CarGraphics {

    TiledMap tiledMap;
    Car activeCar;
    Player player;


    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        CarGraphics.gameOver = gameOver;
    }

    private static boolean gameOver;

    double dx=0;
    double dy=0;

    public static void setLeft(boolean left) {
        CarGraphics.left = left;
    }

    public static void setRight(boolean right) {
        CarGraphics.right = right;
    }

    public static void setUp(boolean up) {
        CarGraphics.up = up;
    }

    public static void setDown(boolean down) {
        CarGraphics.down = down;
    }

    private static boolean left;
    private static boolean right;
    private static boolean up;
    private static boolean down;

    private boolean topLeft;
    private boolean topRight;
    private boolean bottomLeft;
    private boolean bottomRight;


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

    public void calculateCorners(double x, double y){
        int leftTile = tiledMap.getColTile((int)(x - 4));
        int rightTile = tiledMap.getRowTile((int)(x + 4)-1);
        int topTile = tiledMap.getRowTile((int)(y - 4));
        int bottomTile = tiledMap.getRowTile((int)(y + 4)-1);

        topLeft = (tiledMap.getTile(topTile,leftTile)== 650 || tiledMap.getTile(topTile,leftTile)== 654 || tiledMap.getTile(topTile,leftTile)== 332 );
        topRight = (tiledMap.getTile(topTile, rightTile)== 650 || tiledMap.getTile(topTile,rightTile)== 654 || tiledMap.getTile(topTile,rightTile)== 332);
        bottomLeft = (tiledMap.getTile(bottomTile, leftTile)== 650 || tiledMap.getTile(bottomTile, leftTile)== 654 || tiledMap.getTile(bottomTile, leftTile)== 332);
        bottomRight = (tiledMap.getTile(bottomTile, rightTile)== 650 || tiledMap.getTile(bottomTile, rightTile)== 654 || tiledMap.getTile(bottomTile, rightTile)== 332);
    }

    public void update(){

   //     player.getActiveCar().update();

///////////// determine next position
       if(left||right) {
            if (left) {
                dx -= activeCar.getCarProfile().getEngine().getEngineAcceleration();
                if (dx < -activeCar.getCarProfile().getEngine().getEngineMaxSpeed()) {
                    dx = -activeCar.getCarProfile().getEngine().getEngineMaxSpeed();
                }
            }else if (right) {
                dx += activeCar.getCarProfile().getEngine().getEngineAcceleration();
                if (dx > activeCar.getCarProfile().getEngine().getEngineMaxSpeed()) {
                    dx = activeCar.getCarProfile().getEngine().getEngineMaxSpeed();
                }
            }
        }


        if(up||down) {
            if (up) {
                dy -= activeCar.getCarProfile().getEngine().getEngineAcceleration();
                if (dy < -activeCar.getCarProfile().getEngine().getEngineMaxSpeed()) {
                    dy = -activeCar.getCarProfile().getEngine().getEngineMaxSpeed();
                }
            } else if (down) {
                dy += activeCar.getCarProfile().getEngine().getEngineAcceleration();
                if (dy > activeCar.getCarProfile().getEngine().getEngineMaxSpeed()) {
                    dy = activeCar.getCarProfile().getEngine().getEngineMaxSpeed();
                }
            }
        }




///////////// checking for collision

        int currCol = tiledMap.getColTile((int) player.getActiveCar().getCurrentLocationPoint().getX());
        int currRow = tiledMap.getRowTile((int) player.getActiveCar().getCurrentLocationPoint().getY());

        double tox = activeCar.getCurrentLocationPoint().getX()+dx;
        double toy = activeCar.getCurrentLocationPoint().getY()+dy;

        double tempy= activeCar.getCurrentLocationPoint().getY();
        double tempx= activeCar.getCurrentLocationPoint().getX();

        calculateCorners(activeCar.getCurrentLocationPoint().getX(),toy);

        /////// collisison with walls

        if(dy < 0){
            if(topLeft || topRight){
                double totalSpeed = Math.pow(dx*dx+dy*dy, (0.5));
                double primaryKineticEnergy = Math.pow(totalSpeed, 2) * activeCar.getCarProfile().getWeight() * (0.5);
                activeCar.getCarProfile().setBodyPower(activeCar.getCarProfile().getBodyPower() - (0.75) * primaryKineticEnergy);

                tempy = currRow * tiledMap.getTileSize() + 4;
                dy = -(0.5)*dy;


            }
            else{
                tempy += dy;
            }
        }
        if(dy > 0){
            if(bottomLeft || bottomRight){

                double totalSpeed = Math.pow(dx*dx+dy*dy, (0.5));
                double primaryKineticEnergy = Math.pow(totalSpeed, 2) * activeCar.getCarProfile().getWeight() * (0.5);
                activeCar.getCarProfile().setBodyPower(activeCar.getCarProfile().getBodyPower() - (0.75) * primaryKineticEnergy);

                tempy = ((currRow +1) * tiledMap.getTileSize() - 4);
                dy = -(0.5)*dy;


            }
            else{
                tempy += dy;
            }
        }


        calculateCorners(tox, activeCar.getCurrentLocationPoint().getY());
        if(dx <0){
            if(topLeft || bottomLeft){
                double totalSpeed = Math.pow(dx*dx+dy*dy, (0.5));
                double primaryKineticEnergy = Math.pow(totalSpeed, 2) * activeCar.getCarProfile().getWeight() * (0.5);
                activeCar.getCarProfile().setBodyPower(activeCar.getCarProfile().getBodyPower() - (0.75) * primaryKineticEnergy);
                dx = -(0.5)*dx;
                tempx = currCol * tiledMap.getTileSize() + 4;
            }
            else{
                tempx += dx;
            }
        }

        if(dx >0){
            if(topRight || bottomRight){
                double totalSpeed = Math.pow(dx*dx+dy*dy, (0.5));
                double primaryKineticEnergy = Math.pow(totalSpeed, 2) * activeCar.getCarProfile().getWeight() * (0.5);
                activeCar.getCarProfile().setBodyPower(activeCar.getCarProfile().getBodyPower() - (0.75) * primaryKineticEnergy);
                tempx = (currCol + 1) * tiledMap.getTileSize() - 4;
                dx = -(0.5)*dx;

            }
            else{
                tempx += dx;
            }
        }


        ////// collision with other cars
//        GameEngine.collision(activeCar, GameEngine.isCollisionOccurred(activeCar));////// ye null pointer mide felan commentesh kardam badan vaghti ba shabake mashinaye dg ham ezafe konim doros mishe



        // updateing final location
        activeCar.setCurrentLocationPoint(new Point(tempx,tempy));

//

        //move the map


//        tiledMap.setX((int) (ordinaryGamePanel.WIDTH / 2 - activeCar.getCurrentLocationPoint().getX()));
//        tiledMap.setY((int) (ordinaryGamePanel.HEIGHT / 2 - activeCar.getCurrentLocationPoint().getY()));


    }

    public void draw(Graphics2D g){

        int tx = tiledMap.getX();
        int ty = tiledMap.getY();

        g.setColor(activeCar.getCarProfile().getColor());

        if(activeCar.getCarProfile().getBodyPower() < activeCar.getCarProfile().getInitialBodyPower()*(0.1)){
            System.out.println("hello");
            g.setColor(activeCar.getCarProfile().getColor());
            g.setColor(Color.gray);
        }

        if(activeCar.getCarProfile().getBodyPower() < 0){
            System.out.println(activeCar.getCarProfile().getBodyPower());
            JOptionPane.showMessageDialog(null, "Game over !");
            setGameOver(true);

        }
        g.fillRect((int)(tx + activeCar.getCurrentLocationPoint().getX() - 8/2)
                    , (int) (ty + activeCar.getCurrentLocationPoint().getY() - 8/2)
                        ,8,8);


    }
}
