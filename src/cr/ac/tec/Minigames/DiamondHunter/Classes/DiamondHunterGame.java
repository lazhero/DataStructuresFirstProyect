package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;

public class DiamondHunterGame extends Application {
    private GraphicsContext graphicsContext;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    public static HashMap<String, Image> images;



    /**
     * Creates the interface in which the player interacts with.
     */
    public void createContent(){
        root = new Group();
        scene = new Scene(root,300,300);
        canvas = new Canvas(300,300);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    public void draw(){

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
