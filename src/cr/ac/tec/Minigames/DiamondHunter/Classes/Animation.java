package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.shape.Rectangle;
/**
 *
 */

public class Animation {
    private double duration;
    private Rectangle coordinates[];

    /**
     * Method for making the animation
     * @uthor Miguel Mesen
     * @param duration
     * @param coordinates
     */
    public Animation(double duration, Rectangle coordinates[]) {
        this.duration = duration;
        this.coordinates = coordinates;
    }

    /**
     *
     * @return
     */
    public double getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public Rectangle[] getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @param coordinates
     */
    public void setCoordinates(Rectangle[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Method to cover the dimensions
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
