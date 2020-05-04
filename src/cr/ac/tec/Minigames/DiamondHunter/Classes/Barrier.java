package cr.ac.tec.Minigames.DiamondHunter.Classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Barrier extends GameObject {

    private int tileType;

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



        switch (tileType){
            case 1:
                this.xImage = 0;
                this.yImage = 0;
                break;
            case 2:
                this.xImage = 0;
                this.yImage = 132;
                break;
            case 3:
                this.xImage = 0;
                this.yImage = 264;
                break;
            case 4:
                this.xImage = 0;
                this.yImage = 396;
                break;
        }
    }


    public int getxImage() {
        return xImage;
    }

    public void setxImage(int xImage) {
        this.xImage = xImage;
    }

    public int getyImage() {
        return yImage;
    }

    public void setyImage(int yImage) {
        this.yImage = yImage;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        //graphicsContext.drawImage(DiamondHunterGame.images.get(imageName),xImage, yImage, width, height,x,y,xSize,ySize);//(Posicion esquina superior derecha del tile, tamano del tile, donde quiere posicionarlo, tamano que tiene cada tile, nuevo tamano que desea darle)
        graphicsContext.setStroke(Color.RED);
        graphicsContext.strokeRect(x,y,47,47);
    }

    @Override
    public void move() {
        if (DiamondHunterGame.right && x <= initialX){
            if (Background.getX() == -2040)
                return;
            x -= velocity;
        }

        if (DiamondHunterGame.left && x < initialX) {
            x += velocity;
        }

        if (DiamondHunterGame.down && y <= initialY){
            if(Background.getY() == -1600)
                return;
            y -= velocity;

        }

        if (DiamondHunterGame.up && y < initialY) {
            y += velocity;

        }
    }

}
