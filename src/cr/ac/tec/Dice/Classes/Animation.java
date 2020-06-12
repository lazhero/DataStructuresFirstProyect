package cr.ac.tec.Dice.Classes;

import javafx.scene.shape.Rectangle;

/**
 * The dice animation
 * @author Miguel Mesen
 */
public class Animation {
    private double duration;
    private Rectangle coordinates[];

    /**
     * Characteristics of the animation
     * @author Miguel Mesen
     * @param duration
     * @param coordinates
     */
    public Animation(double duration, Rectangle coordinates[]) {
        this.duration = duration;
        this.coordinates = coordinates;
    }

    /**
     * Gets the duration of the animation
     * @author Miguel Mesen
     * @return
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Change the duration of the animation
     * @author Miguel Mesen
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Get Coordinates
     * @author Miguel Mesen
     * @return
     */
    public Rectangle[] getCoordinates() {
        return coordinates;
    }

    /**
     * Change the coordinates of the frame
     * @author Miguel Mesen
     * @param coordinates
     */
    public void setCoordinates(Rectangle[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * calculates the coordinates of the frame
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