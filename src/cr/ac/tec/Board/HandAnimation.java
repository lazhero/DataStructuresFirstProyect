package cr.ac.tec.Board;

import cr.ac.tec.Dice.Classes.Animation;
import javafx.scene.shape.Rectangle;

public class HandAnimation {
    private double duration;
    private Rectangle coordinates[];

    public HandAnimation(double duration, Rectangle coordiantes[]){
        this.duration = duration;
        this.coordinates = coordiantes;
    }

    public Rectangle calculateCurrentFrame(double t){
        int amountOfFrames = this.coordinates.length;
        int currentFrameIndex = (int)(t % (amountOfFrames * duration)/duration); //Analizar
        return coordinates[currentFrameIndex];
    }
}
