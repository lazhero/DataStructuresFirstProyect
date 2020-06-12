package cr.ac.tec.Board.Other;

import cr.ac.tec.Board.Other.RectanglePlaced;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * This class creates javafx widgets
 * @author Andrey Zuñiga
 */
public class WidgetCreation {

    /**
     * Creates a button with its text
     * @author Andrey Zuñiga
     * @param text A String with the text that will be shown by the button
     * @return The button instance
     */
    public static Button CreateButton(String text){
        Button button;
        if(!text.equalsIgnoreCase("")){
        button=new Button(text);}
        else{
            button=new Button();
        }
        return button;
    }

    /**
     *
     * Creates Rectangle instance
     * @author Andrey Zuñiga
     * @param coordX The upper left vertex coordx
     * @param coordY he upper left vertex coord y
     * @param width the Rectangle Width
     * @param height the Rectangle Heigth
     * @return The rectangle instance
     */
    public static Rectangle CreateRec(double coordX, double coordY, double width, double height){
        Rectangle rect=new Rectangle();
        rect.setX(coordX);
        rect.setY(coordY);
        rect.setWidth(width);
        rect.setHeight(height);
        rect.setFill(Color.GREEN);
        rect.setArcHeight(40);
        rect.setArcWidth(40);
        return rect;
    }

    /**
     * @author Andrey Zuñiga
     * @param coordX the left corner's x cord
     * @param coordY the left corner's y cord
     * @param width the rectangle width
     * @param height the rectangle's height
     * @param color JavaFx's Paint
     * @return a RectanglePlaced object
     */
    public static RectanglePlaced CreateRecP(double coordX, double coordY, double width, double height, Paint color){
        RectanglePlaced rect=new RectanglePlaced();
        rect.setX(coordX);
        rect.setY(coordY);
        rect.setWidth(width);
        rect.setHeight(height);
        rect.setFill(color);
        rect.setArcHeight(35);
        rect.setArcWidth(25);
        return rect;
    }
}
