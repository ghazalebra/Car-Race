package view;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Mahsa_Pc on 1/30/2017.
 */
public class TiledMap {

    private int y;

    public int getTileSize() {
        return tileSize;
    }

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


            for (int i = 0; i <7 ; i++) { //umadim 7 khate bala jke ye mosht tozihe alakie ro khundim ke mozaheme karemun nabashe :D
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

                if(rc==650){
                    g.setColor(Color.CYAN);
                }

                if(rc==654){
                    g.setColor(Color.GREEN);
                }

                if(rc==361){
                    g.setColor(Color.WHITE);
                }

                if(rc==31){
                    g.setColor(Color.lightGray);
                }

                g.fillRect(x+col*tileSize, y+row*tileSize, tileSize, tileSize);
            }
        }
    }
    public int getColTile(int x){
        return x/tileSize;
    }

    public int getRowTile(int y){
        return y/tileSize;
    }

    public int getTile(int row, int col){
        return map[row][col];
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
