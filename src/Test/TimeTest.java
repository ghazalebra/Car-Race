package Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ASUS on 08/12/2016.
 */
class SayHello extends TimerTask {
    public void run() {
        System.out.println("Hello World!");
    }

    public void f(){
        System.out.println("goodbye");
    }
}
public class TimeTest {
    public static void main(String[] args){
        Date date = new Date();
        long a = date.getTime();
        System.out.println(a);
        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 1);
    }
}
