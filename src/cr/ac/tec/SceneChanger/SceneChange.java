package cr.ac.tec.SceneChanger;

import javafx.scene.Scene;

public abstract class SceneChange {
    private Scene scene;
    public abstract void setScene(Scene scene);
    public abstract Scene getScene();

}
