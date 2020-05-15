package cr.ac.tec.Dice.Classes;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashMap;

public class Dice extends Application {
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
    private boolean drawable = true;
    private Rectangle[] diceCoordinates;
    private int diceNumber1;
    private int diceNumber2;
    private int customY;
    private boolean lastDice;



    public Dice(){
        randomNumber();
        animations = new HashMap<String, Animation>();
        initializeAnimations();
    }


    public void rollDice(){
        createContent();
        cycle();
    }

    public void randomNumber(){
        diceNumber1= (int)(Math.random()*((6-1)+1))+1;
        System.out.println(diceNumber1);
        diceNumber2= (int)(Math.random()*((6-1)+1))+1;
        System.out.println(diceNumber2);
        int finalNumber = diceNumber1+diceNumber2;
        System.out.println("Final number: " + finalNumber);
    }

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

    public void loadImages(){
        images.put("dice", new Image("cr/ac/tec/Dice/Images/dice.png"));
        images.put("background", new Image("cr/ac/tec/Dice/Images/black.png"));
    }

    public void createContent(){
        images = new HashMap<String, Image>();
        loadImages();
        root = new Group();
        scene = new Scene(root,200,100, Color.BLACK);
        canvas = new Canvas(200,100);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
    }

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

    public void updateState(double t){
        calculateFrame(t);
    }

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

    public void draw(){
        graphicsContext.drawImage(images.get("dice"), x, y, width, height, 100, 0, 100, 100);
        graphicsContext.drawImage(images.get("dice"), x, y, width, height, 0, 0, 100, 100);
        if (lastDice) {
            finalImage(diceNumber2);
            //System.out.println(customY);
            graphicsContext.drawImage(images.get("dice"), x, customY, width, height, 100, 0, 100, 100);
        }
    }



    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        //createContent();
        rollDice();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dice");
        primaryStage.show();
        //cycle();
    }
}