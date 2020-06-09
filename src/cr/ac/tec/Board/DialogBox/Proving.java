package cr.ac.tec.Board.DialogBox;

import cr.ac.tec.Board.LayoutCreation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Proving extends Application {
    public static void main(String[] args){
        launch(args);
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = LayoutCreation.Anchor(800,650);
        DialogBox dialogBox= new DialogBox.Builder()
                .SetButton1Image("src/Images/Enemigo11.png")
                .SetButton2Image("src/Images/Enemigo22.png")
                .SetHeight(600)
                .SetWidth(600)
                .setAction1(e-> System.out.println("Imprimir yes"))
                .setAction2(e-> System.out.println("Presione2"))
                .setBackGround("src/Images/fondo.png")
                .setText("Hola mundo")
                .Build();
        dialogBox.setAnchorPane();
        dialogBox.Draw(anchorPane,0,0);
        Scene scene=new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
