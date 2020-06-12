package cr.ac.tec.SceneChanger;

import javafx.scene.Scene;

/**
 * class to make a change of scene
 * @author Andrey Zuñiga
 */
public abstract class SceneChange {
    private Scene scene;

    /**
     * Method that changes the scene
     * @author Andrey Zuñiga
     * @param scene
     */
    public abstract void setScene(Scene scene);

    /**
     * Gets the scene
     * @author Andrey Zuñiga
     * @return
     */
    public abstract Scene getScene();
}
