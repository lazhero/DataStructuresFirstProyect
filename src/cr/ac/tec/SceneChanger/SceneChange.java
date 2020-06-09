package cr.ac.tec.SceneChanger;

import javafx.scene.Scene;

public abstract class SceneChange {
    private Scene scene;

    /**
     *
     * @param scene
     */
    public abstract void setScene(Scene scene);

    /**
     *
     * @return
     */
    public abstract Scene getScene();
}
