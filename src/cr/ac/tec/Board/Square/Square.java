package cr.ac.tec.Board.Square;
//import com.sun.media.jfxmediaimpl.platform.Platform;
import cr.ac.tec.Board.*;
import cr.ac.tec.Images.GetImages;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
    private DoubleList<Player> PlayersinPanel;

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
        PlayersinPanel=new DoubleList<>();
    }

    /**
     * Draws the square into a given AnchorPane
     * @param Board An AnchorPane
     */
    public void Draw(AnchorPane Board){
        if(Board!=null) {
               double width=sideSize/2;
               double height=width;
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

    /**
     *
     */
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
     *
     * @return
     */
    public DoubleList<Player> ListPlayer(){
        return PlayersinPanel;
    }

    /**
     *
     * @return
     */
    public DoubleList<Player> getPlayersinPanel() {
        return PlayersinPanel;
    }

    /**
     *
     * @param Side
     * @param path
     * @throws IOException
     */
    public void DrawStar(double Side, String path) throws IOException {
        if(path!=null && Side>0) {
            Label label = new Label("", GetImages.getImageView(path));
            label.setPrefHeight(Side);
            label.setPrefWidth(Side);
            label.setMaxWidth(Side);
            label.setMaxHeight(Side);
            label.setMinHeight(Side);
            label.setMinWidth(Side);
            this.Background = label;
            label.setOpacity(0.7);
            this.DrawingOneNode(label, label.getPrefWidth(), label.getPrefHeight());
        }
        else{
            if(this.Background!=null){
                DeleteNode(this.Background);
            }
            Background=null;
        }
    }

    /**
     *
     */
    public void HideStar(){
        if(Background!=null){
            Background.setVisible(false);
        }
    }

    /**
     *
     */
    public void ShowStar(){
        if(Background!=null){
            Background.setVisible(true);
        }
    }
    /**
     *
     * @param player
     * @param nodeWidth
     * @param nodeHeight
     * @param StoppingFlag
     */
    public void DrawPlayer(Player player,double nodeWidth,double nodeHeight,boolean StoppingFlag){
        players++;
        if(players==1){
            DrawingOnePlayer(player,nodeWidth,nodeHeight);
            PlayersinPanel.AddTail(player);
            if(StoppingFlag){
               // Event();
            }
        }
        else if(players>1 && players<=2){
            for(int i= 0;i<PlayersinPanel.getLength();i++){
                DeleteNode(PlayersinPanel.get(i).getNode());
            }
            PlayersinPanel.AddTail(player);
            DrawingTwoPlayer(PlayersinPanel.get(0),PlayersinPanel.get(1),nodeWidth,nodeHeight);
        }
    }

    /**
     *
     * @param player
     * @param nodeWidth
     * @param nodeHeight
     */
    private void DrawingOnePlayer(Player player,double nodeWidth,double nodeHeight){
        Node node=player.getNode();
        double posx=(sideSize/2)-(nodeWidth/2);
        double posy=(sideSize/2)-(nodeHeight/2);
        LayoutNewContent.Add(panel,node,posy,0,0,posx);
    }

    /**
     *
     * @param player1
     * @param player2
     * @param nodeWidth
     * @param nodeHeight
     */
    private void DrawingTwoPlayer(Player player1,Player player2,double nodeWidth,double nodeHeight){
        Node node1=player1.getNode();
        Node node2= player2.getNode();
        double posx=(sideSize/4)-(nodeWidth/2);
        double posy=(sideSize/4)-(nodeHeight/2);
        LayoutNewContent.Add(panel,node1,posy,0,0,posx);
        posx+=sideSize/2;
        posy+=sideSize/2;
        LayoutNewContent.Add(panel,node2,posy,0,0,posx);
    }

    /**
     *
     * @param List
     * @param nodeWidth
     * @param nodeHeight
     */
    private void DrawingMoreThanOnePlayer(DoubleList<Player> List,double nodeWidth,double nodeHeight){
        double posx=(sideSize/4)-(nodeWidth/2);
        double posy=(sideSize/4)-(nodeHeight/2);
    }

    /**
     *
     * @param node
     * @param nodeWidth
     * @param nodeHeight
     */
    private void DrawingOneNode(Node node,double nodeWidth,double nodeHeight){
        double posx=(sideSize/2)-(nodeWidth/2);
        double posy=(sideSize/2)-(nodeHeight/2);
        LayoutNewContent.Add(panel,node,posy,0,0,posx);
    }

    /**
     *
     * @param player
     * @param nodeWidth
     * @param nodeHeight
     */
    public void DeletingPlayer(Player player,double nodeWidth,double nodeHeight){
        if(players==1){
            players--;
            DeleteNode(player.getNode());
            PlayersinPanel.delete(0);
        }
        else if(players>1 && players<=2){
            players-=2;
            for(int i=0;i<PlayersinPanel.getLength();i++){
                DeleteNode(PlayersinPanel.get(i).getNode());
            }
            int pos=PlayersinPanel.FindFirstInstancePosition(player);
            PlayersinPanel.delete(pos);
            Player temp= PlayersinPanel.get(0);
            PlayersinPanel.delete(0);
            DrawPlayer(temp,nodeWidth,nodeHeight,false);
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
     *
     */
    public void DeleteAllNode(){
        //panel.getChildren().
    }

    /**
     * @hidden
     * @return A list with player's info
     */
    public double getCoordx() {
        return coordx;
    }

    /**
     *
     * @return
     */
    public double getCoordy() {
        return coordy;
    }

    /**
     *
     * @param node
     */
    public void setBackground(Node node){
        this.Background=node;
    }

    /**
     *
     * @return
     */
    public Node getBackground() {
        return Background;
    }

    /**
     * An abstract method, will be defined in the subclasses
     */
    public abstract void event(Player player);

    /**
     *
     * @return
     */
    public abstract String Color();
}
