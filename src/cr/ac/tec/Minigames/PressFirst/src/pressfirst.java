import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;


public class pressfirst extends Application {




    Random Aleatorio = new Random();
    int n = (Aleatorio.nextInt(4)+2)*4;

    private int scorep1=n;
    private int scorep2=n;
    private Text score1 = new Text("Score: " + scorep1);
    private Text score2 = new Text("Score:" + scorep2);
    private Text winnerp= new Text("");
    int cont1;
    int cont2;
    int victory;





    private Text p1 = new Text();
    private Text p2 = new Text();
    private Text random = new Text();


    public Parent createContent(){

        Pane root = new Pane();


        System.out.println(n);
        root.setPrefSize(700,700);
        Image img = new Image("/imagenes/fondo.jpg");
        ImageView fondo = new ImageView(img);


        score1.setTranslateY(600);
        score1.setTranslateX(120);
        score1.setFont(Font.font(25));
        score1.setFill(Color.WHITE);

        score2.setTranslateY(600);
        score2.setTranslateX(450);
        score2.setFont(Font.font(25));
        score2.setFill(Color.WHITE);

        winnerp.setTranslateY(100);
        winnerp.setTranslateX(300);
        winnerp.setFont(Font.font(25));
        winnerp.setFill(Color.WHITE);

        p1.setText("Player 1 \nPress 'A'");
        p1.setTranslateY(530);
        p1.setTranslateX(120);
        p1.setFont(Font.font(25));
        p1.setFill(Color.WHITE);

        p2.setText("Player 2 \nPress 'L' " );
        p2.setTranslateY(530);
        p2.setTranslateX(450);
        p2.setFont(Font.font(25));
        p2.setFill(Color.WHITE);

        random.setText("Deben presionar su respectiva tecla hasta llegar a 0: \n el primero gana GO! \n "+n);
        random.setTranslateY(30);
        random.setTranslateX(50);
        random.setFont(Font.font(25));
        random.setFill(Color.WHITE);

        root.getChildren().addAll(fondo,score1,score2,p1,p2,random,winnerp);
        return root;
    }

    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        String path = "src/musicf.mp3";
        Media audio = new Media(new File(path).toURI().toString());
        MediaPlayer repro = new MediaPlayer(audio);
        repro.setAutoPlay(true);

        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Press First");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}