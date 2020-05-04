package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class AnimatedPlayer extends GameObject{
    private int life;
    private String currentAnimation;
    private int xImage;
    private int yImage;
    private int imageWidth;
    private int imageHeight;
    private HashMap<String, cr.ac.tec.Minigames.DiamondHunter.Classes.Animation> animations;

    public AnimatedPlayer(int x, int y, int velocity, String imageName, int life, String currentAnimation) {
        super(x, y, velocity, imageName);
        this.life = life;
        this.currentAnimation = currentAnimation;
        animations = new HashMap<String, Animation>();
        initializeAnimations();
    }


    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setCurrentAnimation(String currentAnimation){ this.currentAnimation = currentAnimation;}

    public Rectangle obtainRectangle(){
        return new Rectangle(x,y,imageWidth,imageHeight);
    }


    public void initializeAnimations(){
        Rectangle restFrontCoordinates[] = {
                new Rectangle(5,0,91,116),
                new Rectangle(125,0,91,116),
                new Rectangle(245,0,91,116)
        };
        Animation restFrontAnimation = new Animation(0.1,restFrontCoordinates);
        animations.put("restFront", restFrontAnimation);

        Rectangle restLeftCoordinates[] = {
                new Rectangle(15,135,86,111),
                new Rectangle(135,135,86,111),
                new Rectangle(255,135,86,111)
        };
        Animation restLeftAnimation = new Animation(0.1,restLeftCoordinates);
        animations.put("restLeft", restLeftAnimation);

        Rectangle restBackCoordinates[] = {
                new Rectangle(10,270,91,106)
        };
        Animation restBackAnimation = new Animation(0.1, restBackCoordinates);
        animations.put("restBack", restBackAnimation);

        Rectangle restRightCoordinates[] = {
                new Rectangle(10,395,86,111),
                new Rectangle(125,395,86,111),
                new Rectangle(250,395,86,111)
        };
        Animation restRightAnimation = new Animation(0.1, restRightCoordinates);
        animations.put("restRight", restRightAnimation);

        Rectangle runRightCoordinates[] = {
                new Rectangle(0,910,101,111),
                new Rectangle(130,910,96,111),
                new Rectangle(250,910,96,111),
                new Rectangle(365,915,96,111),
                new Rectangle(475,915,116,111),
                new Rectangle(605,910,101,111),
                new Rectangle(725,910,96,111),
                new Rectangle(855,910,96,101),
                new Rectangle(975,915,96,106),
                new Rectangle(1075,915,117,111)
        };
        Animation runRightAnimation = new Animation(0.1,runRightCoordinates);
        animations.put("runRight", runRightAnimation);

        Rectangle runFrontCoordinates[] = {
                new Rectangle(10,520,91,116),
                new Rectangle(130,515,91,111),
                new Rectangle(250,515,91,121),
                new Rectangle(370,515,91,121),
                new Rectangle(490,515,91,121),
                new Rectangle(610,520,91,116),
                new Rectangle(730,515,91,111),
                new Rectangle(850,515,91,121),
                new Rectangle(970,515,91,121),
                new Rectangle(1090,515,91,121)
        };
        Animation runFrontAnimation = new Animation(0.1, runFrontCoordinates);
        animations.put("runFront", runFrontAnimation);

        Rectangle runLeftCoordinates[] = {
                new Rectangle(0,655,116,111),
                new Rectangle(125,655,96,106),
                new Rectangle(240,650,96,101),
                new Rectangle(365,650,96,111),
                new Rectangle(485,650,101,111),
                new Rectangle(600,655,116,111),
                new Rectangle(725,655,96,111),
                new Rectangle(845,650,91,106),
                new Rectangle(970,650,96,106),
                new Rectangle(1085,650,101,111),
        };
        Animation runLeftAnimation = new Animation(0.1,runLeftCoordinates);
        animations.put("runLeft", runLeftAnimation);

        Rectangle runBackCoordinates[] = {
                new Rectangle(10,775,91,111),
                new Rectangle(130,775,91,111),
                new Rectangle(250,765,91,121),
                new Rectangle(370,765,91,121),
                new Rectangle(490,765,91,121),
                new Rectangle(610,775,91,111),
                new Rectangle(730,775,91,111),
                new Rectangle(850,765,91,111),
                new Rectangle(970,770,91,121),
                new Rectangle(1090,765,91,121),
        };
        Animation runBackAnimation = new Animation(0.1,runBackCoordinates);
        animations.put("runBack",runBackAnimation);
    }


    public void calculateFrame(double t){
        Rectangle coordinates = animations.get(currentAnimation).calculateCurrentFrame(t);
        this.xImage = (int) coordinates.getX();
        this.yImage = (int) coordinates.getY();
        this.imageHeight = (int) coordinates.getHeight();
        this.imageWidth = (int) coordinates.getWidth();
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(DiamondHunterGame.images.get(imageName), xImage, yImage, imageWidth, imageHeight, x, y, 47, 47);
    }

    @Override
    public void move() {

        if (DiamondHunterGame.right) {//Mover hacia la derecha
            x += velocity;
            return;
        }

        if (DiamondHunterGame.left) {//Mover hacia la izquierda
            x -= velocity;
            return;
        }

        if (DiamondHunterGame.up) {//Mover hacia arriba
            y -= velocity;
            return;
        }

        if (DiamondHunterGame.down) {//Mover hacia abajo
            y += velocity;
        }
    }

}
