package cr.ac.tec.Minigames.DiamondHunter.Classes;

import cr.ac.tecLinkedList.List.DoubleList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashMap;

public class DiamondHunterGame extends Application {
    private GraphicsContext graphicsContext;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    public static HashMap<String, Image> images;
    private Background background;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;


    /**
     * Creates the interface in which the player interacts with.
     */
    public void createContent(){
        images = new HashMap<String, Image>();
        loadImages();
        background = new Background(0,0,0,"map");
        root = new Group();
        scene = new Scene(root,500,500);
        canvas = new Canvas(500,500);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    public void loadImages(){
        images.put("map", new Image("cr/ac/tec/Minigames/DiamondHunter/Images/map.png"));
        //images.put("diamond", new Image("Images/diamond.png"));
    }

    public void draw(){
        background.draw(graphicsContext);
    }

    /**
     * Everything we need to be updating per frame second will go in here, like movements and collisions.
     * @param t
     */
    public void updateState(double t){
    }


    /**
     * Sets an animation timer to see the games current frames per second and constantly updates the game with its images.
     */
    public void gameCycle(){
        long initialTime = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {

            //Este metodo se ejecuta aproximadamente unas 60 veces por segundo 60FPS.
            @Override
            public void handle(long currentTime) {
                double t = (currentTime - initialTime) / 1000000000.0;
                //System.out.println(t);
                updateState(t);
                draw();
            }
        };
        animationTimer.start();//Empieza el ciclo de juego.
    }





    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        createContent();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Diamond Hunter");
        primaryStage.show();
        gameCycle();
    }
}
