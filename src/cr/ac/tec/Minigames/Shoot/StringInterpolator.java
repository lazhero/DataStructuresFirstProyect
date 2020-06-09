package cr.ac.tec.Minigames.Shoot;

import cr.ac.tec.Controls.IntHolder;
import cr.ac.tec.Random.Random;
import javafx.animation.Interpolator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class StringInterpolator extends Interpolator {
    ArrayList<String> List=new ArrayList<>();
    int RigthPos;
    IntHolder turns;
    boolean flag=true;
    String Currently;
    Timer myTimer;

    /**
     *
     * @param List
     * @param Rigthone
     * @param turns
     * @param pause
     */
    StringInterpolator(ArrayList<String> List,int Rigthone,IntHolder turns,int pause){
        this.List=List;
        this.RigthPos=Rigthone;
        this.turns=turns;
        this.myTimer=new Timer();
        this.Currently=List.get(0);
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                flag=true;
            }
        };
        Runnable runnable=()->{
            myTimer.schedule(task,pause,pause);
        };
        Thread t=new Thread(runnable);
        t.start();
    }

    /**
     *
     * @param v
     * @return
     */
    @Override
    protected double curve(double v) {
        return 0;
    }

    /**
     *
     * @param o
     * @param o1
     * @param v
     * @return
     */
    @Override
    public Object interpolate(Object o, Object o1, double v) {
        if(flag && turns.getSaved()>=0) {
            if (turns.getSaved() == 0) {
                Currently= List.get(RigthPos);
            } else {
                flag=false;
                turns.lowSaved(1);
                int i = Random.RandomNumber(List.size()) - 1;
                while (i == RigthPos) {
                    i = Random.RandomNumber(List.size()) - 1;
                }
                Currently=List.get(i);
            }
        }
        return Currently;
    }
}
