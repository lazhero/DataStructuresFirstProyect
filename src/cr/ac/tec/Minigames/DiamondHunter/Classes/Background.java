package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;



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

    public Background(int x, int y, int velocity, String imageName) {
        super(x, y, velocity, imageName);
        this.x = x;
    }

    public static int getY() { return y; }

    public static int getX() {
        return x;
    }

    public static boolean isTouchingLeftSide() {
        return touchingLeftSide;
    }

    public static void setTouchingLeftSide(boolean touchingLeftSide) {
        Background.touchingLeftSide = touchingLeftSide;
    }

    public static boolean isTouchingRightSide() {
        return touchingRightSide;
    }

    public static void setTouchingRightSide(boolean touchingRightSide) {
        Background.touchingRightSide = touchingRightSide;
    }

    public static boolean isTouchingUpSide() {
        return touchingUpSide;
    }

    public static void setTouchingUpSide(boolean touchingUpSide) {
        Background.touchingUpSide = touchingUpSide;
    }

    public static boolean isTouchingDownSide() {
        return touchingDownSide;
    }

    public static void setTouchingDownSide(boolean touchingDownSide) {
        Background.touchingDownSide = touchingDownSide;
    }

    public CustomRectangle getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(CustomRectangle leftSide) {
        this.leftSide = leftSide;
    }

    public CustomRectangle getRightSide() {
        return rightSide;
    }

    public void setRightSide(CustomRectangle rightSide) {
        this.rightSide = rightSide;
    }

    public CustomRectangle getUpSide() {
        return upSide;
    }

    public void setUpSide(CustomRectangle upSide) {
        this.upSide = upSide;
    }

    public CustomRectangle getDownSide() {
        return downSide;
    }

    public void setDownSide(CustomRectangle downSide) {
        this.downSide = downSide;
    }


    /**
     * Creates a rectangle on the coordinates where the player is standing.
     * @return
     */
    public void playerCustomRectangle(){
        upSide = new CustomRectangle(232,220,36,2);
        leftSide = new CustomRectangle(230,222,2,36);
        rightSide = new CustomRectangle(268,222,2,36);
        downSide = new CustomRectangle(232,258,36,2);
    }

    public Rectangle playerRectangle(){
        return new Rectangle(230, 220, 50, 50);
    }

    /**
     * Draws the background image.
     * Draws a rectangle over the player.
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
     */
    @Override
    public void move() {

        if (!DiamondHunterGame.TurnFinished) {

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
