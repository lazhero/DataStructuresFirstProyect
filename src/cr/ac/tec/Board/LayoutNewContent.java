package cr.ac.tec.Board;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LayoutNewContent {
    /*
    This class add or changes a container's content
     */

    /**
     * Add a new Node to an anchorPane
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
    public static void Add(AnchorPane anchorPane, Pane node, double Top, double Bottom, double Right, double Left){
        anchorPane.getChildren().add(node);
        if(Top!=0.0) anchorPane.setTopAnchor(node,Top);
        if(Bottom!=0.0)anchorPane.setBottomAnchor(node,Bottom);
        if(Left!=0.0)anchorPane.setLeftAnchor(node,Left);
        if(Right!=0.0)anchorPane.setRightAnchor(node,Right);
    }

    /**
     * Uddates a scrolls content's
     * @param scroll The Scroll
     * @param node The new content
     */
    public static void Update(ScrollPane scroll,Node node){

        scroll.setContent(node);
    }

}
