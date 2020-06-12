package cr.ac.tec.Minigames.PRS;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class PRSGAME  {
    private Stage stage;

    public void StarGame(int dato1, int dato2){
        Stage primaryStage = new Stage();
        Scene scene=null;
        try {
            scene=new GetGame().getScene(dato1,dato2,primaryStage);

        }
        catch (Exception e){}
        primaryStage.setScene(scene);
        this.stage=primaryStage;
        primaryStage.show();


    }
    public Stage getStage(){
        return stage;
    }


}
