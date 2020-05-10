package cr.ac.tec.Board.Count;

import cr.ac.tec.Board.LayoutCreation;
import cr.ac.tec.Board.LayoutNewContent;
import cr.ac.tec.Images.GetImages;
import cr.ac.tecLinkedList.List.DoubleList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Counter {
    private AnchorPane anchorPane;

    private double width;
    private double height;
    private String route;
    private String format;

   public Counter(double width,double height, String route,String format){
       this.width=width;
       this.height=height;
       this.route=route;
       this.format=format;
       this.anchorPane= LayoutCreation.Anchor(width,height);

    }
    public void setCount(int num){
       if(num>0){
           anchorPane.getChildren().clear();
           DoubleList<ImageView> img=null;
           try{
               img=getNumber(num);
           }
           catch (Exception e){
               System.out.println(e.getMessage());
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

       }
    }
    private DoubleList<ImageView> getNumber(int num) throws Exception{
       DoubleList<ImageView> List=new DoubleList<>();
       while(num>0){
           List.AddHead(GetImages.getImageView(route+Integer.toString(num%10)+format));
           num=num/10;
       }
       return List;
    }
    private double getPos(int pos,double large,double space){

        return pos*large+pos-space;


    }
    public AnchorPane getAnchorPane(){
       return anchorPane;
    }


}
