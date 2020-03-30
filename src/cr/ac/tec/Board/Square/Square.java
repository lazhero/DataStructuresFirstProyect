package cr.ac.tec.Board.Square;
import cr.ac.tec.Board.*;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
public abstract class  Square {
    private Paint color;//Square color
    private double coordx;//coordx
    private double coordy;//coordy
    private double sideSize;//SideSize
    private AnchorPane panel;//pane created to place the square
    private int players=0;//Players in the square
    private DoubleList<RectanglePlaced> SubSquares;//Subsquares list

    /**
     * Class's constructor
     * @param color javafx's paint object
     * @param coordx cord x
     * @param coordy cord y
     * @param sideSize side's size
     */
    protected Square(Paint color,double coordx,double coordy,double sideSize){
        this.color=color;
        this.coordx=coordx;
        this.coordy=coordy;
        this.sideSize=sideSize;
        panel= LayoutCreation.Anchor(sideSize,sideSize);
        SubSquares=new DoubleList<>();
    }

    /**
     * Draws the square into a given AnchorPane
     * @param Board An AnchorPane
     */
    public void Draw(AnchorPane Board){
        if(Board!=null) {
               double width=sideSize/2;
               double height=width;
               RectanglePlaced rect1= WidgetCreation.CreateRecP(0,0,width,height,color);
               RectanglePlaced rect2=WidgetCreation.CreateRecP(width,0,width,height,color);
               RectanglePlaced rect3=WidgetCreation.CreateRecP(0,height,width,height,color);
               RectanglePlaced rect4=WidgetCreation.CreateRecP(width,height,width,height,color);
               panel.getChildren().addAll(rect1,rect2,rect3,rect4);
               LayoutNewContent.Add(Board,panel,coordy,0,0,coordx);
               SubSquares.AddTail(rect1);
               SubSquares.AddTail(rect2);
               SubSquares.AddTail(rect3);
               SubSquares.AddTail(rect4);
        }
    }

    /**
     * Set the number of player in a square
     * @param players the new number of players
     */
    private void setPlayers(int players) {
        this.players = players;
    }

    /**
     * Raise by one the number of players
     */
    private void raisePlayer(){ players++; }
     private void decreaseplayers(){
        players--;
    }

    /**
     * Returns the number of players
     * @return the number of players
     */
    public int getPlayers() {
        return players;
    }

    /**
     * Create a player in the square
     * @param node The javafx's node
     * @param AssignedPosition The position number
     * @param nodeWidth The node width
     * @param nodeHeight The node height
     */
    public void DrawPlayer(Node node,int AssignedPosition,double nodeWidth,double nodeHeight){
        players++;
        double posx=(sideSize/4)-(nodeWidth/2);
        double posy=(sideSize/4)-(nodeHeight/2);
        if(AssignedPosition==2)posx+=sideSize/2;
        if(AssignedPosition==3)posy+=sideSize/2;
        if(AssignedPosition==4){
            posx+=sideSize/2;
            posy+=sideSize/2;
        }
        LayoutNewContent.Add(panel,node,posy,0,0,posx);
        if(players<=1) {
            this.DuelTime();
        }

    }

    /**
     * Method to invoke the DuelTime
     */
    public void DuelTime(){

    }

    /**
     * Erase a node from the square
     * @param node a javafx's node
     */
    public void DeleteNode(Node node){
        panel.getChildren().remove(node);
    }

    /**
     * Deletes a player
     * @param player The player which node will be erased from the board
     */
    public void DeletePlayer(Player player) {//lacks proves
        DeleteNode(player.getNode());//unhandled exception
        players--;

    }

    /**
     * @hidden
     * @return A list with player's info
     */
    private DoubleList<Integer> taken(){//Lacks proves
        DoubleList<Integer> List=new DoubleList<>();
        if(SubSquares.get(0).getPlaced())List.AddTail(0);
        if(SubSquares.get(1).getPlaced())List.AddTail(1);
        if(SubSquares.get(2).getPlaced())List.AddTail(2);
        if(SubSquares.get(3).getPlaced())List.AddTail(3);
        return List;
    }

    /**
     * An abstract method, will be defined in the subclasses
     */
    public abstract void  Event();




}
