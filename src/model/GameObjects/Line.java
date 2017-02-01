package model.GameObjects;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Line {

    private static int width = 3;
    private Side endSide;
    private Side startSide;
    Direction direction;

    public Line(Side endSide, Side startSide, Direction direction){
        this.direction = direction;
        this.endSide = endSide;
        this.startSide = startSide;
        endSide.addLine(this);
        endSide.addInputLine(this);
        startSide.addLine(this);
        startSide.addOutputLine(this);
    }

    public static int getWidth() {
        return width;
    }


    public Side getEndSide() {
        return endSide;
    }

    public void setEndSide(Side endSide) {
        this.endSide = endSide;
    }

    public Side getStartSide() {
        return startSide;
    }

    public void setStartSide(Side startSide) {
        this.startSide = startSide;
    }
}
