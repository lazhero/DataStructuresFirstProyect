package cr.ac.tec.Minigames.PRS;

import javafx.scene.control.Button;

public class ExecuteButtonAction {
    private Button btn1;
    private Button btn2;
    public void setBtn1(Button btn){
        this.btn1=btn;
    }
    public void setBtn2(Button btn){
        this.btn2=btn;
    }
    public Button getBtn1(){
        return btn1;
    }
    public Button getBtn2(){
        return btn2;
    }
    public void illuminateBtn1(){
        if(btn1!=null){
            System.out.println("intente boton1");
            btn1.setStyle("-fx-background-color: #0078d7");
        }
    }
    public void illuminateBtn2(){
        if(btn2!=null){
            System.out.println("intente boton2");
            btn2.setStyle("-fx-background-color: #0078d7");
        }
    }
    public void turnoffBtn1(){
        if(btn1!=null){
            btn1.setStyle("-fx-background-color: #d6fbf8");
        }
    }
    public void turnoffBtn2(){
        if(btn2!=null){
            btn2.setStyle("-fx-background-color: #d6fbf8");
        }

    }
}
