package cr.ac.tec.Board.Square;
import cr.ac.tec.Board.*;
import cr.ac.tec.Images.GetImages;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;

public abstract class  Square {
    private Paint color;//Square color
    private double coordx;//coordx
    private double coordy;//coordy
    private double sideSize;//SideSize
    private AnchorPane panel;//pane created to place the square
    private Node Background;
    private int players;//Players in the square
    private DoubleList<Player> NodesinPanel;

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
        this.players=0;
        panel= LayoutCreation.Anchor(sideSize,sideSize);
        NodesinPanel=new DoubleList<>();
    }

    /**
     * Draws the square into a given AnchorPane
     * @param Board An AnchorPane
     */
    public void Draw(AnchorPane Board){
        if(Board!=null) {
               double width=sideSize/2;
               double height=width;
               //RectanglePlaced rect1= WidgetCreation.CreateRecP(0,0,width,height,color);
               //RectanglePlaced rect2=WidgetCreation.CreateRecP(width,0,width,height,color);
               //RectanglePlaced rect3=WidgetCreation.CreateRecP(0,height,width,height,color);
               //RectanglePlaced rect4=WidgetCreation.CreateRecP(width,height,width,height,color);
               //panel.getChildren().addAll(rect1,rect2,rect3,rect4);
               //LayoutNewContent.Add(Board,panel,coordy,0,0,coordx);
               //SubSquares.AddTail(rect1);
               //SubSquares.AddTail(rect2);
               //SubSquares.AddTail(rect3);
               //SubSquares.AddTail(rect4);
                RectanglePlaced rectangle=WidgetCreation.CreateRecP(0,0,sideSize,sideSize,color);
                panel.getChildren().add(rectangle);
                LayoutNewContent.Add(Board,panel,coordy,0,0,coordx);
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


    public void DrawStar(double Side,String path) throws IOException {
        Label label=new Label("",GetImages.getImageView(path));
        label.setPrefHeight(Side);
        label.setPrefWidth(Side);
        label.setMaxWidth(Side);
        label.setMaxHeight(Side);
        label.setMinHeight(Side);
        label.setMinWidth(Side);
        this.Background=label;
        this.DrawingOneNode(label,label.getPrefWidth(),label.getPrefHeight());



    }
    public void HideStar(){
        if(Background!=null){
            Background.setVisible(false);
        }

    }
    public void ShowStar(){
        if(Background!=null){
            Background.setVisible(true);
        }

    }
    public void DrawPlayer(Player player,double nodeWidth,double nodeHeight){
        players++;
        if(players==1){
            DrawingOnePlayer(player,nodeWidth,nodeHeight);
            NodesinPanel.AddTail(player);
        }
        else{
            DeleteNode(NodesinPanel.get(0).getNode());
            DrawingTwoPlayer(NodesinPanel.get(0),player,nodeWidth,nodeHeight);
            //Aqui habria que incluir los eventos de duelo
        }

    }
    private void DrawingOnePlayer(Player player,double nodeWidth,double nodeHeight){
        Node node=player.getNode();
        double posx=(sideSize/2)-(nodeWidth/2);
        double posy=(sideSize/2)-(nodeHeight/2);
        LayoutNewContent.Add(panel,node,posy,0,0,posx);


    }
    private void DrawingTwoPlayer(Player player1,Player player2,double nodeWidth,double nodeHeight){
        Node node1=player1.getNode();
        Node node2= player1.getNode();
        double posx=(sideSize/4)-(nodeWidth/2);
        double posy=(sideSize/4)-(nodeHeight/2);
        LayoutNewContent.Add(panel,node1,posy,0,0,posx);
        posx+=sideSize/2;
        posy+=sideSize/2;
        LayoutNewContent.Add(panel,node2,posy,0,0,posx);


    }

    private void DrawingOneNode(Node node,double nodeWidth,double nodeHeight){
        double posx=(sideSize/2)-(nodeWidth/2);
        double posy=(sideSize/2)-(nodeHeight/2);
        LayoutNewContent.Add(panel,node,posy,0,0,posx);


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
    public void DeleteAllNode(){
        //panel.getChildren().
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
    public double getCoordx() {
        return coordx;
    }

    public double getCoordy() {
        return coordy;
    }
    public void setBackground(Node node){
        this.Background=node;
    }

    public Node getBackground() {
        return Background;
    }

    /**
     * An abstract method, will be defined in the subclasses
     */
    public abstract void  Event();
    public abstract String Color();




}
