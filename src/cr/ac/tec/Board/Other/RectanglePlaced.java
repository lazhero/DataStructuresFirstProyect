package cr.ac.tec.Board.Other;


import javafx.scene.shape.Rectangle;

/**
This class extends from javafx's rectangle
We add the Placed field to emulate a board game's square
 * @author Andrey Zuñiga
 */
public class RectanglePlaced extends Rectangle {
    private boolean Placed;//Tells whatever the space its full or not

    /**
     * It's the Constructor
     * @author Andrey Zuñiga
     */
    public RectanglePlaced(){
        super();
        this.Placed=false;
    }

    /**
     * set the placed field to the boolean value
     * @author Andrey Zuñiga
     * @param placed
     */
    public void setPlaced(boolean placed) {
        Placed = placed;
    }

    /**
     * Return the boolean if the square board's its occupied or not
     * @author Andrey Zuñiga
     * @return a boolean value that shows if the
     */
    public boolean getPlaced(){
        return Placed;
    }
}
