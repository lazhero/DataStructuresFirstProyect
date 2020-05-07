package cr.ac.tec.Minigames.DiamondHunter.Classes;

import cr.ac.tecLinkedList.List.DoubleList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.HashMap;


public class DiamondHunterGame extends Application {
    private GraphicsContext graphicsContext;
    private Group root;
    private Scene scene;
    private Canvas canvas;
    public static HashMap<String, Image> images;
    private Background background;
    private AnimatedPlayer animatedPlayer;
    private DoubleList<Barrier> barriers;
    private DoubleList<Item> items;

    public static boolean GameOver = false;
    public static int totalDiamondsCollected = 0;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;


    /**
     * Creates the interface in which the player interacts with.
     */
    public void createContent(){
        images = new HashMap<String, Image>();
        loadImages();
        animatedPlayer = new AnimatedPlayer(230,220,2,"link",0,"restFront");
        background = new Background(0,0,5,"map");
        initializeBarriers();
        adItems();
        //item = new Item(300,300,5,"diamond",1);
        root = new Group();
        scene = new Scene(root,500,500);
        canvas = new Canvas(500,500);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    /**
     * Creates a barrier in every tile where there is not a 0 on the tile map.
     */
    public void initializeBarriers(){
        barriers = new DoubleList<>();
        for(int i=0; i<TileMap.tilemap.length; i++){
            for(int j=0; j<TileMap.tilemap[i].length; j++){
                if (TileMap.tilemap[i][j]  != 0) {
                    this.barriers.AddHead(new Barrier(TileMap.tilemap[i][j], j * 50, i * 50, 5, "tilemap", 50, 50, 0, 0));
                }
            }
        }
    }


    /**
     * Has a bug that item doesnt spawn where its supposed to.
     */
    public void adItems() {
        items = new DoubleList<>();
        int itemsOnMap = 5;
        while (itemsOnMap > 0) {
            int randomNumber1 = (int) (Math.random() * ((42 - 1) + 1)) + 1;
            int randomNumber2 = (int) (Math.random() * ((42 - 1) + 1)) + 1;
            if (TileMap.tilemap[randomNumber1][randomNumber2] == 0){
                this.items.AddHead(new Item(randomNumber2*50,randomNumber1*50,5,"item",0));
                itemsOnMap--;
            }
        }
    }


    public void loadImages(){
        images.put("map", new Image("cr/ac/tec/Minigames/DiamondHunter/Images/map.png"));
        images.put("link", new Image("cr/ac/tec/Minigames/DiamondHunter/Images/linkSprites.png"));
        images.put("tilemap", new Image("cr/ac/tec/Minigames/DiamondHunter/Images/tilemap.png"));
        images.put("diamond", new Image("cr/ac/tec/Minigames/DiamondHunter/Images/diamond.png"));

    }


    public void draw(){
        background.draw(graphicsContext);
        for (int i=0; i < barriers.getLength(); i++) {
            barriers.get(i).draw(graphicsContext);
        }
        for (int i=0; i < items.getLength(); i++){
            items.get(i).draw(graphicsContext);
        }
        animatedPlayer.draw(graphicsContext);
        //item.draw(graphicsContext);
    }

    public void checkCollision(){
        background.playerCustomRectangle();
        for (int i=0; i < barriers.getLength(); i++){
            CustomRectangle barrierRectangle = barriers.get(i).customRectangle();
            if (background.getLeftSide().isOverlapping(barrierRectangle)){
                //System.out.println("left");
                Background.setTouchingLeftSide(true);
                return;
            }
            if (background.getRightSide().isOverlapping(barrierRectangle)){
                //System.out.println("right");
                Background.setTouchingRightSide(true);
                return;
            }
            if (background.getUpSide().isOverlapping(barrierRectangle)){
                //System.out.println("up");
                Background.setTouchingUpSide(true);
                return;
            }
            if (background.getDownSide().isOverlapping(barrierRectangle)){
                //System.out.println("down");
                Background.setTouchingDownSide(true);
                return;
            }
        }
        Background.setTouchingLeftSide(false);
        Background.setTouchingDownSide(false);
        Background.setTouchingRightSide(false);
        Background.setTouchingUpSide(false);
    }

    /**
     * Everything we need to be updating per frame second will go in here, like movements and collisions.
     * @param t
     */
    public void updateState(double t){
        isFinished();
        checkCollision();
        background.move();
        for (int i=0; i < items.getLength(); i++){
            animatedPlayer.verifyItemCollision(items.get(i));
        }
        for (int i=0; i < barriers.getLength(); i++) {
            barriers.get(i).move();
        }
        for (int i=0; i < items.getLength(); i++){
            items.get(i).move();
        }
        animatedPlayer.calculateFrame(t);
    }

    public void isFinished(){
        if (totalDiamondsCollected==5){
            GameOver = true;
        }
    }

    /**
     * Sets an animation timer to see the games current frames per second and constantly updates the game with its images.
     */
    public void gameCycle(){
        long initialTime = System.nanoTime();
        AnimationTimer animationTimer = new AnimationTimer() {

            //Este metodo se ejecuta aproximadamente unas 60 veces por segundo 60FPS.
            @Override
            public void handle(long currentTime) {
                double t = (currentTime - initialTime) / 1000000000.0;
                //System.out.println(t);
                updateState(t);
                draw();
            }
        };
        animationTimer.start();//Empieza el ciclo de juego.
    }




    public void eventHandler(){
        boolean[] isPressable = {true};
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            //El metodo handle se ejecuta cada vez que presiono una tecla.
            @Override
            public void handle(KeyEvent event) {
                if (isPressable[0]) {
                    if (event.getCode().toString() == "A") {
                        isPressable[0] = false;
                        left = true;
                        animatedPlayer.setCurrentAnimation("runLeft");
                        return;
                    }
                    if (event.getCode().toString() == "W") {
                        isPressable[0] = false;
                        up = true;
                        animatedPlayer.setCurrentAnimation("runBack");
                        return;
                    }
                    if (event.getCode().toString() == "S") {
                        isPressable[0] = false;
                        down = true;
                        animatedPlayer.setCurrentAnimation("runFront");
                        return;
                    }
                    if (event.getCode().toString() == "D") {
                        isPressable[0] = false;
                        right = true;
                        animatedPlayer.setCurrentAnimation("runRight");
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            //Este metodo se ejecuta cuando se suelta una tecla.
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString() == "A" && left){
                    isPressable[0] = true;
                    left = false;
                    animatedPlayer.setCurrentAnimation("restLeft");
                    return;
                }
                if (event.getCode().toString() == "W" && up){
                    isPressable[0] = true;
                    up = false;
                    animatedPlayer.setCurrentAnimation("restBack");
                    return;
                }
                if (event.getCode().toString() == "S" && down){
                    isPressable[0] = true;
                    down = false;
                    animatedPlayer.setCurrentAnimation("restFront");
                    return;
                }
                if (event.getCode().toString() == "D" && right){
                    isPressable[0] = true;
                    right = false;
                    animatedPlayer.setCurrentAnimation("restRight");
                }
            }
        });
    }



    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        createContent();
        eventHandler();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Diamond Hunter");
        primaryStage.show();
        gameCycle();
    }
}
