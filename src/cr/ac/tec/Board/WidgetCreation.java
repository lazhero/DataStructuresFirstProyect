package cr.ac.tec.Board;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class WidgetCreation {
    /*
    This class creates javafx widgets
     */

    /**
     * Creates a button with its text
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
     * Creates Rectangle instance
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

}
