package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 */
public class Barrier extends GameObject {

    private int tileType;
    public static boolean goLeft = false;
    public static boolean goRight = false;
    public static boolean goUp = false;
    public static boolean goDown = false;
    private boolean touching;
    final int initialX = x;
    final int initialY = y;
    private int xImage;//Extraer fragmento
    private int yImage;//de la imagen original.
    private int xSize;//Nuevo tamano que
    private int ySize;//desea darle al tile.

    /**
     * Method for defining the characteristics of the barrier
     * @author Miguel Mesen
     * @param tileType
     * @param x
     * @param y
     * @param velocity
     * @param imageName
     * @param width
     * @param height
     * @param xSize
     * @param ySize
     */
    public Barrier(int tileType, int x, int y, int velocity, String imageName, int width, int height, int xSize, int ySize) {
        super(x, y, velocity, imageName);
        this.width = width;
        this.height = height;
        this.xSize = xSize;
        this.ySize = ySize;

    }

    /**
     *
     * @return
     */
    public boolean isTouching() {
        return touching;
    }

    /**
     *
     * @param touching
     */
    public void setTouching(boolean touching) {
        this.touching = touching;
    }

    /**
     *
     * Creates a rectangle on each barrier.
     * @author Miguel Mesen
     * @return
     */
    public CustomRectangle customRectangle(){

        return new CustomRectangle(x,y,50,50);
    }

    /**
     *
     * @return
     */
    public int getInitialX() {
        return initialX;
    }

    /**
     *
     * @return
     */
    public int getInitialY() {
        return initialY;
    }

    /**
     *
     * @return
     */
    public int getTileType() {
        return tileType;
    }

    /**
     * Draws a rectangle over each barrier.
     * @author Miguel Mesen
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        //graphicsContext.fillText(String.format("(%d,%d)",x,y),x,y);
        //graphicsContext.setStroke(Color.BLACK);
        //graphicsContext.strokeRect(x,y,50,50);
    }

    /**
     * @author Miguel Mesen
     * Moves each barrier as if it was stuck to the background.
     */
    @Override
    public void move() {
        if (!DiamondHunterGame.TurnFinished && !DiamondHunterGame.GameOver) {
            //RIGHT
            if (DiamondHunterGame.right && x <= initialX) {
                if (Background.touchingRightSide)
                    return;
                if (Background.getX() == -2040)
                    return;
                x -= velocity;
            }
            //LEFT
            if (DiamondHunterGame.left && x < initialX) {
                if (Background.touchingLeftSide)
                    return;
                x += velocity;
            }
            //DOWN
            if (DiamondHunterGame.down && y <= initialY) {
                if (Background.touchingDownSide)
                    return;
                if (Background.getY() == -1600)
                    return;
                y -= velocity;
            }
            //UP
            if (DiamondHunterGame.up && y < initialY) {
                if (Background.touchingUpSide)
                    return;
                y += velocity;
            }
        }
    }
}
