package cr.ac.tec.Minigames.DiamondHunter.Classes;

import cr.ac.tec.Dice.Animation;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashMap;

public class AnimatedPlayer extends GameObject{
    private int life;
    private String currentAnimation;
    private HashMap<String, Animation> animations;

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
