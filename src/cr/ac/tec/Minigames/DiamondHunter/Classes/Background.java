package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

/**
 *
 */

public class Background extends GameObject{


    public static boolean touchingLeftSide = false;
    public static boolean touchingRightSide = false;
    public static boolean touchingUpSide = false;
    public static boolean touchingDownSide = false;

    private CustomRectangle leftSide;
    private CustomRectangle rightSide;
    private CustomRectangle upSide;
    private CustomRectangle downSide;

    public static int x;
    public static int y;

    /**
     * Method for determining the characteristics of the fund
     * @author Miguel Mesen
     * @param x
     * @param y
     * @param velocity
     * @param imageName
     */
    public Background(int x, int y, int velocity, String imageName) {
        super(x, y, velocity, imageName);
        this.x = x;
    }

    /**
     * Method for obtaining position Y
     * @author Miguel Mesen
     * @return
     */
    public static int getY() { return y; }

    /**
     *Method for obtaining position X
     * @author Miguel Mesen
     * @return
     */
    public static int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public static boolean isTouchingLeftSide() {
        return touchingLeftSide;
    }

    /**
     *
     * Method to determine which touches the left side of the background
     * @author Miguel Mesén
     * @param touchingLeftSide
     */
    public static void setTouchingLeftSide(boolean touchingLeftSide) {
        Background.touchingLeftSide = touchingLeftSide;
    }

    /**
     *
     * @return
     */
    public static boolean isTouchingRightSide() {
        return touchingRightSide;
    }

    /**
     * Method to determine which touches the Right side of the background
     * @author Miguel Mesen
     * @param touchingRightSide
     */
    public static void setTouchingRightSide(boolean touchingRightSide) {
        Background.touchingRightSide = touchingRightSide;
    }

    /**
     *
     * @return
     */
    public static boolean isTouchingUpSide() {
        return touchingUpSide;
    }

    /**
     * Method to determine which touches the Up side of the background
     * @author Miguel Mesen
     * @param touchingUpSide
     */
    public static void setTouchingUpSide(boolean touchingUpSide) {
        Background.touchingUpSide = touchingUpSide;
    }

    /**
     *
     * @return
     */
    public static boolean isTouchingDownSide() {
        return touchingDownSide;
    }

    /**
     * Method to determine which touches the Down side of the background
     * @author Miguel Mesen
     * @param touchingDownSide
     */
    public static void setTouchingDownSide(boolean touchingDownSide) {
        Background.touchingDownSide = touchingDownSide;
    }

    /**
     * Method for obtaining the left side of the background
     * @author Miguel Mesen
     * @return
     */
    public CustomRectangle getLeftSide() {
        return leftSide;
    }

    /**
     *
     * @param leftSide
     */
    public void setLeftSide(CustomRectangle leftSide) {
        this.leftSide = leftSide;
    }

    /**
     * Method for obtaining the right side of the background
     * @author Miguel Mesen
     * @return
     */
    public CustomRectangle getRightSide() {
        return rightSide;
    }

    /**
     *
     * @param rightSide
     */
    public void setRightSide(CustomRectangle rightSide) {
        this.rightSide = rightSide;
    }

    /**
     * Method for obtaining the Up side of the background
     * @author Miguel Mesen
     * @return
     */
    public CustomRectangle getUpSide() {
        return upSide;
    }

    /**
     *
     * @param upSide
     */
    public void setUpSide(CustomRectangle upSide) {
        this.upSide = upSide;
    }

    /**
     * Method for obtaining the down side of the background
     * @return
     */
    public CustomRectangle getDownSide() {
        return downSide;
    }

    /**
     *
     * @param downSide
     */
    public void setDownSide(CustomRectangle downSide) {
        this.downSide = downSide;
    }

    /**
     * Creates a rectangle on the coordinates where the player is standing.
     * @author Miguel Mesen
     * @return
     */
    public void playerCustomRectangle(){
        upSide = new CustomRectangle(232,220,36,2);
        leftSide = new CustomRectangle(230,222,2,36);
        rightSide = new CustomRectangle(268,222,2,36);
        downSide = new CustomRectangle(232,258,36,2);
    }

    /**
     *
     * @return
     */
    public Rectangle playerRectangle(){
        return new Rectangle(230, 220, 50, 50);
    }

    /**
     * Draws the background image.
     * Draws a rectangle over the player.
     * @author Miguel Mesen
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(DiamondHunterGame.images.get(this.imageName),this.x,this.y);
        /*
        graphicsContext.strokeRect(232,220,36,2);//Arriba
        graphicsContext.strokeRect(230,222,2,36);//Izquierdo
        graphicsContext.strokeRect(268,222,2,36);//Derecha
        graphicsContext.strokeRect(232,258,36,2);//Abajo
         */
    }

    /**
     * Moves the background
     * @author Miguel Mesen
     */
    @Override
    public void move() {
        if (!DiamondHunterGame.TurnFinished && !DiamondHunterGame.GameOver) {
            if (DiamondHunterGame.right && x > -2040) {
                if (touchingRightSide)
                    return;
                x -= velocity;
            }
            if (DiamondHunterGame.left && x < 0) {
                if (touchingLeftSide)
                    return;
                x += velocity;
            }
            if (DiamondHunterGame.down && y > -1600) {
                if (touchingDownSide)
                    return;
                y -= velocity;
            }
            if (DiamondHunterGame.up && y < 0) {
                if (touchingUpSide)
                    return;
                y += velocity;
            }
        }
    }

}
