package cr.ac.tec.Dice.Classes;

import javafx.scene.shape.Rectangle;

public class Animation {
    private double duration;
    private Rectangle coordinates[];

    public Animation(double duration, Rectangle coordinates[]) {
        this.duration = duration;
        this.coordinates = coordinates;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Rectangle[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Rectangle[] coordinates) {
        this.coordinates = coordinates;
    }

    public Rectangle calculateCurrentFrame(double t){
        int amountOfFrames = this.coordinates.length;
        int currentFrameIndex = (int)(t % (amountOfFrames * duration)/duration); //Analizar
        return coordinates[currentFrameIndex];
    }
}