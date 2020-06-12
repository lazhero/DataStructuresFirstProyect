package cr.ac.tec.Minigames.PRS;

import javafx.scene.control.Button;

/**
 *
 */
public class ExecuteButtonAction {
    private Button btn1;
    private Button btn2;

    /**
     * @author Andrey Zuñiga
     * @param btn
     */
    public void setBtn1(Button btn){
        this.btn1=btn;
    }

    /**
     * @author Andrey Zuñiga
     * @param btn
     */
    public void setBtn2(Button btn){
        this.btn2=btn;
    }

    /**
     * @author Andrey Zuñiga
     * @return
     */
    public Button getBtn1(){
        return btn1;
    }

    /**
     * @author Andrey Zuñiga
     * @return
     */
    public Button getBtn2(){
        return btn2;
    }

    /**
     * Illuminates the chosen button
     * @author Andrey Zuñiga
     */
    public void illuminateBtn1(){
        if(btn1!=null){

            btn1.setStyle("-fx-background-color: #0078d7");
        }
    }

    /**
     * Illuminates the chosen button
     * @author Andrey Zuñiga
     */
    public void illuminateBtn2(){
        if(btn2!=null){

            btn2.setStyle("-fx-background-color: #0078d7");
        }
    }

    /**
     * Turn off the lighting of the chosen button
     * @author Andrey Zuñiga
     */
    public void turnoffBtn1(){
        if(btn1!=null){
            btn1.setStyle("-fx-background-color: #d6fbf8");
        }
    }

    /**
     * Turn off the lighting of the chosen button
     * @author Andrey Zuñiga
     */
    public void turnoffBtn2(){
        if(btn2!=null){
            btn2.setStyle("-fx-background-color: #d6fbf8");
        }
    }
}
