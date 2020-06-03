package cr.ac.tec.Board.Count;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox=new HBox();
        Counter counter=new Counter(100,40,"Resources/Images/Numero",".png");
        counter.setCount(111);
        hBox.getChildren().addAll(counter.getAnchorPane());
        Scene scene=new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }
}
