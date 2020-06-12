package cr.ac.tec.Board.Other;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class customizes a button
 * @author Miguel Mesen
 */
public class CustomButton extends StackPane {
    private Image image;
    private int x;
    private int y;
    private double w;
    private double h;

    /**
     * @author Miguel Mesen
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * @author Miguel Mesen
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @author Miguel Mesen
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @author Miguel Mesen
     * @return
     */
    public double getW() {
        return w;
    }

    /**
     * @author Miguel Mesen
     * @return
     */
    public double getH() {
        return h;
    }

    /**
     * customizes a button
     * @author Miguel Mesen
     * @param image
     * @param x position in X
     * @param y position in Y
     * @param w weight
     * @param h height
     */
    public CustomButton(Image image,int x, int y, int w, int h, Color color){
        this.image = image;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        Rectangle rectangle = new Rectangle(x,y,w,h);
        rectangle.setTranslateX(x);
        rectangle.setTranslateY(y);
        rectangle.setFill(null);
        rectangle.setStroke(color);
        getChildren().addAll(rectangle);
    }
}
