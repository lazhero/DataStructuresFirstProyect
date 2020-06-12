package cr.ac.tec.Dice.Classes;

import cr.ac.tec.Board.Other.Board;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

/**
 * This class defines the die, its characteristics
 * @author  Miguel Mesen
 */
public class Dice{
    private GraphicsContext graphicsContext;
    private HashMap<String, Image> images;
    private HashMap<String, Animation> animations;
    private int x;
    private int y;
    private int height;
    private int width;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    public static boolean drawable = true;
    private Rectangle[] diceCoordinates;
    private int diceNumber1;
    private int diceNumber2;
    private int customY;
    public static boolean lastDice;
    public static int finalNumber;

    /**
     * @author Miguel Mesen
     * @return
     */
    public int getFinalNumber() {
        return finalNumber;
    }

    /**
     * Generates a random number
     * @autor Miguel Mesen
     */
    public void randomNumber(){
        diceNumber1= (int)(Math.random()*((6-1)+1))+1;
        diceNumber2= (int)(Math.random()*((6-1)+1))+1;
        int finalNumber = diceNumber1+diceNumber2;
        this.finalNumber = finalNumber;
    }

    /**
     * It initializes the animations
     * @author Miguel Mesen
     */
    public void initializeAnimations(){
        diceCoordinates= new Rectangle[]{
                new Rectangle(0,1536,512,512),//1
                new Rectangle(0,0,512,512),//2
                new Rectangle(0,1024,512,512),//3
                new Rectangle(0,2048,512,512),//4
                new Rectangle(0,512,512,512),//5
                new Rectangle(0,3072,512,512),//6
                new Rectangle(0,2560,512,512),//?
        };
        Animation diceAnimations = new Animation(1,diceCoordinates);
        animations.put("rollingDice", diceAnimations);
    }

    /**
     * Load the images
     * @author Miguel Mesen
     */
    public void loadImages(){
        images.put("dice", new Image("Resources/Images/dice.png"));
        images.put("background", new Image("Resources/Images/black.png"));
    }

    /**
     * Calculates the coordinates of the frame
     * @author Miguel Mesen
     * @param t
     */
    public void calculateFrame(double t){
        Rectangle coordinates = animations.get("rollingDice").calculateCurrentFrame(t);
        this.x = (int) coordinates.getX();
        this.y =  (int) coordinates.getY();
        this.width = (int) coordinates.getWidth();
        this.height = (int)  coordinates.getHeight();
        if (coordinates.getY() == 2560){
            drawable=false;
        }
    }

    /**
     * Update the frame coordinates
     *@author Miguel Mesen
     * @param t
     */
    public void updateState(double t){
        calculateFrame(t);
    }

    /**
     *@author Miguel Mesen
     * @param number
     */
    public void finalImage(int number){
        switch (number){
            case 1 :
                customY=y =1536;
                break;
            case 2 :
                customY=y =0;
                break;
            case 3 :
                customY=y =1024;
                break;
            case 4 :
                customY=y =2048;
                break;
            case 5 :
                customY=y =512;
                break;
            case 6 :
                customY=y =3072;
                break;
        }
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
                if (drawable) {
                    draw();
                } else {
                    finalImage(diceNumber1);
                    draw();
                    lastDice=true;
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
        Board.graphicsContext.drawImage(images.get("dice"), x, y, width, height, 850, 0, 100, 100);
        Board.graphicsContext.drawImage(images.get("dice"), x, y, width, height, 750, 0, 100, 100);
        if (lastDice) {
            finalImage(diceNumber2);

            Board.graphicsContext.drawImage(images.get("dice"), x, customY, width, height, 850, 0, 100, 100);
        }
    }

    /**
     * Start the animation
     * @author Miguel Mesen
     */
    public void start(){
        lastDice=false;
        drawable=true;
        images = new HashMap<String, Image>();
        loadImages();
        cycle();
        randomNumber();
        animations = new HashMap<String, Animation>();
        initializeAnimations();
    }
}