package cr.ac.tec.Board;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CustomButton extends StackPane {
    private Image image;
    private int x;
    private int y;
    private double w;
    private double h;

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    /**
     *
     * @param image
     * @param x
     * @param y
     * @param w
     * @param h
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
