package cr.ac.tec.Board.Count;

import cr.ac.tec.Board.Other.LayoutCreation;
import cr.ac.tec.Board.Other.LayoutNewContent;
import cr.ac.tec.Images.GetImages;
import cr.ac.tec.LinkedList.List.DoubleList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * This class is to create a coin counter and display it on screen
 * @author Andrey Zuñiga and Miguel Mesen
 */
public class Counter {
    private AnchorPane anchorPane;
    private DoubleList<ImageView> imageViewDoubleList=new DoubleList<>();
    private double width;
    private double height;
    private String route;
    private String format;
    /**
     * Defines the characteristics of the counter
     * @param width
     * @param height
     * @param route
     * @param format
     */
   public Counter(double width,double height, String route,String format){
       this.width=width;
       this.height=height;
       this.route=route;
       this.format=format;
       this.anchorPane= LayoutCreation.Anchor(width,height);

    }

    /**
     * Change the coin value depending on the player
     * @param num number to update
     */
    public void setCount(int num){
        ObservableList<Node> Items=anchorPane.getChildren();
        while(!Items.isEmpty()){
            Items.get(0).setVisible(false);
            Items.remove(Items.get(0));
        }
        anchorPane.getChildren().clear();
        DoubleList<ImageView> img=null;
       if(num>0){
           try{
               img=getNumber(num);
           }
           catch (Exception e){
           }
           while(img.getLength()<3){
               try {
                   img.AddHead(GetImages.getImageView(route+"0"+format));
               }
               catch (Exception e){}

           }
           double large=(width/img.getLength())*0.80;
           double space=(width/img.getLength())*0.20;
           for(int i=0;i<img.getLength();i++){
               double posX=getPos(i,large,space);
               ImageView imageView=img.get(i);
               imageView.setFitHeight(height);
               imageView.setFitWidth(large);
               LayoutNewContent.Add(anchorPane,imageView,0,0,0,posX);
           }
       }
       else if(num==0){
           try{
               img=new DoubleList<>();
               while(img.getLength()<3){
                   img.AddTail(GetImages.getImageView(route+"0"+format));
               }
           }
           catch (Exception e){}
           double large=(width/img.getLength())*0.80;
           double space=(width/img.getLength())*0.20;
           for(int i=0;i<img.getLength();i++){
               double posX=getPos(i,large,space);
               ImageView imageView=img.get(i);
               imageView.setFitHeight(height);
               imageView.setFitWidth(large);
               LayoutNewContent.Add(anchorPane,imageView,0,0,0,posX);
           }
       }
    }
    /**
     * Get the image of the number to be displayed on screen
     * @param num number to show
     * @return
     * @throws Exception
     */
    private DoubleList<ImageView> getNumber(int num) throws Exception{
       DoubleList<ImageView> List=new DoubleList<>();
       while(num>0){
           List.AddHead(GetImages.getImageView(route+Integer.toString(num%10)+format));
           num=num/10;
       }
       return List;
    }
    /**
     * Gets the position according to the player
     * @param pos positions that will be moved the player
     * @param large
     * @param space
     * @return
     */
    private double getPos(int pos,double large,double space){
        return pos*large+pos*space;
    }
    /**
     * Gets the anchor Pane
     * @return
     */
    public AnchorPane getAnchorPane(){
       return anchorPane;
    }
}
