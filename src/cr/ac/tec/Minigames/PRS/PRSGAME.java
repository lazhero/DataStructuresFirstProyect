package cr.ac.tec.Minigames.PRS;



import cr.ac.tec.Board.Other.LayoutCreation;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 */

public class PRSGAME  {
    private Stage stage;

    /**
     * This method starts the game
     * @author Andrey Zuñiga
     * @param dato1
     * @param dato2
     */

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

    /**
     * Gets the scene
     * @author Andrey Zuñiga
     * @return
     */
    public Stage getStage(){
        return stage;
    }


}
