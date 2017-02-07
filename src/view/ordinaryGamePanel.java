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
    public static final int WIDTH = 800;
    public static final int HEIGHT = 640;
    private Thread thread;
    private Boolean running;
    private BufferedImage image;
    private Graphics2D g;
    private int FPS = 30;
    private int targetTime = 1000 / FPS;
    private TiledMap tiledMap;
    private CarGraphics carGraphics;
    private static boolean gameStarted;
    static int time;

    public static boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }


    public ordinaryGamePanel(Player player) {
        super();
        this.player=player;

//        this.setLayout(new BorderLayout());
//        JButton startTimerButton= new JButton("Start");
//        this.add(startTimerButton, BorderLayout.PAGE_START);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();


//        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//        g = (Graphics2D) image.getGraphics();
//        tiledMap = new TiledMap("map3.tmx", 8);  //////////////////????


    }


    public void init(GameController controller, GameEngine engine, Player player) {
        this.player = player;
        this.controller = controller;
        this.engine = engine;


//        running = true;
//        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//        g = (Graphics2D) image.getGraphics();
//        tiledMap = new TiledMap("map3.tmx", 8);
//
//        System.out.println(player.getPlayerProfile().getMoney());
//        carGraphics = new CarGraphics(player, tiledMap);
//        //player.getActiveCar().setCurrentSpeed(new Vector(0, 0));
//        //player.getActiveCar().setCurrentLocationPoint(new Point(50, 50));
//
//        player.getPlayerProfile().getCars().get(0).setCurrentSpeed(new Vector(0,0));
//        player.getPlayerProfile().getCars().get(0).setCurrentLocationPoint(new Point(50, 50));
    }

    public void init2(){


        running = true;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        tiledMap = new TiledMap("map3.tmx", 8);

        System.out.println(player.getPlayerProfile().getMoney());
        carGraphics = new CarGraphics(player, tiledMap);
        player.getActiveCar().setCurrentSpeed(new Vector(0, 0));
        player.getActiveCar().setCurrentLocationPoint(new Point(50, 50));

//        player.getPlayerProfile().getCars().get(0).setCurrentSpeed(new Vector(0,0));
//        player.getPlayerProfile().getCars().get(0).setCurrentLocationPoint(new Point(50, 50));
    }


    public void addNotify() {
        super.addNotify();
        this.addKeyListener(this);

        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }


        System.out.println("end of add notify");
    }

    @Override
    public void run() {

        init2();
        long startTime;
        long urdTime;
        long waitTime;

        while (running) {
            //System.out.println("runnnn");
            time++;

            startTime = System.nanoTime();
            update();
            render();
            draw();
            urdTime = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - urdTime;

            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {
            }
        }
    }


    public void update() {
        tiledMap.update();
        carGraphics.update();
        if(CarGraphics.isGameOver()){
            thread.stop();
        }
//        System.out.println(player.getActiveCar().getCurrentSpeed().getMagnitude());
//        System.out.println("x=  "+player.getActiveCar().getCurrentLocationPoint().getX()+"    y=  "+player.getActiveCar().getCurrentLocationPoint().getY());
    }

    public void render() {
        tiledMap.draw(g);
        carGraphics.draw(g);

    }

    public void draw() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

//


    @Override
    public void keyPressed(KeyEvent e) {

        // if (isGameStarted()) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            CarGraphics.setUp(true);
            System.out.println("x=  "+player.getActiveCar().getCurrentLocationPoint().getX()+"    y=  "+player.getActiveCar().getCurrentLocationPoint().getY());
        }
        if (code == KeyEvent.VK_DOWN) {
            CarGraphics.setDown(true);
            System.out.println("x=  "+player.getActiveCar().getCurrentLocationPoint().getX()+"    y=  "+player.getActiveCar().getCurrentLocationPoint().getY());

        }
        if (code == KeyEvent.VK_LEFT) {
            //CarGraphics.setLeft(true);
            player.getActiveCar().pressLeftTurnButton();
            player.getActiveCar().update();
            System.out.println("x=  "+player.getActiveCar().getCurrentLocationPoint().getX()+"    y=  "+player.getActiveCar().getCurrentLocationPoint().getY());

        }
        if (code == KeyEvent.VK_RIGHT) {
            CarGraphics.setRight(true);
            System.out.println("x=  "+player.getActiveCar().getCurrentLocationPoint().getX()+"    y=  "+player.getActiveCar().getCurrentLocationPoint().getY());

        }

        //    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //   if (isGameStarted()) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            CarGraphics.setUp(false);
        }
        if (code == KeyEvent.VK_DOWN) {
            CarGraphics.setDown(false);
        }
        if (code == KeyEvent.VK_LEFT) {
            CarGraphics.setLeft(false);
        }
        if (code == KeyEvent.VK_RIGHT) {
            CarGraphics.setRight(false);
        }


        //    }
    }
}
