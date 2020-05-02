package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int velocity;
    protected String imageName;
    protected int height;
    protected int width;

    public GameObject(int x, int y, int velocity, String imageName) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.imageName = imageName;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract void move();

}
