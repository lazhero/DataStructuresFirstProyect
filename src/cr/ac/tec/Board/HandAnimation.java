package cr.ac.tec.Board;

import cr.ac.tec.Dice.Classes.Animation;
import javafx.scene.shape.Rectangle;

/**
 * In this class the animation of the hands with the dice is performed
 */
public class HandAnimation {

    private double duration;
    private Rectangle coordinates[];

    /**
     * Is the hand animation
     * @author Miguel Mesen
     * @param duration
     * @param coordiantes
     */
    public HandAnimation(double duration, Rectangle coordiantes[]){
        this.duration = duration;
        this.coordinates = coordiantes;
    }

    /**
     * Calculates the coordinates of the frame
     * @author Miguel Mesen
     * @param t
     * @return
     */
    public Rectangle calculateCurrentFrame(double t){
        int amountOfFrames = this.coordinates.length;
        int currentFrameIndex = (int)(t % (amountOfFrames * duration)/duration); //Analizar
        return coordinates[currentFrameIndex];
    }
}
