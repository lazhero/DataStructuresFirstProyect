package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.shape.Rectangle;

public class CustomRectangle extends Rectangle {
    int topRightY;
    int bottomLeftY;
    int bottomLeftX;
    int topRightX;


    public CustomRectangle(int x, int y, int width, int height){
        super(x,y,width,height);
        this.bottomLeftY = y + height;
        this.bottomLeftX = x;
        this.topRightY = y;
        this.topRightX = x + width;
    }

    public boolean isOverlapping2(CustomRectangle other) {
        boolean primero = this.getX() <= other.getX() + other.getWidth();
        boolean segundo = this.getX() + getWidth() >= other.getX();
        boolean tercero = this.getY() <= other.getY() + other.getHeight();
        boolean cuarto = this.getY() + getHeight() >= other.getY();
        System.out.println("_________________________");
        System.out.println(primero);
        System.out.println(segundo);
        System.out.println(tercero);
        System.out.println(cuarto);
        System.out.println("_________________________");



        return primero && segundo && tercero && cuarto;

    }


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
