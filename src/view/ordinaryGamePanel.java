package view;

import controller.GameController;
import model.GameEngine;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by sahar on 1/23/17.
 */
public class ordinaryGamePanel extends JPanel implements Runnable {

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

    public ordinaryGamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }


    public void init(GameController controller, GameEngine engine) {
        this.controller = controller;
        this.engine = engine;
        running=true;
        image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g=(Graphics2D)image.getGraphics();
        tiledMap=new TiledMap("map2.tmx", 8);

    }

    public void addNotify(){
        super.addNotify();
        if(thread==null){
            thread=new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        init(controller, engine);
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
    }

    public void render(){
        tiledMap.draw(g);
    }

    public void draw(){
        Graphics g2=getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}
