package cr.ac.tec.Board;

import cr.ac.tecLinkedList.List.DoubleList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public abstract class  Square {
    private Paint color;
    //private Events event; Hidden, waiting....
    private double coordx;
    private double coordy;
    private AnchorPane panel=null;
    private int players=0;
    private int LowerFirstPosition;
    private boolean p1=true;
    private boolean p2=true;
    private boolean p3=true;
    private boolean p4=true;
    protected Square(Paint color,double coordx,double coordy){
        this.color=color;
        this.coordx=coordx;
        this.coordy=coordy;
        panel=LayoutCreation.Anchor(40,40);
        this.LowerFirstPosition=1;
    }
    public abstract void Event();
    public void Draw(AnchorPane pane){
        if(pane!=null) {
               double width=panel.getWidth()/2;
               double height=panel.getHeight()/2;
               RectanglePlaced rect1=WidgetCreation.CreateRecP(0,0,width,height,color);
               RectanglePlaced rect2=WidgetCreation.CreateRecP(width,0,width,height,color);
               RectanglePlaced rect3=WidgetCreation.CreateRecP(0,height,width,height,color);
               RectanglePlaced rect4=WidgetCreation.CreateRecP(width,height,width,height,color);
               panel.getChildren().addAll(rect1,rect2,rect3,rect4);
               LayoutNewContent.Add(pane,panel,coordy,0,0,coordx);
        }
    }

    private void setPlayers(int players) {
        this.players = players;
    }
    private void raisePlayer(){

        players++;
    }
     private void decreaseplayers(){
        players--;
    }
    public int getPlayers() {
        return players;
    }
    public void DrawPlayer(Node node){
        if(players<=3) {
            players++;
            double posx=panel.getWidth()/4;
            double posy=panel.getHeight()/4;
            if(LowerFirstPosition==2)posx+=panel.getWidth()/2;
            if(LowerFirstPosition==3)posy+=panel.getHeight()/2;
            if(LowerFirstPosition==4){
                posx+=panel.getWidth()/2;
                posy+=panel.getHeight()/2;
            }
            LayoutNewContent.Add(panel,node,posy,0,0,posx);
            //lacks finding a new free position
        }

    }

}
