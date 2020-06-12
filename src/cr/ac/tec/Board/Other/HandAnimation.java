package cr.ac.tec.Board.Other;

import cr.ac.tec.Dice.Classes.Animation;
import javafx.scene.shape.Rectangle;

public class HandAnimation {
    private double duration;
    private Rectangle coordinates[];

    /**
     *
     * @param duration
     * @param coordiantes
     */
    public HandAnimation(double duration, Rectangle coordiantes[]){
        this.duration = duration;
        this.coordinates = coordiantes;
    }

    /**
     *
     * @param t
     * @return
     */
    public Rectangle calculateCurrentFrame(double t){
        int amountOfFrames = this.coordinates.length;
        int currentFrameIndex = (int)(t % (amountOfFrames * duration)/duration); //Analizar
        return coordinates[currentFrameIndex];
    }
}
