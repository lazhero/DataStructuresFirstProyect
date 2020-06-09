package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame.TurnFinished;

public class Item extends GameObject {
    final int initialX = x;
    final int initialY = y;
    private boolean captured=false;

    /**
     *
     * @return
     */
    public boolean isCaptured() {
        return captured;
    }

    /**
     *
     * @param captured
     */
    public void setCaptured(boolean captured) {
        this.captured = captured;
        DiamondHunterGame.totalDiamondsCollected++;
        System.out.println(DiamondHunterGame.totalDiamondsCollected);
    }

    /**
     *
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

    }

    /**
     *
     * @return
     */
    public Rectangle obtainRectangle(){
        return new Rectangle(x,y,width,height);
    }

    /**
     *
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        if (this.isCaptured())
            return;
        graphicsContext.drawImage(DiamondHunterGame.images.get("diamond"), this.x, this.y);
        graphicsContext.setStroke(Color.RED);
        //graphicsContext.strokeRect(x,y,width,height);
    }

    /**
     *
     */
    @Override
    public void move() {
        if(TurnFinished){
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
