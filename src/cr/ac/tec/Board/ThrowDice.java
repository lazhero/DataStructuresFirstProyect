package cr.ac.tec.Board;

import cr.ac.tec.Dice.Classes.Dice;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

/**
 * Here the movement of the hand with the dice develops
 * @author Miguel Mesen
 */
public class ThrowDice {
    private HashMap<String, Image> images;
    private HashMap<String, HandAnimation> animations;
    private Rectangle[] handCoordinates;
    private int x;//pos in X
    private int y; // Pos in Y
    private int width;
    private int height;
    private int xImage;
    private int yImage;
    private int widthImage;
    private int heightImage;
    private boolean drawable=true;

    /**
     * Used to load images
     * @author Miguel Mesen
     *
     */
    public void loadImages(){
        images.put("RollingDiceGif", new Image("Resources/Images/RollingDiceGif.png"));
    }

    /**
     * It initializes the animations
     * @author Miguel Mesen
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
     * Calculates the coordinates of the frame
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
     * Updates the coordinates of the frame
     * @author Miguel Mesen
     * @param t
     */
    public void updateState(double t){
        calculateFrame(t);
    }

    /**
     * @author Miguel Mesen
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
     * Draw the contents on the board
     * @author Miguel Mesen
     */
    public void draw(){
        Board.graphicsContext.drawImage(images.get("RollingDiceGif"),xImage,yImage,widthImage,heightImage,770,510,240,206);
    }

    /**
     * Start the animation
     * @author Miguel Mesen
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
