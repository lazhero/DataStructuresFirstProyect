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


    public void eventHandler(){
        boolean[] isPressable = {true};
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            //El metodo handle se ejecuta cada vez que presiono una tecla.
            @Override
            public void handle(KeyEvent event) {
                if (isPressable[0]) {
                    if (event.getCode().toString() == "A") {
                        isPressable[0] = false;
                        left = true;
                        //animatedPlayer.setCurrentAnimation("runLeft");
                        return;
                    }
                    if (event.getCode().toString() == "W") {
                        isPressable[0] = false;
                        up = true;
                        //animatedPlayer.setCurrentAnimation("runBack");
                        return;
                    }
                    if (event.getCode().toString() == "S") {
                        isPressable[0] = false;
                        down = true;
                        //animatedPlayer.setCurrentAnimation("runFront");
                        return;
                    }
                    if (event.getCode().toString() == "D") {
                        isPressable[0] = false;
                        right = true;
                        //animatedPlayer.setCurrentAnimation("runRight");
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            //Este metodo se ejecuta cuando se suelta una tecla.
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString() == "A" && left){
                    isPressable[0] = true;
                    left = false;
                    //animatedPlayer.setCurrentAnimation("restLeft");
                    return;
                }
                if (event.getCode().toString() == "W" && up){
                    isPressable[0] = true;
                    up = false;
                    //animatedPlayer.setCurrentAnimation("restBack");
                    return;
                }
                if (event.getCode().toString() == "S" && down){
                    isPressable[0] = true;
                    down = false;
                    //animatedPlayer.setCurrentAnimation("restFront");
                    return;
                }
                if (event.getCode().toString() == "D" && right){
                    isPressable[0] = true;
                    right = false;
                    //animatedPlayer.setCurrentAnimation("restRight");
                }
            }
        });
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
