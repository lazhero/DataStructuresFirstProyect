package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame.TurnFinished;

/**
 *
 */
public class Item extends GameObject {
    final int initialX = x;
    final int initialY = y;
    private boolean captured=false;

    /**
     *This method verifies if the diamond is captured
     *@author
     * @return
     *
     */
    public boolean isCaptured() {
        return captured;
    }

    /**Verifies whether a diamond is caught and whether the amount of diamonds caught is increased
     * @author Miguel Mesén
     * @param captured
     */
    public void setCaptured(boolean captured) {
        this.captured = captured;
        DiamondHunterGame.totalDiamondsCollected++;

    }

    /**
     * Determines the characteristics of the diamond
     * @author Miguel Mesén
     * @param x
     * @param y
     * @param velocity
     * @param imageName
     * @param points
     */
    public Item(int x, int y, int velocity, String imageName, int points) {

        super(x, y, velocity, imageName);
        this.width = (int) DiamondHunterGame.images.get("diamond").getWidth();
        this.height = (int) DiamondHunterGame.images.get("diamond").getHeight();
        System.out.println("x"+ initialX+" y  "+initialY);

    }

    /**
     * Get the picture where the diamonds are
     * @author Miguel Mesén
     * @return
     */
    public Rectangle obtainRectangle(){
        return new Rectangle(x,y,width,height);
    }

    /**
     * Method used to draw diamonds on screen
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        if (this.isCaptured())
            return;
        graphicsContext.drawImage(DiamondHunterGame.images.get("diamond"), this.x, this.y);
        //graphicsContext.setStroke(Color.RED);
        //graphicsContext.strokeRect(x,y,width,height);
    }

    /**
     * Method used to move diamonds
     * @author Miguel Mesén
     */
    @Override
    public void move() {

        if(TurnFinished && DiamondHunterGame.GameOver){
            return;
        } else {
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
