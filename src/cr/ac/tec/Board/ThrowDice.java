package cr.ac.tec.Board;

import cr.ac.tec.Dice.Classes.Dice;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class ThrowDice {
    private HashMap<String, Image> images;
    private HashMap<String, HandAnimation> animations;
    private Rectangle[] handCoordinates;
    private int x;
    private int y;
    private int width;
    private int height;
    private int xImage;
    private int yImage;
    private int widthImage;
    private int heightImage;
    private boolean drawable=true;

    /**
     *
     */
    public void loadImages(){
        images.put("RollingDiceGif", new Image("Resources/Images/RollingDiceGif.png"));
    }

    /**
     *
     */
    public void initializeAnimations(){
        handCoordinates = new Rectangle[]{
             new Rectangle(0,0,364,312),
             new Rectangle(364,0,364,312),
             new Rectangle(728,0,364,312),
             new Rectangle(1092,0,364,312),
             new Rectangle(1456,0,364,312),
             new Rectangle(0,312,364,312),
             new Rectangle(364,312,364,312),
             new Rectangle(728,312,364,312),
             new Rectangle(1092,312,364,312),
             new Rectangle(1456,312,364,312),
             new Rectangle(0,624,364,312),
             new Rectangle(364,624,364,312),
        };
        HandAnimation handAnimation = new HandAnimation(0.2,handCoordinates);
        animations.put("handAnimation", handAnimation);
    }

    /**
     *
     * @param t
     */
    public void calculateFrame(double t){
        Rectangle coordinates = animations.get("handAnimation").calculateCurrentFrame(t);
        this.xImage = (int) coordinates.getX();
        this.yImage = (int) coordinates.getY();
        this.heightImage = (int) coordinates.getHeight();
        this.widthImage = (int) coordinates.getWidth();

        if(coordinates.getX()==364 && coordinates.getY()==624){
            drawable=false;
        }
    }

    /**
     *
     * @param t
     */
    public void updateState(double t){
        calculateFrame(t);
    }

    /**
     *
     */
    public void cycle(){
        long initialTime = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long currentTime) {
                double t = (currentTime - initialTime) / 1000000000.0;
                updateState(t);
                if (drawable){
                    draw();
                } 
            }
        };
        animationTimer.start();
    }

    /**
     *
     */
    public void draw(){
        Board.graphicsContext.drawImage(images.get("RollingDiceGif"),xImage,yImage,widthImage,heightImage,5,5,140,120);
    }

    /**
     *
     */
    public void start(){
        Board.displayHandImage=false;
        images = new HashMap<String, Image>();
        loadImages();
        cycle();
        animations = new HashMap<String, HandAnimation>();
        initializeAnimations();
        Board.dice.start();
    }
}
