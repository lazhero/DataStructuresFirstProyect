package cr.ac.tec.Board;

import cr.ac.tecLinkedList.List.DoubleList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public  class  Square {
    private Paint color;
    //private Events event; Hidden, waiting....
    private double coordx;
    private double coordy;
    private double sideSize;
    private AnchorPane panel;
    private int players=0;
    private DoubleList<RectanglePlaced> SubSquares;
    protected Square(Paint color,double coordx,double coordy,double sideSize){
        this.color=color;
        this.coordx=coordx;
        this.coordy=coordy;
        this.sideSize=sideSize;
        panel=LayoutCreation.Anchor(sideSize,sideSize);
        SubSquares=new DoubleList<>();


    }
   // public abstract void Event();
    public void Draw(AnchorPane Board){
        if(Board!=null) {
               double width=sideSize/2;
               double height=width;
               RectanglePlaced rect1=WidgetCreation.CreateRecP(0,0,width,height,color);
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

    private void setPlayers(int players) {
        this.players = players;
    }
    private void raisePlayer(){ players++; }
     private void decreaseplayers(){
        players--;
    }
    public int getPlayers() {
        return players;
    }
    public void DrawPlayer(Node node,int AssignedPosition,double nodeWidth,double nodeHeight,boolean pass){
        if(players<=3) {

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

        }
        if(true){
            if(players>1 && !pass){
                DoubleList<Integer> PlayerOnSquare=this.taken();

            }
        }
    }
    public void DeletePlayer(Node node){
        panel.getChildren().remove(node);
    }
    public void DeletePlayer(DoubleList<Node> Deleting){//lacks proves
        while(Deleting.getLength()>0){
            DeletePlayer(Deleting.get(0));
        }
    }
    public DoubleList<Integer> taken(){//Lacks proves
        DoubleList<Integer> List=new DoubleList<>();
        if(SubSquares.get(0).getPlaced())List.AddTail(0);
        if(SubSquares.get(1).getPlaced())List.AddTail(1);
        if(SubSquares.get(2).getPlaced())List.AddTail(2);
        if(SubSquares.get(3).getPlaced())List.AddTail(3);
        return List;
    }
    public void DuelTime(){//lacks details
        System.out.println("Es hora de de de de de del duelo");
        //waiting for duel event

    }



}
