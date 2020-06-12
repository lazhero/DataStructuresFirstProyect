package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int velocity;
    protected String imageName;
    protected int height;
    protected int width;

    /**
     *Method used to define the characteristics of the object
     * @author Miguel Mesen
     * @param x
     * @param y
     * @param velocity
     * @param imageName
     */
    public GameObject(int x, int y, int velocity, String imageName) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.imageName = imageName;
    }

    /**
     * Method used to draw on screen
     * @author Miguel Mesen
     *
     * @param graphicsContext
     */
    public abstract void draw(GraphicsContext graphicsContext);

    /**
     *
     * Method used to move elements
     * @author Miguel Mesen
     */
    public abstract void move();
}
