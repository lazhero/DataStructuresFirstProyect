package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;

public class AnimatedPlayer extends GameObject{
    private int life;
    private String currentAnimation;

    public AnimatedPlayer(int x, int y, int velocity, String imageName, int life, String currentAnimation) {
        super(x, y, velocity, imageName);
        this.life = life;
        this.currentAnimation = currentAnimation;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

    }

    @Override
    public void move() {

    }
}
