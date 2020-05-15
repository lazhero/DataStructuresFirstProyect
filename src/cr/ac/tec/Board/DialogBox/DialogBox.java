package cr.ac.tec.Board.DialogBox;

import cr.ac.tec.Board.LayoutCreation;
import cr.ac.tec.Board.LayoutNewContent;
import cr.ac.tec.Board.WidgetCreation;
import cr.ac.tec.Images.GetImages;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DialogBox extends AnchorPane {
    private Button YesButton;
    private Button NoButton;
    private double height;
    private double width;
    private String text;
    private ImageView Background;
    private AnchorPane anchorPane;
    protected DialogBox(Builder builder){
        this.NoButton=builder.NoButton;
        this.YesButton=builder.YesButton;
        this.Background=builder.Background;
        this.height=builder.height;
        this.width=builder.width;
        this.text=builder.text;
        this.anchorPane=null;
    }
    public void Draw(AnchorPane pane,double xAxis,double yAxis){
        if(pane!=null && anchorPane!=null){
            LayoutNewContent.Add(pane,anchorPane,xAxis,0,0,yAxis);
        }

    }
    public void setAnchorPane(){
        anchorPane= LayoutCreation.Anchor(width,height);
        Background.setPreserveRatio(true);
        Background.setFitWidth(width);
        Background.setFitHeight(height);
        Text Text=new Text(text);
        YesButton.setPrefHeight(1*height/10);
        YesButton.setPrefWidth(1*width/10);
        NoButton.setPrefHeight(1*height/10);
        NoButton.setPrefWidth(1*width/10);
        double YPosButton=(7/10)*height;
        double XPosButton=(width-(2/5)*width)/3;
        double fontsize=(8/10)*width*(72.272/2.54)/text.length();
        anchorPane.getChildren().addAll(Background);
        Text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,fontsize));
        LayoutNewContent.Add(anchorPane,Text,(2/10)*height,0,0,(1/10)*width);
        LayoutNewContent.Add(anchorPane,YesButton,0,0,0,XPosButton);
        LayoutNewContent.Add(anchorPane,NoButton,0,0,XPosButton,0);
        anchorPane.setTopAnchor(Background,0.0);
        anchorPane.setLeftAnchor(Background,0.0);





    }




    public static class Builder{
        private  Button YesButton=new Button();
        private  Button NoButton=new Button();
        private double height;
        private double width;
        private String text;
        private ImageView Background;


        private void SetImage(String route,Button btn){
            ImageView imageView=null;
            try {
                imageView=GetImages.getImageView(route);
            }
            catch (Exception e){
                System.out.println("falle en en obtener la images");
                System.out.println(e.getMessage());
            }
            btn=new Button("",imageView);
        }
        public Builder SetButton1Image(String route){
            SetImage(route,YesButton);
            return this;
        }
        public Builder SetButton2Image(String route){
            SetImage(route, NoButton);
            return this;
        }
        public Builder SetHeight(double height){
            this.height=height;
            return this;
        }
        public Builder SetWidth(double width){
            this.width=width;
            return this;
        }
        private void setAction(EventHandler<ActionEvent> eventEventHandler,Button button){
            if(button!=null){
                button.setOnAction(eventEventHandler);
            }
        }
        public Builder setAction1(EventHandler<ActionEvent> eventEventHandler){
            setAction(eventEventHandler,YesButton);
            return this;
        }
        public Builder setAction2(EventHandler<ActionEvent> eventEventHandler ){
            setAction(eventEventHandler,NoButton);
            return this;
        }
        public Builder setText(String text){
            this.text=text;
            return  this;
        }
        public Builder setBackGround(String text){
            try{
                Background=GetImages.getImageView(text);
            }
            catch(Exception e){

            }
            return this;
        }
        public DialogBox Build(){
           if(verify()){
              return  new DialogBox(this);
           }
            System.out.println("No todos los parametros estan");
           return null;
        }
        public boolean verify(){
            if(YesButton!=null && NoButton!=null && height>0 & width>0 && YesButton.getOnAction()!=null && NoButton.getOnAction()!=null && text!=null && Background!=null ){
                return true;
            }
            return false;
        }



    }
}
