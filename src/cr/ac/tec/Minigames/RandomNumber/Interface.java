package cr.ac.tec.Minigames.RandomNumber;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static cr.ac.tec.Minigames.RandomNumber.RandomNumberGame.restart;

public class Interface extends Application {

    public static Pane root = new Pane();
    static TextField inputNumber;
    static Button button = new Button("Go!");
    static Button restartButton = new Button("Restart");
    public static Text text = new Text();

    public static Parent createContent(){
        root.setPrefSize(300,300);

        inputNumber = createTextField(100,100,200);

        button.setPrefSize(50,50);
        button.setFont(Font.font(16));
        button.setTranslateX(125);
        button.setTranslateY(230);
        //button.setOnMouseClicked(e -> getNumber());

        restartButton.setTranslateX(10);
        restartButton.setTranslateY(10);
        restartButton.setOnMouseClicked(e -> restart());

        //text.setText("");
        text.setFont(Font.font(20));
        text.setTranslateX(85);
        text.setTranslateY(100);


        root.getChildren().addAll(inputNumber,button,text,restartButton);
        return root;
    }

    public static String getNumber(){
        return inputNumber.getText();
    }




    static TextField createTextField(int width, int posx, int posy) {
        TextField temp = new TextField();
        temp.setPrefWidth(width);
        temp.setTranslateX(posx);
        temp.setTranslateY(posy);
        return temp;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);

    }
}
