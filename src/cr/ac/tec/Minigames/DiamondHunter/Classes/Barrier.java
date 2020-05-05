package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

    public Barrier(int tileType, int x, int y, int velocity, String imageName, int width, int height, int xSize, int ySize) {
        super(x, y, velocity, imageName);
        this.width = width;
        this.height = height;
        this.xSize = xSize;
        this.ySize = ySize;
        //System.out.println(String.format("%d: x(%d) y(%d) rectangle(%s)",tileType,x,y,obtainRectangle()));

    }



    public boolean isTouching() {
        return touching;
    }

    public void setTouching(boolean touching) {
        this.touching = touching;
    }

    /**
     * Creates a rectangle on each barrier.
     * @return
     */
    public CustomRectangle customRectangle(){
        return new CustomRectangle(x,y,50,50);
    }



    /**
     * Draws a rectangle over each barrier.
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        //graphicsContext.fillText(String.format("(%d,%d)",x,y),x,y);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.strokeRect(x,y,50,50);
    }

    /**
     * Moves each barrier as if it was stuck to the background.
     */
    @Override
    public void move() {

        //RIGHT
        if (DiamondHunterGame.right && x <= initialX) {
            if (!Background.touching)
                goRight=false;
            if (goRight){
                if (Background.getX() == -2040)
                    return;
                x -= velocity;
                //goRight = false;
                return;
            }
            if (Background.touching){
                goLeft = true;
                return;
            }
            if (Background.getX() == -2040)
                return;
            x -= velocity;
        }

        //LEFT
        if (DiamondHunterGame.left && x < initialX ) {
            if(!Background.touching){
                goLeft=false;
            }
            if (goLeft) {
                System.out.println("entra al 1");
                x += velocity;
                //goLeft = false;
                return;
            }
            if (Background.touching){
                System.out.println("entra al 2");
                goRight = true;
                return;

            }else {
                System.out.println("entra al else");
                x += velocity;
            }
        }

        //DOWN
        if (DiamondHunterGame.down && y <= initialY) {
            if (!Background.touching){
                goDown=false;
            }
            if (goDown){
                y -= velocity;
                return;
            }
            if (Background.touching){
                goUp = true;
                return;
            }
            if (Background.getY() == -1600)
                return;
            y -= velocity;
        }

        //UP
        if (DiamondHunterGame.up && y < initialY) {
            if (!Background.touching){
                goUp=false;
            }
            if (goUp){
                y += velocity;
                return;
            }
            if (Background.touching){
                goDown = true;
                return;
            }
            y += velocity;
        }

    }

}
