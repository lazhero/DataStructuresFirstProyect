package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.shape.Rectangle;

public class CustomRectangle extends Rectangle {
    int topRightY;
    int bottomLeftY;
    int bottomLeftX;
    int topRightX;

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public CustomRectangle(int x, int y, int width, int height){
        super(x,y,width,height);
        this.bottomLeftY = y + height;
        this.bottomLeftX = x;
        this.topRightY = y;
        this.topRightX = x + width;
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean isOverlapping2(CustomRectangle other) {
        boolean primero = this.getX() <= other.getX() + other.getWidth();
        boolean segundo = this.getX() + getWidth() >= other.getX();
        boolean tercero = this.getY() <= other.getY() + other.getHeight();
        boolean cuarto = this.getY() + getHeight() >= other.getY();
        return primero && segundo && tercero && cuarto;
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean isOverlapping(CustomRectangle other) {
        return this.getX() <= other.getX() + other.getWidth() && getX() + getWidth() >= other.getX() && getY() <= other.getY() + other.getHeight() && getY() + getHeight() >= other.getY();

    }
        /*
        if (this.topRightY < other.bottomLeftY
                || this.bottomLeftY > other.topRightY) {
            return false;
        }
        if (this.topRightX < other.bottomLeftX
                || this.bottomLeftX> other.topRightX) {
            return false;
        }
        return true;
    }

         */

}
