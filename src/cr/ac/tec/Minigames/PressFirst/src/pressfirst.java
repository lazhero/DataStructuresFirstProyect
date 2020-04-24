import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;



public class pressfirst extends Application {



    public Parent createContent(){

        Pane root = new Pane();


        root.setPrefSize(700,700);

        root.getChildren().addAll();
        return root;
    }

    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Press First");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}