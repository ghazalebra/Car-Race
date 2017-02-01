package view;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Mahsa_Pc on 1/30/2017.
 */
public class TiledMap {
    private int x;
    private int y;
    private int tileSize;
    private int [][] map;
    private int mapWidth;
    private int mapHeigh;

    public TiledMap(String s, int tileSize ){
        this.tileSize=tileSize;
        try{
            BufferedReader br=new BufferedReader(new FileReader(s));
            mapWidth=100;
            mapHeigh=80;
            map=new int[mapHeigh][mapWidth];


            for (int i = 0; i <24 ; i++) { //umadim 7 khate bala jke ye mosht tozihe alakie ro khundim ke mozaheme karemun nabashe :D
                br.readLine();
            }

            String delimiters=",";
            for (int row = 0; row <mapHeigh ; row++) {
                String line=br.readLine();
                System.out.println(line);
                String[] tokens=line.split(delimiters);
                for (int col = 0; col <mapWidth ; col++) {
                    map[row][col]=Integer.parseInt(tokens[col]);
                }

            }
        } catch (Exception e){}
    }

    public void update(){

    }

    public void draw(Graphics2D g){
        for (int row = 0; row <mapHeigh ; row++) {
            for (int col = 0; col <mapWidth ; col++) {
                int rc=map[row][col];

                if(rc==706){
                    g.setColor(Color.GRAY);
                }

                if(rc==455 || rc==169){
                    g.setColor(Color.GREEN);
                }

                if(rc==703){
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x+col*tileSize, y+row*tileSize, tileSize, tileSize);
            }
        }
    }
}
