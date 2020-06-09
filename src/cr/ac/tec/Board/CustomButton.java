package cr.ac.tec.Board;

import javafx.geometry.Pos;
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

    /**
     *
     * @param image
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public CustomButton(Image image,int x, int y, int w, int h){
        this.image = image;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        Rectangle rectangle = new Rectangle(x,y,w,h);
        rectangle.setTranslateX(x);
        rectangle.setTranslateY(y);
        rectangle.setFill(null);
        rectangle.setStroke(Color.LIGHTGREEN);
        getChildren().addAll(rectangle);
    }
}
