package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Background extends GameObject{

    public static boolean touching = false;

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


    public boolean isTouching() {
        return touching;
    }

    public void setTouching(boolean touching) {
        this.touching = touching;
    }

    /**
     * Creates a rectangle on the coordinates where the player is standing.
     * @return
     */
    public CustomRectangle playerCustomRectangle(){
        return new CustomRectangle(230, 220, 50, 50);
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
        //graphicsContext.setStroke(Color.BLACK);
        //graphicsContext.strokeRect(230,220,50,50);

    }

    /**
     * Moves the background
     */
    @Override
    public void move() {

        if (DiamondHunterGame.right && x > -2040){
            if (touching){
                if (Barrier.goRight) {
                    x -= velocity;
                    return;
                }
                return;
            }
            x -= velocity;
        }

        if (DiamondHunterGame.left && x < 0) {
            if (touching){
                if (Barrier.goLeft) {
                    x += velocity;
                    return;
                }
                return;
            }
            x += velocity;
        }

        if (DiamondHunterGame.down && y > -1600){
            if (touching){
                if (Barrier.goDown){
                    y -= velocity;
                    return;
                }
                return;
            }
            y -= velocity;
        }

        if (DiamondHunterGame.up && y < 0) {
            if (touching){
                if (Barrier.goUp){
                    y += velocity;
                    return;
                }
                return;
            }
            y += velocity;
        }
    }
}
