package cr.ac.tec.Board.DialogBox;

import cr.ac.tec.Board.Other.LayoutCreation;
import cr.ac.tec.Board.Other.LayoutNewContent;
import cr.ac.tec.Images.GetImages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

    /**
     *
     * @param builder
     */
    protected DialogBox(Builder builder){
        this.NoButton=builder.NoButton;
        this.YesButton=builder.YesButton;
        this.Background=builder.Background;
        this.height=builder.height;
        this.width=builder.width;
        this.text=builder.text;
        this.anchorPane=null;
    }

    /**
     *
     * @param pane
     * @param xAxis
     * @param yAxis
     */
    public void Draw(AnchorPane pane,double xAxis,double yAxis){
        if(pane!=null && anchorPane!=null){
            LayoutNewContent.Add(pane,anchorPane,xAxis,0,0,yAxis);
        }
    }

    /**
     *
     */
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

        /**
         *
         * @param route
         * @param btn
         */
        private void SetImage(String route,Button btn){
            ImageView imageView=null;
            try {
                imageView=GetImages.getImageView(route);
            }
            catch (Exception e){

            }
            btn=new Button("",imageView);
        }

        /**
         *
         * @param route
         * @return
         */
        public Builder SetButton1Image(String route){
            SetImage(route,YesButton);
            return this;
        }

        /**
         *
         * @param route
         * @return
         */
        public Builder SetButton2Image(String route){
            SetImage(route, NoButton);
            return this;
        }

        /**
         *
         * @param height
         * @return
         */
        public Builder SetHeight(double height){
            this.height=height;
            return this;
        }

        /**
         *
         * @param width
         * @return
         */
        public Builder SetWidth(double width){
            this.width=width;
            return this;
        }

        /**
         *
         * @param eventEventHandler
         * @param button
         */
        private void setAction(EventHandler<ActionEvent> eventEventHandler,Button button){
            if(button!=null){
                button.setOnAction(eventEventHandler);
            }
        }

        /**
         *
         * @param eventEventHandler
         * @return
         */
        public Builder setAction1(EventHandler<ActionEvent> eventEventHandler){
            setAction(eventEventHandler,YesButton);
            return this;
        }

        /**
         *
         * @param eventEventHandler
         * @return
         */
        public Builder setAction2(EventHandler<ActionEvent> eventEventHandler ){
            setAction(eventEventHandler,NoButton);
            return this;
        }

        /**
         *
         * @param text
         * @return
         */
        public Builder setText(String text){
            this.text=text;
            return  this;
        }

        /**
         *
         * @param text
         * @return
         */
        public Builder setBackGround(String text){
            try{
                Background=GetImages.getImageView(text);
            }
            catch(Exception e){

            }
            return this;
        }

        /**
         *
         * @return
         */
        public DialogBox Build(){
           if(verify()){
              return  new DialogBox(this);
           }
           return null;
        }

        /**
         *
         * @return
         */
        public boolean verify(){
            if(YesButton!=null && NoButton!=null && height>0 & width>0 && YesButton.getOnAction()!=null && NoButton.getOnAction()!=null && text!=null && Background!=null ){
                return true;
            }
            return false;
        }
    }
}
