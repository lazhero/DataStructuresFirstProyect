package cr.ac.tec.Board.Other;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * This class add or changes a container's content
 * @author Andrey Zuñiga
 */

public class LayoutNewContent {
    /**
     * Add a new Node to an anchorPane
     * @author Andrey Zuñiga
     * @param anchorPane the AnchorPane
     * @param node The widget to be added
     * @param Top the distance from the Top,if  is 0 wont be setted
     * @param Bottom the distance from the Bottom,if  is 0 wont be setted
     * @param Right the distance from the Right,if  is 0 wont be setted
     * @param Left the distance from the Left,if  is 0 wont be setted
     */
    public static void Add(AnchorPane anchorPane,Node node,double Top,double Bottom,double Right,double Left){
        anchorPane.getChildren().add(node);
        if(Top!=0.0) anchorPane.setTopAnchor(node,Top);
        if(Bottom!=0.0)anchorPane.setBottomAnchor(node,Bottom);
        if(Left!=0.0)anchorPane.setLeftAnchor(node,Left);
        if(Right!=0.0)anchorPane.setRightAnchor(node,Right);
    }

    /**
     * Add a new layout to an anchor pane
     * @author Andrey Zuñiga
     * @param anchorPane the AnchorPane
     * @param node The widget to be added
     * @param Top the distance from the Top,if  is 0 wont be setted
     * @param Bottom the distance from the Bottom,if  is 0 wont be setted
     * @param Right the distance from the Right,if  is 0 wont be setted
     * @param Left the distance from the Left,if  is 0 wont be setted
     */
    public static void Add(AnchorPane anchorPane, Pane node, double Top, double Bottom, double Right, double Left){
        anchorPane.getChildren().add(node);
        if(Top!=0.0) anchorPane.setTopAnchor(node,Top);
        if(Bottom!=0.0)anchorPane.setBottomAnchor(node,Bottom);
        if(Left!=0.0)anchorPane.setLeftAnchor(node,Left);
        if(Right!=0.0)anchorPane.setRightAnchor(node,Right);
        if(Top==Bottom)anchorPane.setTopAnchor(node,Top);
        if(Left==Right)anchorPane.setLeftAnchor(node,Left);
    }

    /**
     * Updates a scrolls content's
     * @author Andrey Zuñiga
     * @param scroll The Scroll
     * @param node The new content
     */
    public static void Update(ScrollPane scroll,Node node){
        scroll.setContent(node);
    }
}
