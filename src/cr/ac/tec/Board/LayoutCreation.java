package cr.ac.tec.Board;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class LayoutCreation {
    /*
    A class to create some JAvafx containers
     */

    /**
     * Creates an anchorpane
     * @param width sets the anchor panel width's
     * @param heigth sets the anchor height's
     * @return the anchor panel
     */
    public static AnchorPane Anchor(double width,double heigth){
        AnchorPane AnchorP =new AnchorPane();
        AnchorP.setPrefHeight(heigth);
        AnchorP.setPrefWidth(width);
        return AnchorP;

    }

    /**
     *
     * @param width the scroll width's
     * @param heigth the Scrolls height's
     * @return the scrollpane
     */
    public static ScrollPane scroll(double width,double heigth){
        ScrollPane scrolls=new ScrollPane();
        scrolls.setPrefViewportHeight(heigth);
        scrolls.setPrefViewportWidth(width);
        return scrolls;
    }
}
