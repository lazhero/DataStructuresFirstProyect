package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class DiamondHunterGame extends Application {
    private GraphicsContext graphicsContext;
    private Group root;
    private Scene scene;
    private Canvas canvas;


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




    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        createContent();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Diamond Hunter");
        primaryStage.show();
        //gameCycle();
    }
}
