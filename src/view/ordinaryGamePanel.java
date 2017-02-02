package view;

import controller.GameController;
import model.GameEngine;
import model.GameObjects.*;
import model.GameObjects.Point;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 * Created by sahar on 1/23/17.
 */
public class ordinaryGamePanel extends JPanel implements Runnable , KeyListener {

    Player player;
    GameController controller;
    GameEngine engine;
    public static final int WIDTH=800;
    public static final int HEIGHT=640;
    private Thread thread;
    private Boolean running;
    private BufferedImage image;
    private Graphics2D g;
    private int FPS=30;
    private int targetTime=1000/FPS;
    private TiledMap tiledMap;
    private CarGraphics carGraphics;

    public ordinaryGamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }


    public void init(GameController controller, GameEngine engine,Player player) {
        this.player=player;
        this.controller = controller;
        this.engine = engine;
        running=true;
        image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g=(Graphics2D)image.getGraphics();
        tiledMap=new TiledMap("map2.tmx", 8);

        System.out.println(player.getPlayerProfile().getMoney());
        carGraphics= new CarGraphics(player, tiledMap);
        player.getPlayerProfile().getCars().get(0).setCurrentSpeed(new Vector(0,0));
        player.getPlayerProfile().getCars().get(0).setCurrentLocationPoint(new Point(50,50));

    }

    public void addNotify(){
        super.addNotify();
        addKeyListener(this);
        if(thread==null){
            thread=new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        init(controller, engine , player);
        long startTime;
        long urdTime;
        long waitTime;

        while(running){
            startTime=System.nanoTime();
            update();
            render();
            draw();
            urdTime=(System.nanoTime()-startTime)/1000000;
            waitTime=targetTime-urdTime;

            try{
                Thread.sleep(waitTime);
            }catch(Exception e){}
        }
    }


    public void update(){
        tiledMap.update();
        carGraphics.update();
    }

    public void render(){
        tiledMap.draw(g);
        carGraphics.draw(g);

    }

    public void draw(){
        Graphics g2=getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if(code== KeyEvent.VK_UP){
            player.getPlayerProfile().getCars().get(0).pressGasPedal();
        }
        if(code == KeyEvent.VK_DOWN){
            player.getPlayerProfile().getCars().get(0).pressBrake();
        }
        if(code == KeyEvent.VK_LEFT){
            player.getPlayerProfile().getCars().get(0).pressLeftTurnButton();
        }
        if(code == KeyEvent.VK_RIGHT){
            player.getPlayerProfile().getCars().get(0).pressRightTurnButton();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code== KeyEvent.VK_UP){
            player.getPlayerProfile().getCars().get(0).releaseGasPedal();
        }
        if(code == KeyEvent.VK_DOWN){
            player.getPlayerProfile().getCars().get(0).releaseBreak();
        }
        if(code == KeyEvent.VK_LEFT){
            player.getPlayerProfile().getCars().get(0).releaseLeftTurnButton();
        }
        if(code == KeyEvent.VK_RIGHT){
            player.getPlayerProfile().getCars().get(0).releaseRightTurnButton();
        }



    }
}
