package cr.ac.tec.Minigames.Shoot;

import cr.ac.tec.Images.GetImages;
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class ImageInterpolator extends Interpolator {
    private String Route;
    private String Format;
    private double counter=0.0;
    private int Amount;
    private Timer myTimer;
    private boolean change;
    public ImageInterpolator(String Route,String Format,int Amount,int pause){
        super();
        this.Route=Route;
        this.Format=Format;
        this.Amount=Amount;
        this.change=false;
        this.myTimer=new Timer();
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                change=true;
            }
        };
        Runnable runnable=()->{
            myTimer.schedule(task,pause,pause);
        };
        Thread t=new Thread(runnable);
        t.start();
    }
    @Override
    protected double curve(double v) {
        if(change){
            counter++;
            counter=counter%Amount;
            change=false;
        }
        return counter;
    }
    @Override
    public Object interpolate(Object o, Object o1, double v) {
        int c=(int)curve(0);
      String s=Route+Integer.toString(c+1)+Format;
        Image i= GetImages.getImage(s);
      return i;
    }

}

