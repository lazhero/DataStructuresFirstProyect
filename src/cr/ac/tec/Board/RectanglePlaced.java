package cr.ac.tec.Board;


import javafx.scene.shape.Rectangle;

public class RectanglePlaced extends Rectangle {
    private boolean Placed;
    public RectanglePlaced(){
        super();
        this.Placed=false;
    }

    public void setPlaced(boolean placed) {
        Placed = placed;
    }
    public boolean getPlaced(){
        return Placed;
    }
}
