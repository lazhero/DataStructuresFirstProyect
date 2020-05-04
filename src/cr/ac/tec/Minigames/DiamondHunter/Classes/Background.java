package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;

public class Background extends GameObject{
    public static int x;
    public static int y;

    public Background(int x, int y, int velocity, String imageName) {
        super(x, y, velocity, imageName);
        this.x = x;
    }

    public static int getY() {
        return y;
    }

    public static int getX() {
        return x;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(DiamondHunterGame.images.get(this.imageName),this.x,this.y);
    }

    @Override
    public void move() {
        if (DiamondHunterGame.right && x > -2040){ x -= velocity;}

        if (DiamondHunterGame.left && x < 0) { x += velocity; }

        if (DiamondHunterGame.down && y > -1600){ y -= velocity; }

        if (DiamondHunterGame.up && y < 0) { y += velocity; }
    }
}
