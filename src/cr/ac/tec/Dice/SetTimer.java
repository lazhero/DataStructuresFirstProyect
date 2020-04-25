package cr.ac.tec.Dice;

import java.util.Timer;
import java.util.TimerTask;

public class SetTimer {


    public static void setTimer(int time){

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                Animation.stopAnimation();
                System.out.println("timer stopped");
            }
        }, time);
    }

}
