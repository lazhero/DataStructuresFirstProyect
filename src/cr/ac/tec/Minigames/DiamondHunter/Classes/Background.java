package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;

public class Background extends GameObject{
    public Background(int x, int y, int velocity, String imageName) {
        super(x, y, velocity, imageName);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(DiamondHunterGame.images.get(this.imageName),this.x,this.y);
    }

    @Override
    public void move() {
    }
}
